package chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {
    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 8071);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println(message);
            }

        } catch (UnknownHostException e) {
            System.err.println("Connection refused:" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
