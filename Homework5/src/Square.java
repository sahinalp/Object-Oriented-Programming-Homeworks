// Concrete class representing a Square, extends from TwoDimensionalShape
public class Square extends TwoDimensionalShape {

    private double length;

    public Square(double length)
    {
        this.length=length;
    }

    // Method to calculate area of the shape
    @Override
    public void calculateArea() {
        super.area=length*length;
    }

    // Method to get the name of shape
    public String getName()
    {
        return "A Square is a "+super.getName();
    }
}
