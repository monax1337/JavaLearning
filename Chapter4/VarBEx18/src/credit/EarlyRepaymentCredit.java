package credit;

public class EarlyRepaymentCredit extends Credit {
    private boolean earlyRepaymentAllowed;

    public EarlyRepaymentCredit(String bankName, double interestRate, int maxLoanAmount, boolean earlyRepaymentAllowed) {
        super(bankName, interestRate, maxLoanAmount);
        this.earlyRepaymentAllowed = earlyRepaymentAllowed;
    }

    public boolean isEarlyRepaymentAllowed() {
        return earlyRepaymentAllowed;
    }

    public void makeEarlyRepayment(int amount) {
        System.out.println("Досрочное погашение кредита " + getBankName() + " в размере " + amount + " произведено успешно.");
    }
}
