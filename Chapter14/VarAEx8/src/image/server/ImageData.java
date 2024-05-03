package image.server;

import java.io.Serializable;

public record ImageData(byte[] imageBytes, String recipientIP) implements Serializable {
}
