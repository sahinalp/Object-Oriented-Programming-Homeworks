// Concrete class representing a Triangle, extends from TwoDimensionalShape
public class Triangle extends TwoDimensionalShape
{
    private double length1;
    private double length2;
    private double angle;

    public Triangle(double length)
    {
        this.length1=length;
        this.length2=length;
        this.angle=90;
    }
    public Triangle(double length1, double length2)
    {
        this.length1=length1;
        this.length2=length2;
        this.angle=90;
    }
    public Triangle(double length1, double length2, double angle)
    {
        this.length1=length1;
        this.length2=length2;
        this.angle=angle;
    }

    // Method to calculate sine of degree between given lengths
    private double getSin()
    {
        double radianOfAngle= Math.toRadians(angle);
        return Math.sin(radianOfAngle);
    }

    // Method to calculate area
    @Override
    public void calculateArea() {
        super.area=0.5*length1*length2*getSin();
    }

    // Method to get the name of shape
    public String getName()
    {
        return "A Triangle is a "+super.getName();
    }
}
