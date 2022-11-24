import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Darklet {
    public static void main(String[] args) throws IOException {
        String command = "powershell.exe C:\\Users\\Teagan.TEAGAN-9I\\Desktop\\Darklet\\src\\scripts\\Retrieve-NTEvent.ps1";
        Process powerShellProcess = Runtime.getRuntime().exec(command);

        powerShellProcess.getOutputStream().close();
        String line;
        System.out.println("Standard Output:");
        BufferedReader stdout = new BufferedReader(new InputStreamReader(
                powerShellProcess.getInputStream()));
        while ((line = stdout.readLine()) != null) {
            System.out.println(line);
        }
        stdout.close();

        System.out.println("Done");
    }
}
