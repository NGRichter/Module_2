package ss.week6;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Hex;

public class BruteForce {

	final int min;
	final int max;
	final int stringLength;
	public static Map<String, String> bruteMap;

  /**
   * One more element than <i>stringLength</i>,
   * to efficiently check for overflow.
   */
	private final int[] chars;

	public BruteForce(char min, char max, int len) {
		this.min = min;
		this.max = max;
		this.stringLength = len;

		chars = new int[stringLength + 1];
		Arrays.fill(chars, 1, chars.length, min);
	}

	public void run() {
		while (chars[0] == 0) {
			print();
			increment();
		}
	}

	private void increment() {
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] < max) {
				chars[i]++;
				return;
			}
			chars[i] = min;
		}
	}

	private void print() {
		try {
			char[] a = new char[stringLength];
			for (int i = 1; i < chars.length; i++) {
				a[i - 1] = (char) chars[i];
			}
			String b = new String(a);
			MessageDigest md = MessageDigest.getInstance("MD5");
	    	byte[] hash = md.digest(b.getBytes());
			bruteMap.put(b, Hex.encodeHexString(hash));

		} catch (NoSuchAlgorithmException e) {
		}

	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		bruteMap = new HashMap<String, String>();
		new BruteForce('a', 'z', 4).run();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	public static Map<String, String> start(int length) {
		bruteMap = new HashMap<String, String>();
		new BruteForce((char) 32, (char) 126, length).run();
		return bruteMap;
	}

}