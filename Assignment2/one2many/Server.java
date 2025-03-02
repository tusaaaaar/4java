import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6666); // Server start ho gaya
            System.out.println("Server chalu, clients ka intezar...");

            while (true) {
                Socket s = ss.accept(); // Client connect ho raha hai
                System.out.println("Client " + s.getPort() + " connected");

                // Naya client aaya toh uske liye alag thread banayenge
                ClientHandler handler = new ClientHandler(s);
                Thread thread = new Thread(handler);
                thread.start();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}

// Har client ke liye ek alag handler
class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataIn = new DataInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            String msg = "";

            while (!msg.equals("over")) { // Jab tak "over" na aaye, message accept karte raho
                msg = dataIn.readUTF();
                System.out.println("Client " + clientSocket.getPort() + ": " + msg);
            }

            System.out.println("Client " + clientSocket.getPort() + " ne chat band kar di!");

            dataIn.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error in client handler: " + e);
        }
    }
}
