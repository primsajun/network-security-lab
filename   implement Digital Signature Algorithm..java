import java.security.*;
public class DSA {
  public static void main(String[] a) throws Exception {
    KeyPair k=KeyPairGenerator.getInstance("RSA").generateKeyPair();
    Signature s=Signature.getInstance("SHA256withRSA");
    byte[] m="msg".getBytes();
    s.initSign(k.getPrivate()); 
    s.update(m); byte[] sig=s.sign();
    s.initVerify(k.getPublic()); 
    s.update(m); 
    System.out.println("DSA verify:"+ s.verify(sig));
  }
}


/*
output:

DSA verify:true

*/
