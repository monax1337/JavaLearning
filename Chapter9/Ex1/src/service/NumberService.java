package service;

import java.text.*;
import java.util.Locale;

public class NumberService {
    public static double parseNumber(String numberStr, String locale) throws InvalidDataException {
        try {
            NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale(locale));
            return numberFormat.parse(numberStr).doubleValue();
        } catch (ParseException e) {
            throw new InvalidDataException("Invalid number format: " + numberStr);
        } catch (IllegalArgumentException e) {
            throw new InvalidDataException("Invalid locale: " + locale);
        }
    }
}
