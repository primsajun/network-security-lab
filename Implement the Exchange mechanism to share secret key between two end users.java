import javax.crypto.KeyAgreement;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HexFormat;

public class DHExchange {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
        kpg.initialize(2048);
        KeyPair kp1 = kpg.generateKeyPair();
        KeyPair kp2 = kpg.generateKeyPair();

        KeyAgreement ka1 = KeyAgreement.getInstance("DH");
        ka1.init(kp1.getPrivate());
        KeyAgreement ka2 = KeyAgreement.getInstance("DH");
        ka2.init(kp2.getPrivate());

        ka1.doPhase(kp2.getPublic(), true);
        ka2.doPhase(kp1.getPublic(), true);

        byte[] secret1 = ka1.generateSecret();
        byte[] secret2 = ka2.generateSecret();

        System.out.println("Keys equal: " + java.util.Arrays.equals(secret1, secret2));
        System.out.println("Shared secret: " + HexFormat.of().formatHex(secret1));
    }
}
