import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create Scanner object to read input
        Scanner scanner = new Scanner(System.in);

        // Create SieveOfEratosthenes object to do calculations
        SieveOfEratosthenes sieveOfEratosthenes;

        // Input for selecting upper range
        int selectedRange;

        // Read an int input from the user
        System.out.println("Please enter upper range to find prime numbers between 2 and upper limit: ");
        selectedRange = scanner.nextInt();

        // Create a primitive-type boolean array of selectedRange elements
        sieveOfEratosthenes = new SieveOfEratosthenes(selectedRange);

        // All elements of the array initialized to true
        sieveOfEratosthenes.setTrue();
        // Calculations of prime numbers with Sieve of Eratosthenes algorithm
        sieveOfEratosthenes.calculatePrimeNumbers();
        // Print prime numbers between 2 and selectedRange
        sieveOfEratosthenes.displayPrimeNumbers();
    }
}