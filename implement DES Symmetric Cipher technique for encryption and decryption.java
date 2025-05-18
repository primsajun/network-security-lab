import javax.crypto.*; 
import javax.crypto.spec.*;
import java.util.*;  
public class DES {
  public static void main(String[] args) throws Exception {
    KeyGenerator kg = KeyGenerator.getInstance("DES"); 
    SecretKey key = kg.generateKey();
    Cipher c = Cipher.getInstance("DES"); 
    String msg = "Hello";
    c.init(Cipher.ENCRYPT_MODE, key);
    byte[] enc = c.doFinal(msg.getBytes());
    System.out.println("Encrypted: " + Base64.getEncoder().encodeToString(enc));
    c.init(Cipher.DECRYPT_MODE, key);
    byte[] dec = c.doFinal(enc);
    System.out.println("Decrypted: " + new String(dec));
  }
}

/*
output:

Encrypted: YZ1eb3PRBtA
Decrypted: Hello

*/
