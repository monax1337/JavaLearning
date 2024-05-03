package chat.server.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ServerThreadService extends Thread {
    private static Set<ServerThreadService> clients = new HashSet<>();
    private BufferedReader reader;
    private PrintStream printStream;
    private InetAddress address;

    public ServerThreadService(Socket socket) {
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printStream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        address = socket.getInetAddress();
        clients.add(this);
        broadcastMessage("New client connected: " + address.getHostAddress(), this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = reader.readLine();
                if (message != null) {
                    broadcastMessage(message, this);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clients.remove(this);
            broadcastMessage("Client disconnected: " + address.getHostAddress(), null);
        }
    }

    private void broadcastMessage(String message, ServerThreadService sender) {
        for (ServerThreadService client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    private void sendMessage(String message) {
        printStream.println(message);
    }
}