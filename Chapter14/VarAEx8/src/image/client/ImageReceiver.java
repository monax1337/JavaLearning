package image.client;

import image.server.ImageData;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ImageReceiver extends Thread{
    private final ObjectInputStream inputStream;

    public ImageReceiver(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object object = inputStream.readObject();
                if (object instanceof ImageData imageData) {
                    byte[] imageBytes = imageData.imageBytes();
                    System.out.println("Received image with " + imageBytes.length + " bytes from " + imageData.recipientIP());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
