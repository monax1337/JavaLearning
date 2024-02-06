package learn.check;

public class IsPalindrome {
    public boolean isPalindrome (int num) {
        int reverse = 0;
        int tmp = num;
        while(tmp != 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return (num == reverse);
    }
}
