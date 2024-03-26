package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadService {
    public static BufferedReader createReader(String path, String fileName) throws IOException {
        return new BufferedReader(new FileReader(path + "\\" + fileName));
    }
}