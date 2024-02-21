package credit;

public class IncreasedCreditLimit extends Credit{
    private int creditLimit;

    public IncreasedCreditLimit(String bankName, double interestRate, int maxLoanAmount, int creditLimit) {
        super(bankName, interestRate, maxLoanAmount);
        this.creditLimit = creditLimit;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void increaseCreditLimit(int amount) {
        creditLimit += amount;
        System.out.println("Кредитная линия " + getBankName() + " увеличена на " + amount + ". Новая кредитная линия: " + creditLimit);
    }
}
