package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteService {
    public static BufferedWriter createWriter(String path, String fileName) throws IOException {
        return new BufferedWriter(new FileWriter(path + "\\" + fileName, true));
    }
}