import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String RESOURCE_PATH = "C:\\Users\\maxff\\Desktop\\JavaLearning\\Chapter10\\VarCEx16\\src\\resources";
    private static final String TEXT_OUTPUT_FILE_NAME = "text_output.txt";

    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                throw new IllegalArgumentException("Usage: java FindLineNumbers <filename> <searchString>");
            }

            String filename = args[0];
            String searchString = args[1];

            try {
                File outputFile = new File(RESOURCE_PATH, TEXT_OUTPUT_FILE_NAME);
                File inputFile = new File(RESOURCE_PATH, filename);

                try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                    String line;
                    int lineNumber = 1;
                    while ((line = reader.readLine()) != null) {
                        if (containsSearchString(line, searchString)) {
                            writer.write("Line " + lineNumber + ": " + line + "\n");
                        }
                        lineNumber++;
                    }
                    System.out.println("Results written to resources/text_output.txt");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean containsSearchString(String line, String searchString) {
        List<String> words = Arrays.asList(line.split("\\s+"));
        return words.stream()
                .anyMatch(word -> word.equals(searchString));
    }
}
