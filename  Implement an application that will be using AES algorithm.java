import javax.crypto.*;
import javax.crypto.spec.*; 
import java.util.*;
public class AES {
 public static void main(String[] args) throws Exception {
  String k="1234567890123456", t="Hello";
  SecretKeySpec s=new SecretKeySpec(k.getBytes(),"AES");
  Cipher c=Cipher.getInstance("AES");
  c.init(Cipher.ENCRYPT_MODE,s);
  String e=Base64.getEncoder().encodeToString(c.doFinal(t.getBytes()));
  c.init(Cipher.DECRYPT_MODE,s); 
  String d=new String(c.doFinal(Base64.getDecoder().decode(e)));
  System.out.println("Enc:"+e+"\nDec:"+d);
 }
}
