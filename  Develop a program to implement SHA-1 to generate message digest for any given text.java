import java.security.*;
import java.util.*; 
public class SHA1Short {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = s.nextLine();
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hash = md.digest(input.getBytes());
        StringBuilder hex = new StringBuilder();
        for (byte b : hash) hex.append(String.format("%02x", b));
        System.out.println("SHA-1: " + hex);
    }
}


/*

output:

Enter text: prime
SHA-1: ea756c3ad19a39cfcc25922ff018ba8f797c88c3

*/
