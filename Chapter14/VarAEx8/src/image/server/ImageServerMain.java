package image.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ImageServerMain {
    private static final Map<String, ClientHandler> clients = new HashMap<>();

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8071)) {
            System.out.println(serverSocket.getInetAddress() + " server started");
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostAddress() + " connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.put(socket.getInetAddress().getHostAddress(), clientHandler);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handleImageData(ImageData imageData) {
        String recipientIP = imageData.recipientIP();
        ClientHandler recipient = clients.get(recipientIP);
        if (recipient != null) {
            recipient.sendImageData(imageData);
        } else {
            System.out.println("Recipient not found: " + recipientIP);
        }
    }
}
