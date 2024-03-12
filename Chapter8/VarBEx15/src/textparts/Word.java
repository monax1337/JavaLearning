package textparts;

public class Word {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String transformWord() {
        char firstChar = word.charAt(0);
        StringBuilder transformedWord = new StringBuilder();
        transformedWord.append(firstChar);
        for (int i = 1; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (Character.toLowerCase(currentChar) != Character.toLowerCase(firstChar)) {
                transformedWord.append(currentChar);
            }
        }
        return transformedWord.toString();
    }

    @Override
    public String toString() {
        return transformWord();
    }
}
