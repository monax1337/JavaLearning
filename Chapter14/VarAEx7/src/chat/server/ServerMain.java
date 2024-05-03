package chat.server;

import chat.server.service.ServerThreadService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8071)) {
            System.out.println(serverSocket.getInetAddress() + " server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getInetAddress().getHostName() + " connected");
                ServerThreadService thread = new ServerThreadService(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
