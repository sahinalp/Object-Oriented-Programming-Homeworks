// Abstract class for two-dimensional shapes, extends from Shape
public abstract class TwoDimensionalShape extends Shape{
    protected double area;

    public double getArea()
    {
        return area;
    }

    // Abstract method to calculate area of the shape
    public abstract void calculateArea();

    // Method to get the name of shape
    public String getName() {
        return "TwoDimensionalShape "+super.getName();
    }
}
