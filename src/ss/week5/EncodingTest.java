package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import com.sun.org.apache.xml.internal.security.Init;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException, Base64DecodingException {
        String input = "Hello World";
        String input2 = "Hello Big World";
        System.out.println(Hex.encodeHexString(input.getBytes()));
        System.out.println(Hex.encodeHexString(input2.getBytes()));
        //48656c6c6f20576f726c64
        //48656c6c6f20 42696720 576f726c64
        String input3 = new String("4d6f64756c652032");
        byte[] input4 = Hex.decodeHex(input3.toCharArray());
        String input5 = new String(input4);
        System.out.println(input5); //Module 2
        System.out.println(Base64.encode(input.getBytes()));
        //SGVsbG8gV29ybGQ=
        String input6 = new String("010203040506");
        byte[] input7 = Hex.decodeHex(input6.toCharArray());
        System.out.println(Base64.encode(input7));
        //AQIDBAUG, it has a smaller length
        Init.init();
        String inputI = "U29mdHdhcmUgU3lzdGVtcw==";
        byte[] input8 = Base64.decode(inputI);
        String input9 = new String(input8);
        System.out.println(input9);
        String a = "a";
        for (int i = 0; i < 10; i++) {
        	System.out.println(Base64.encode(a.getBytes()));
        	a += "a";
        }
        //It repeats every 4 characters and aa is not equal to double the base64 encoding of a.
    }
}
