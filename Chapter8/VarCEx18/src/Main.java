public class Main {
    public static void main(String[] args) {
        String sentence = "В предложении из n слов первое слово поставить на место второго, второе — на место третьего и т.д., (n-1)-е слово — на место n-го, n-е слово поставить на место первого.";
        StringBuilder transformedSentence = new StringBuilder();
        String[] words = sentence.split("\\s+");

        String temp = words[words.length - 1];
        for (int i = words.length - 1; i > 0; i--) {
            words[i] = words[i - 1];
        }
        words[0] = temp;

        for (String word : words){
            transformedSentence.append(word).append(" ");
        }

        System.out.println(transformedSentence.toString().trim());
    }
}
