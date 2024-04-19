import java.util.List;
import java.util.Map;

import static service.FillHashMapService.fillHashMap;
import static service.FindKeyGreaterThanFiveService.findKeyGreaterThanFive;
import static service.FindKeyZeroService.findKeyZeroService;
import static service.FindMultiplyKeysService.findMultiplyKeys;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> hashMap = fillHashMap();

        List<String> stringsWithKeyGreaterThanFive = findKeyGreaterThanFive(hashMap);
        if (!stringsWithKeyGreaterThanFive.isEmpty()) {
            System.out.println("Строки с ключом > 5: " + String.join(" ", stringsWithKeyGreaterThanFive));
        } else {
            System.out.println("В HashMap нет строк, длина которых больше 5");
        }

        String stringWithKeyZero = findKeyZeroService(hashMap);
        if (!stringWithKeyZero.isEmpty()) {
            System.out.println("Строка с ключом 0: " + stringWithKeyZero);
        } else {
            System.out.println("В HashMap нет строки с ключом 0");
        }

        Integer product = findMultiplyKeys(hashMap);
        if (product != 1) {
            System.out.println("Произведение ключей, где длина строки > 5: " + product);
        } else {
            System.out.println("В HashMap нет ключей, где длина строки больше 5");
        }
    }
}
