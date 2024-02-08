package learn.convert;

public class Convert {
    public String convert(String number, int originSys, int finalSys) {
        int decimalNumber = Integer.parseInt(number, originSys);

        String result = Integer.toString(decimalNumber, finalSys);

        return result;
    }
}
