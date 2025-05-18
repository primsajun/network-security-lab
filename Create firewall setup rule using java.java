import java.io.*;  
public class FWRule {  
    public static void main(String[] args) {  
        String cmd = "netsh advfirewall firewall add rule name=\"B8080\" dir=in action=block protocol=TCP localport=8080";  
        try {  
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", cmd);  
            pb.inheritIO();  
            Process p = pb.start();  
            int code = p.waitFor();  
            System.out.println("Done, code: " + code);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}


/*

output:
Done, code: 0

*/





