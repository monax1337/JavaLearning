import textparts.Sentence;

public class Main {
    public static void main(String[] args) {
        String text = "Это пример текс.Здесь есть слова разной длины.";

        String[] sentences = text.split("(?<=[.!?])\\s*");

        for (String sentence : sentences) {
            Sentence s = new Sentence(sentence);
            System.out.println(s.transformSentence(5, "замена"));
        }
    }
}
