public class SavingsAccount {

    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance) {
        this.savingsBalance = balance;
    }

    void calculateMonthlyInterest()
    {
        savingsBalance+=(savingsBalance*annualInterestRate)/12;
    }
    static void modifyInterestRate(double newAnnualInterestRate)
    {
        annualInterestRate=newAnnualInterestRate;
    }
    public double getSavingsBalance() {
        return savingsBalance;
    }
}
