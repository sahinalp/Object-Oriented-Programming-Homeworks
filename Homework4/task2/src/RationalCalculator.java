public class RationalCalculator {
    static Rational result;

    static Rational add(Rational rationalNumber1,Rational rationalNumber2)
    {
        return add(rationalNumber1,rationalNumber2,true);
    }
    static Rational add(Rational rationalNumber1,Rational rationalNumber2,boolean display)
    {
        if(rationalNumber1.getDenominator()==rationalNumber2.getDenominator())
        {
            result = new Rational(
                    rationalNumber1.getNumerator()+rationalNumber2.getNumerator(),
                    rationalNumber1.getDenominator());
        }
        else
        {
            result = new Rational(
                    (rationalNumber1.getNumerator()*rationalNumber2.getDenominator())
                    +(rationalNumber2.getNumerator()*rationalNumber1.getDenominator()),
                    rationalNumber1.getDenominator()* rationalNumber2.getDenominator());
        }

        if (display)
        {
            System.out.printf("\n %d     %d     %d\n",rationalNumber1.getNumerator(),rationalNumber2.getNumerator(),result.getNumerator());
            System.out.printf("--- + --- = ---\n");
            System.out.printf(" %d     %d     %d\n",rationalNumber1.getDenominator(),rationalNumber2.getDenominator(),result.getDenominator());

        }
        return result;
    }

    static Rational subtract(Rational rationalNumber1,Rational rationalNumber2)
    {
        return subtract(rationalNumber1,rationalNumber2,true);
    }
    static Rational subtract(Rational rationalNumber1,Rational rationalNumber2,boolean display)
    {


        if(rationalNumber1.getDenominator()==rationalNumber2.getDenominator())
        {
            result = new Rational(
                    rationalNumber1.getNumerator()-rationalNumber2.getNumerator(),
                    rationalNumber1.getDenominator());
        }
        else
        {
            result = new Rational(
                    (rationalNumber1.getNumerator()*rationalNumber2.getDenominator())
                            -(rationalNumber2.getNumerator()*rationalNumber1.getDenominator()),
                    rationalNumber1.getDenominator()* rationalNumber2.getDenominator());
        }

        if(display)
        {
            System.out.printf("\n %d     %d     %d\n",rationalNumber1.getNumerator(),rationalNumber2.getNumerator(),result.getNumerator());
            System.out.printf("--- - --- = ---\n");
            System.out.printf(" %d     %d     %d\n",rationalNumber1.getDenominator(),rationalNumber2.getDenominator(),result.getDenominator());
        }
        return result;
    }

    static Rational multiply(Rational rationalNumber1,Rational rationalNumber2)
    {
        return multiply(rationalNumber1,rationalNumber2,true);
    }
    static Rational multiply(Rational rationalNumber1,Rational rationalNumber2,boolean display)
    {

        result = new Rational(
                rationalNumber1.getNumerator()*rationalNumber2.getNumerator(),
                rationalNumber1.getDenominator()* rationalNumber2.getDenominator());

        if (display)
        {
            System.out.printf("\n %d     %d     %d\n",rationalNumber1.getNumerator(),rationalNumber2.getNumerator(),result.getNumerator());
            System.out.printf("--- x --- = ---\n");
            System.out.printf(" %d     %d     %d\n",rationalNumber1.getDenominator(),rationalNumber2.getDenominator(),result.getDenominator());
        }
        return result;
    }

    static Rational divide(Rational rationalNumber1,Rational rationalNumber2)
    {
        return divide(rationalNumber1,rationalNumber2,true);
    }
    static Rational divide(Rational rationalNumber1,Rational rationalNumber2,boolean display)
    {

        result = new Rational(
                rationalNumber1.getNumerator()*rationalNumber2.getDenominator(),
                rationalNumber1.getDenominator()* rationalNumber2.getNumerator());

        if (display)
        {
            System.out.printf("\n %d     %d     %d\n", rationalNumber1.getNumerator(), rationalNumber2.getNumerator(), result.getNumerator());
            System.out.printf("--- / --- = ---\n");
            System.out.printf(" %d     %d     %d\n", rationalNumber1.getDenominator(), rationalNumber2.getDenominator(), result.getDenominator());
        }
        return result;
    }

}
