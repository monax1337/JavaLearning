import textparts.Sentence;

public class Main {
    public static void main(String[] args) {
        String text = "Это    припмер    текста   для     проверки      работы   приложения.      В     нем     могут   быть     и      табуляции      и     много      пропппбелов.\nJava   регуррлярнррые   выражевввния   используются   для   обработки    текста.";

        String[] sentences = text.split("(?<=[.!?])\\s*");

        for (String sentence : sentences) {
            Sentence s = new Sentence(sentence);
            System.out.println(s);
        }
    }
}
