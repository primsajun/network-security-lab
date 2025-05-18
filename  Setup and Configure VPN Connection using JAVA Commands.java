import java.io.*;

public class VPN {
    public static void main(String[] args) throws Exception {
        String v = "MyVPN"; // VPN
        String u = "user";  // user
        String p = "pass";  // pass

        String c = String.format("rasdial \"%s\" %s %s", v, u, p);
        Process pr = new ProcessBuilder("cmd.exe", "/c", c).start();

        BufferedReader r = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        String l;
        while ((l = r.readLine()) != null)
            System.out.println(l);

        int e = pr.waitFor();
        System.out.println("Exit: " + e);
    }
}
