package textparts;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String replaceWord(int length, String replacement) {
        if (word.length() == length + 1 && "[.!?]".indexOf(word.charAt(length)) != -1){
            return replacement + word.charAt(length);
        }
        if (word.length() == length && "[.!?]".indexOf(word.charAt(length -1)) == -1) {
            return replacement;
        }
        return word;
    }
}
