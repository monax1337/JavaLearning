package credit;

public class Credit {
    private String bankName;
    private double interestRate;
    private int maxLoanAmount;

    public Credit(String bankName, double interestRate, int maxLoanAmount) {
        this.bankName = bankName;
        this.interestRate = interestRate;
        this.maxLoanAmount = maxLoanAmount;
    }

    public String getBankName() {
        return bankName;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public double calculateMonthlyPayment(int loanAmount, int loanTermMonths) {
        double monthlyInterestRate = interestRate / 12 / 100;
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -loanTermMonths));
    }
}