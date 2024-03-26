import service.ReadService;
import service.TextProcessingService;
import service.WriteService;

import java.io.*;
import java.util.Properties;

public class Main {
    private static final String CONFIG_FILE_PATH = "C:\\Users\\maxff\\Desktop\\JavaLearning\\Chapter10\\VarAEx7\\src\\config\\file_paths.properties";

    public static void main(String[] args) {
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(CONFIG_FILE_PATH));

            String inputWildHuntName = properties.getProperty("wild_hunt_input_file_name");
            String outputWildHuntName = properties.getProperty("wild_hunt_output_file_name");
            String inputWildHuntPath = properties.getProperty("wild_hunt_input_file_path");
            String outputWildHuntPath = properties.getProperty("wild_hunt_output_file_path");

            try (BufferedReader reader = ReadService.createReader(inputWildHuntPath, inputWildHuntName);
                 BufferedWriter writer = WriteService.createWriter(outputWildHuntPath, outputWildHuntName)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String processedLine = TextProcessingService.processLine(line);
                    writer.write(processedLine);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
