// Concrete class representing a Circle, extends from TwoDimensionalShape
public class Circle extends TwoDimensionalShape{

    private double pi;
    private double radius;

    public Circle(double radius)
    {
        this.pi=3.14159;
        this.radius=radius;
    }
    public Circle(double radius,double pi)
    {
        this.pi=pi;
        this.radius=radius;
    }

    // Method to calculate area of the shape
    @Override
    public void calculateArea() {
        super.area=pi*radius*radius;
    }

    // Method to get the name of shape
    public String getName()
    {
        return "A Circle is a "+super.getName();
    }
}
