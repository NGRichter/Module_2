
package ss.week7.cmdline;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Server. 
 * @author  Theo Ruys
 * @version 2005.02.21
 */
public class Server {
    private static final String USAGE
        = "usage: " + Server.class.getName() + " <name> <port>";

    /** Starts a Server-application. */
    public static void main(String[] args) {
    	try {
    		int port = Integer.parseInt(args[1]);
			ServerSocket sock = new ServerSocket(port);
			Socket client = sock.accept();
			Peer peer = new Peer(args[0], client);
			Thread t1 = new Thread(peer);
			t1.start();
			peer.handleTerminalInput();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("The port you specified is not a valid number");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(USAGE);
		}
   	}
} // end of class Server
