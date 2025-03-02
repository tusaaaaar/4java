import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Server se connect ho raha hai
            Socket socket = new Socket("localhost", 6666);
            System.out.println("Server se connection ho gaya!");

            DataInputStream consoleIn = new DataInputStream(System.in);
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

            String msg = "";

            // Jab tak "over" nahi likhoge, tab tak message bhej sakte ho
            while (!msg.equals("over")) {
                msg = consoleIn.readLine();
                dataOut.writeUTF(msg);
            }

            System.out.println("Tumne chat band kar di!");

            consoleIn.close();
            dataOut.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
