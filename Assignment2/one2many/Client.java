import java.io.*;
import java.net.*;

public class ClientSideThree {
    public static void main(String[] args) {
        try {
            // Server se connection banane ki koshish
            Socket socket = new Socket("localhost", 6666);
            System.out.println("Server se connection ho gaya!");

            // User se input lene ke liye stream
            DataInputStream consoleIn = new DataInputStream(System.in);

            // Server ko data bhejne ke liye stream
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

            String msg = "";

            // Jab tak "over" nahi likhoge, tab tak message bheja ja sakta hai
            while (!msg.equals("over")) {
                System.out.print("Message likho: ");
                msg = consoleIn.readLine(); // Console se user ka message lena
                dataOut.writeUTF(msg); // Server ko bhejna
            }

            // User ne chat band kar di, ab connection close karna hai
            System.out.println("Tumne chat band kar di!");

            // Streams aur socket close karna zaroori hai
            consoleIn.close();
            dataOut.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
