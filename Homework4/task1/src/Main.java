public class Main {
    public static void main(String[] args) {

        // Create SavingsAccount objects with given balances.
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        // Set modifyInterestRate as 0.04
        SavingsAccount.modifyInterestRate(0.04);

        // Calculate and print new balances for 12 months with 0.04 interest rate
        for (int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();

            System.out.printf("%2d. Month  -   Saver1 Balance= %.2f     Saver2 Balance= %.2f\n",i+1,saver1.getSavingsBalance(),saver2.getSavingsBalance());

        }

        // Set modifyInterestRate as 0.05
        SavingsAccount.modifyInterestRate(0.05);

        // Calculate and print new balances for the next month with 0.05 interest rate
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("\nNext Month -   Saver1 Balance= %.2f     Saver2 Balance= %.2f",saver1.getSavingsBalance(),saver2.getSavingsBalance());
    }
}