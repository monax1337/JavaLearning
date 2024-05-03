package calculator;

import calculator.service.GoogleSheetsService;

import java.io.IOException;
import java.util.List;

public class GoogleSheetsCalculator {
    private static final String SPREADSHEET_ID = "1dKjjhi__WT1H05CnpqlSQemQc6Q7tRhQiW6TL28TdXg";

    public static void main(String[] args) throws IOException {
        GoogleSheetsService sheetsService = new GoogleSheetsService();

        String range = "Sheet1!A1:B2";

        List<List<Object>> values = sheetsService.getValues(SPREADSHEET_ID, range);

        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            double a = Double.parseDouble((String) values.get(0).getFirst());
            double b = Double.parseDouble((String) values.get(1).getFirst());
            String operator = (String) values.get(0).get(1);

            double result = 0;

            switch (operator) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    System.out.println("Invalid operator");
            }

            System.out.println("Result: " + result);
        }
    }
}
