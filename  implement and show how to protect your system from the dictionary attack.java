import java.util.*;
import java.security.*;
import javax.crypto.*; 
import javax.crypto.spec.PBEKeySpec;
public class ShortAuth {
  static Map<String,String> h=new HashMap<>(),s=new HashMap<>(); static Map<String,Integer> t=new HashMap<>();
  static String salt()
  {
      byte[] b=new byte[16];
      new SecureRandom().nextBytes(b);
      return Base64.getEncoder().encodeToString(b);
      
  }
  static String hash(String p,String s)throws Exception
  {
      PBEKeySpec sp=new PBEKeySpec(p.toCharArray(),Base64.getDecoder().decode(s),65536,128);
      return Base64.getEncoder().encodeToString(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(sp).getEncoded());
      
  }
  static void reg(String u,String p)throws Exception{s.put(u,salt());
  h.put(u,hash(p,s.get(u)));
  t.put(u,0);}
  static void log(String u,String p)throws Exception
  {
      if(!h.containsKey(u))System.out.println("no user");
  else if(t.get(u)>=3)System.out.println("locked");
    else if(h.get(u).equals(hash(p,s.get(u))))
    {
        System.out.println("ok");
        t.put(u,0);
        
    }
    else
    {
        t.put(u,t.get(u)+1);
        System.out.println("bad");
        
    }
      
  }
  public static void main(String[]a)throws Exception{Scanner sc=new Scanner(System.in);
  System.out.print("NEW USER NAME: ");
  String u=sc.nextLine();
    System.out.print("PASSWORD: ");
    String p=sc.nextLine();
    reg(u,p);
    for(int i=0;i<4;i++)
    {
        System.out.print("USER NAME: ");
        String u2=sc.nextLine();
    System.out.print("PASSWORD: ");
    String p2=sc.nextLine();
    log(u2,p2);
        
    }
      
  }
}


/* 
output:
NEW USER NAME: prime
PASSWORD: 1234
USER NAME: prime
PASSWORD: 1234
ok
*/
