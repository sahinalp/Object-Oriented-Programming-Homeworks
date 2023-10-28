public class SieveOfEratosthenes {

    private int selectedRange;
    // Array of selectedRange elements, initialized to false by default
    private boolean[] primeNumbers;

    public SieveOfEratosthenes(int selectedRange) {
        this.selectedRange = selectedRange;
        primeNumbers= new boolean[selectedRange];
    }

    void setTrue()
    {
        // Set all numbers as potential primes
        for (int i = 2; i < selectedRange; i++) {
            primeNumbers[i]=true;
        }
    }

    void calculatePrimeNumbers()
    {
        // Calculate prime numbers with Sieve of Eratosthenes algorithm
        for (int i = 2; i < selectedRange; i++) {
            if(primeNumbers[i])
            {
                // Set false of number of i's multiplies
                for (int j = 2; j*i < selectedRange; j++) {
                    primeNumbers[i*j]=false;
                }
            }
        }
    }
    void displayPrimeNumbers()
    {
        // Print prime numbers between 2 and selectedRange
        System.out.println("Prime numbers between 2 and "+(selectedRange)+":");
        System.out.printf("2");
        for (int i = 3; i <selectedRange; i++) {
            if(primeNumbers[i])
            {
                System.out.printf(", "+i);
            }
        }
    }
}
