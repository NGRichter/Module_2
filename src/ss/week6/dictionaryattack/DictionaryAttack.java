package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;

import ss.week6.BruteForce;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled withthe content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 * @throws IOException 
	 */
	public void readPasswords(String filename) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (true) {
			String login = null;
			login = reader.readLine();

			if (login == null) {
				break;
			}
			String[] user = login.split(": ");
			passwordMap.put(user[0], user[1]);
		}
		reader.close();

	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
	    	byte[] hash = md.digest(password.getBytes());
	    	return Hex.encodeHexString(hash);

		} catch (NoSuchAlgorithmException e) {
			return null;
		}

	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        for (String users : passwordMap.keySet()) {
        	if (users.equals(user)) {
        		return passwordMap.get(users).equals(getPasswordHash(password));
        	}
        }
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    public void addToHashDictionary(String filename) {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			try {
				writer = new BufferedWriter(new FileWriter("Dictionaryattack.txt"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
		    MessageDigest md = MessageDigest.getInstance("MD5");   
		    while (true) {
				String password = "";
				try {
					password = reader.readLine();
				} catch (IOException e) {
					break;
				}
			   	if (password == null) {
			   		break;
			   	}
			  	byte[] hash = md.digest(password.getBytes());
			   	String hexencoding = Hex.encodeHexString(hash);
			   	hashDictionary.put(password, hexencoding);
			   	try {
					writer.write(hexencoding + " " + password);
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
		   	}
		} catch (NoSuchAlgorithmException e) {
        		
		}
		try {
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	/**
	 * Do the dictionary attack.
	 * @throws IOException 
	 */
	public void doDictionaryAttack() throws IOException {
		long start = System.currentTimeMillis();
        hashDictionary = new HashMap<String, String>();
		passwordMap = new HashMap<String, String>();
		//addToHashDictionary("rockyou.txt"); //117 out of 136
		readPasswords("password.txt");
		hashDictionary = BruteForce.start(5);
		int i = 0;
		for (String user : passwordMap.keySet()) {
			for (String word : hashDictionary.keySet()) {
				if (passwordMap.get(user).equals(hashDictionary.get(word))) {
					System.out.println(user + " - " + word);
					i++;
					break;
				}
			}
		}
		System.out.println("Cracked " + i + " out of " + passwordMap.size());
		long end = System.currentTimeMillis();
		System.out.println("It took " + (end - start) + "milliseconds, which is " + (end - start) / 1000.0 + " seconds.");
	}
	//it would take at most 456976 tries and the average is about half so 228488.
	/*brent has password: 123456
skyler has password: carwash
kasper has password: computer
bernadette has password: yeahyeahyeah
alice has password: tree
charles has password: superman
todd has password: coffee
jim has password: Password123
keith has password: 112233
elmer has password: harley
pete has password: badboy
ted has password: 123456
kathleen has password: whatever
sanne has password: bubbles
victor has password: letmein
antonia has password: 2000
raj has password: password
noel has password: sarah
dustin has password: pussy
corey has password: jukilo
jane has password: plane
pearl has password: smiley
maarten has password: aaaaaaaaaa
margie has password: batman
evelyn has password: trustno1
ivan has password: opop1212
christine has password: qwerty
mitchell has password: tigers
steven has password: password2
boris has password: football
theresa has password: butterfly1
leslie has password: lasers
debra has password: password
frank has password: secret
paula has password: charmed
lavina has password: secret
lars has password: 7777777
hank has password: bigguns
harry has password: dragon
james has password: bythelake
melissa has password: peaches
gloria has password: foobar
kelly has password: 123456
hans has password: hellohello
katrine has password: spongebob
peter has password: dragon
ian has password: porsche123
catherine has password: 111111
steve has password: green
fred has password: password
yvonne has password: pretty1
walter has password: 123456
norma has password: strawberry
barney has password: dragon
rachel has password: leonardo
gustavo has password: chicken
stuart has password: janice
rose has password: motorola
paul has password: abcdef
bea has password: trix
holly has password: 696969
diane has password: password
sharon has password: matrix
allen has password: pluto
donna has password: abc123
stephanie has password: biteme
brenda has password: 12345678
joey has password: asdf1234
ben has password: shadow
angel has password: big123
john2 has password: 1234567
gary has password: tigger
brandon has password: monkey
torben has password: donkey
jean has password: trustno1
pam has password: mercedes
homer has password: yeahyeah
ralph has password: britney
sheldon has password: starwars
adam has password: bigdog
gretchen has password: greymatter
pat has password: 123456
caroline has password: jordan
irvin has password: wtfstfu
jamie has password: harrison
bob has password: password
susan has password: scarface
larry has password: diamond
dave has password: password
martha has password: trustno1
mike has password: 50cent
sean has password: 123456
amy has password: asdfasdf
rita has password: password123
marie has password: horses
patrick has password: aaaaa
elvis has password: jailhouse
maria has password: asshole
thomas has password: julius
wanda has password: wildcats
lois has password: blink182
ann has password: qwerty
lydia has password: november
stephen has password: moremoney
harold has password: password123
raymond has password: trustno1
hanne has password: whitewine
alberta has password: 123456
irene has password: 123456
jeffrey has password: Go4It!
michael has password: samsung
leonard has password: heather
anthony has password: mustang
grant has password: qawsedrf
penny has password: blondie
timothy has password: serenity
rebecca has password: soccer1
Cracked 117 out of 136
	*/
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		try {
			da.doDictionaryAttack();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
