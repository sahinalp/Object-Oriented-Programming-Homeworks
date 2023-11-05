import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numerator1,numerator2,denominator1,denominator2;

        // Create Scanner object
        Scanner scanner =new Scanner(System.in);

        // Get first rational number from user
        System.out.printf("First Rational Number:\n ");
        numerator1=scanner.nextInt();
        System.out.printf("---\n ");
        denominator1=scanner.nextInt();

        // Get second rational number from user
        System.out.printf("Second Rational Number:\n ");
        numerator2=scanner.nextInt();
        System.out.printf("---\n ");
        denominator2=scanner.nextInt();

        // Create Rational objects
        Rational rational1 = new Rational(numerator1,denominator1);
        Rational rational2 = new Rational(numerator2,denominator2);

        // Calculate sum of rational numbers
        Rational sum  =  RationalCalculator.add(rational1,rational2);

        // Calculate difference of rational numbers
        Rational diff = RationalCalculator.subtract(rational1,rational2);

        // Calculate product of rational numbers
        Rational multiply = RationalCalculator.multiply(rational1,rational2);

        // Calculate quotient of rational numbers
        Rational divide = RationalCalculator.divide(rational1,rational2);

        //Print rational numbers as floating number
        System.out.println("\nFloating Point Representation of rational1: " + rational1.toFloatingPointString());
        System.out.println("Floating Point Representation of rational2: " + rational2.toFloatingPointString());

        //Print rational numbers
        System.out.println(rational1+"\n");
        System.out.println(rational2);
    }
}