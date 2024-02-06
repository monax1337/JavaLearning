package learn.sum;

public class Sum {
    public int calculateSum(String[] args) {
        int sum = 0;
        for (String arg : args) {
            sum += Integer.parseInt(arg);
        }
        return sum;
    }

    public void outputSum(int sum) {
        System.out.println("Sum = " + sum);
    }
}
