package image.client;

import image.server.ImageData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ImageClientMain {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket(InetAddress.getLocalHost(), 8071);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())
        ) {
            ImageReceiver imageReceiver = new ImageReceiver(inputStream);
            imageReceiver.start();

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Enter 'send' to send an image or 'exit' to quit");
                while (true) {
                    String input = scanner.nextLine();
                    if (input.equalsIgnoreCase("send")) {
                        sendImage(outputStream);
                    } else if (input.equalsIgnoreCase("exit")) {
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendImage(ObjectOutputStream outputStream) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter recipient IP address: ");
            String recipientIP = scanner.nextLine();

            System.out.print("Enter image file path: ");
            String filePath = scanner.nextLine();
            byte[] imageBytes = ImageLoader.loadImage(filePath);
            if (imageBytes != null) {
                ImageData imageData = new ImageData(imageBytes, recipientIP);
                outputStream.writeObject(imageData);
                outputStream.flush();
                System.out.println("Image sent to " + recipientIP);
            } else {
                System.out.println("Failed to load image from " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
