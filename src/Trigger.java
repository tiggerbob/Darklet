import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trigger extends Thread {
    static String command = "powershell.exe C:\\Users\\Teagan.TEAGAN-9I\\Desktop\\Darklet\\src\\scripts\\Retrieve-NTEvent.ps1";

    static void logEvents() throws IOException {
        Process powerShellProcess = Runtime.getRuntime().exec(command);

        powerShellProcess.getOutputStream().close();
        String line;
        BufferedReader stdout = new BufferedReader(new InputStreamReader(
                powerShellProcess.getInputStream()));
        FileWriter fileWriter = new FileWriter("C:\\$CENTER\\log.txt");

        while ((line = stdout.readLine()) != null) {
            fileWriter.write(line);
            fileWriter.write("\n");
        }
        stdout.close();
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            logEvents();
            sleep(2000);
        }
    }
}
