// Abstract class for three-dimensional shapes, extends from Shape
public abstract class ThreeDimensionalShape extends Shape{

    protected double area;
    protected double volume;


    public double getArea()
    {
        return area;
    }
    public double getVolume() {
        return volume;
    }

    // Abstract method to calculate surface area of the shape
    public abstract void calculateArea();

    // Abstract method to calculate volume of the shape
    public abstract void calculateVolume();

    // Method to get the name of shape
    public String getName() {
        return "ThreeDimensionalShape "+super.getName();
    }
}
