import service.InvalidDataException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static service.NumberService.parseNumber;

public class Main {
    public static void main(String[] args) {
        String filename = "src/resources/numbers_with_locale.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            double sum = 0;
            int count = 0;

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length != 2) {
                    throw new InvalidDataException("Invalid data format in file");
                }

                String numberStr = parts[0];
                String locale = parts[1];

                try {
                    double number = parseNumber(numberStr, locale);
                    sum += number;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format: " + numberStr);
                } catch (InvalidDataException e) {
                    System.out.println("Invalid locale: " + locale);
                }
            }

            if (count > 0) {
                double average = sum / count;
                System.out.printf("Sum of numbers: %.4f\nAverage of numbers: %.4f\n", sum, average);
            } else {
                System.out.println("No valid numbers found in the file");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (InvalidDataException e) {
            System.out.println("Invalid data: " + e.getMessage());
        }
    }
}
