package ss.week7.cmdline;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketException;

/**
 * Peer for a simple client-server application
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Peer implements Runnable {
    public static final String EXIT = "exit";

    protected String name;
    protected Socket sock;
    protected BufferedReader in;
    protected BufferedWriter out;
    private volatile boolean running = true;
    
    public void terminate() {
    	running = false;
    }

    
    
    /*@
       requires (nameArg != null) && (sockArg != null);
     */
    /**
     * Constructor. creates a peer object based in the given parameters.
     * @param   nameArg name of the Peer-proces
     * @param   sockArg Socket of the Peer-proces
     */
    public Peer(String nameArg, Socket sockArg) throws IOException {
    	this.name = nameArg;
    	this.sock = sockArg;
    	in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
    	out = new BufferedWriter(new OutputStreamWriter(sock.getOutputStream()));
    }

    /**
     * Reads strings of the stream of the socket-connection and
     * writes the characters to the default output.
     */
    public void run() {
    	while (running) {
    		try {
				String temp = in.readLine();
				if (temp == null) {
					shutDown();
					System.out.println("Your chat partner has disconnected! (output)");
				} else {
					System.out.println("\nMessage from " + sock.getInetAddress() + ": " + temp);
				}
			} catch (IOException e) {
				break;
			}
    	}
    }


    /**
     * Reads a string from the console and sends this string over
     * the socket-connection to the Peer process.
     * On Peer.EXIT the method ends
     */
    public void handleTerminalInput() {
    	while (running) {
        	String temp = readString(getName() + ": ");
        	if (temp.equals("exit")) {
        		System.out.println("System will shut down");
        		shutDown();
        	}
        	try {
    			out.write(temp + "\n");
    	    	out.flush();
    		} catch (SocketException e) {
    			System.out.println("Your chat partner disconnected! (input)");
    			break;
    		} catch (IOException e) {
				shutDown();
			}
    		
    	}

    	
    }

    /**
     * Closes the connection, the sockets will be terminated
     */
    public void shutDown() {
    	try {
			out.close();
	    	in.close();
	    	sock.close();
	    	System.in.close();
	    	running = false;
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    /**  returns name of the peer object. */
    public String getName() {
        return name;
    }

    /** read a line from the default input. */
    static public String readString(String tekst) {
        System.out.print(tekst);
        String antw = null;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    System.in));
            antw = in.readLine();
        } catch (IOException e) {
        }

        return (antw == null) ? "" : antw;
    }
}
