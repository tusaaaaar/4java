import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            // 🔹 ServerSocket bana rahe hain jo port 6666 par chalega
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server Start ho gaya, client ka wait kar raha hai...");

            // 🔹 Client ka connection accept kar raha hai
            Socket s = ss.accept();
            System.out.println("Client se connection successful!");

            // 🔹 Client se data lene ke liye DataInputStream bana rahe hain
            DataInputStream dataIn = new DataInputStream(new BufferedInputStream(s.getInputStream()));

            String msg = "";

            // 🔹 Jab tak client "exit" nahi bhejta, tab tak messages receive karte rahenge
            while (!msg.equals("exit")) {
                msg = dataIn.readUTF();
                System.out.println("Client: " + msg);
            }

            // 🔹 Jab client "over" bhej de, toh server band kar do
            System.out.println("Client ne chat band kar di, server bhi band ho raha hai...");

            // 🔹 Saare resources close kar rahe hain
            ss.close();
            s.close();
            dataIn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

