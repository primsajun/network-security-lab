import java.security.*;

public class MD5 {
    public static void main(String[] args) throws Exception {
        String s = "Hello";
        MessageDigest m = MessageDigest.getInstance("MD5");
        byte[] d = m.digest(s.getBytes());
        StringBuilder h = new StringBuilder();
        for (byte b : d) h.append(String.format("%02x", b));
        System.out.println("Text : "+s );
        System.out.println(h );
        
    }
}

/*
output:

Text : Hello
8b1a9953c4611296a827abf8c47804d7

*/
