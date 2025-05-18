import javax.crypto.Mac; 
import javax.crypto.spec.SecretKeySpec;
public class HMAC {
    public static void main(String[] args) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec("secretkey123".getBytes(), "HmacSHA256"));
        byte[] hmac = mac.doFinal("Confidential Message".getBytes());
        System.out.printf("HMAC : ");
        for (byte b : hmac) System.out.printf("%02x", b);
        
    }
    
}

/*
output:

HMAC : 01b7a134ce2d2402239a7a2485cc3df50bf06e3f32a65777353e04a05d865f31

*/
