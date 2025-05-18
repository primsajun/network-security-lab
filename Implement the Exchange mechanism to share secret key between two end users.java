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

/*

output:

Keys equal: true
Shared secret: a7850a90c6c5b07da13b5743f8fd4e787ba3b3ad8e0fd5ec3ae1f064b49b44383dc062488db87a048aab2678cb1225cb56ef1639397c2e95423af31e4f2842527480a423fcf03e735f16c008bf3a28774dce4bec1ab59de9afc36f1de972cc53692e91b7aa25cd87fc02e21fb8f82127597e3dede3b4b8842549db0d72bc73bb0331ab1a956f711e6c4959a2277c37a0e867c51cccdabcccd0616a227fb09e6f2fe46d16aa2546da5b93dd69bee59862763883a3b328e68e9dd77eef3970bb77a76e843ba20a12f5f0eb2af837b07d81f30a74e32b0824842ce7b0a85539f9ca7c8e77c5d401a987575be7fc982d5b1c8bf3a3eae413b6ccd356a6de28e7fbaf


*/
