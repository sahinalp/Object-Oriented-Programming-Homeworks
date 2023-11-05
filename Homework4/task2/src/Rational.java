public class Rational {

    private int numerator;
    private int denominator;

    // Default constructor, initializes to 1/1
    public Rational() {
        numerator=1;
        denominator=1;
    }
    public Rational(int numerator, int denominator) {
        findReducedForm(numerator,denominator);
    }

    private void findReducedForm(int numerator, int denominator)
    {
        // Select smallest number between numerator and denominator
        int smallestNumber;
        if (numerator<denominator)
        {
            smallestNumber=numerator;
        }
        else {
            smallestNumber=denominator;
        }

        int commonDivider=2;
        while (commonDivider<=smallestNumber)
        {
            // Divide numerator, denominator If numerator and denominator
            // can be divided by commonDivider else increase commonDivider
            if(numerator%commonDivider==0 && denominator%commonDivider==0)
            {
                numerator=numerator/commonDivider;
                denominator=denominator/commonDivider;
                smallestNumber=smallestNumber/commonDivider;
            }
            else
            {
                commonDivider++;
            }
        }

        // Assign numbers
        this.numerator=numerator;
        this.denominator=denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString()
    {
        return " "+numerator+"\n---\n "+denominator;
    }

    // Print rational number as floating number with two decimal places by default
    public String toFloatingPointString() {
        return toFloatingPointString(2);
    }
    public String toFloatingPointString(int precision) {
        double result = (double) numerator / denominator;
        return String.format("%." + precision + "f", result);
    }
}
