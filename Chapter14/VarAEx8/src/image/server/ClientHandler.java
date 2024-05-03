package image.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler extends Thread {
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ClientHandler(Socket socket) {
        try {
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object object = inputStream.readObject();
                if (object instanceof ImageData) {
                    ImageServerMain.handleImageData((ImageData) object);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendImageData(ImageData imageData) {
        try {
            outputStream.writeObject(imageData);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
