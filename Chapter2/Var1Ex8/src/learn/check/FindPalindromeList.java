package learn.check;

public class FindPalindromeList {
    public int[] findPalindromeList(int[] numbers) {
        /*
            @return int[]
            @param int[] numbers
        **/
        IsPalindrome pal = new IsPalindrome();
        int countPalindromes = 0;
        for (int number : numbers) {
            if (pal.isPalindrome(number)) {
                countPalindromes++;
            }
        }

        int[] palindromes = new int[countPalindromes];
        int index = 0;
        for (int number : numbers) {
            if (pal.isPalindrome(number)) {
                palindromes[index] = number;
                index++;
            }
        }
        return palindromes;
    }


}
