import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Server se connection bana raha hai
            Socket s = new Socket("localhost", 6666);

            // User se input lene ke liye
            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

            // Server ko message bhejne ke liye
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream());

            String msg = "";

            // Jab tak "over" nahi likhte, tab tak message bhej sakte ho
             while (!msg.equalsIgnoreCase("exit")) {
                System.out.print("Message likho (exit likhne se band hoga): ");
                msg = dataIn.readLine();
                dataOut.writeUTF(msg);
                dataOut.flush();
            }

            // Sab kuch band kar rahe hain
            dataIn.close();
            dataOut.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

