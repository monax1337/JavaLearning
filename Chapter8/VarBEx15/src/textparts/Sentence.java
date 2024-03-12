package textparts;

public class Sentence {
    private String sentence;

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String transformSentence() {
        StringBuilder transformedSentence = new StringBuilder();
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            Word w = new Word(word);
            transformedSentence.append(w.transformWord()).append(" ");
        }
        return transformedSentence.toString().trim();
    }

    @Override
    public String toString() {
        return transformSentence();
    }
}
