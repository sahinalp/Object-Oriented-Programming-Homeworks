// Concrete class representing a Sphere, extends from ThreeDimensionalShape
public class Sphere extends ThreeDimensionalShape{
    private double pi;
    private double radius;

    public Sphere(double radius)
    {
        this.pi=3.14159;
        this.radius=radius;
    }
    public Sphere(double radius,double pi)
    {
        this.pi=pi;
        this.radius=radius;
    }

    // Method to calculate surface area of the shape
    @Override
    public void calculateArea() {
        super.area=4*pi*radius*radius;
    }

    // Method to calculate volume of the shape
    @Override
    public void calculateVolume() {
        super.volume=(4.0/3.0)*pi*radius*radius*radius;
    }

    // Method to get the name of shape
    public String getName()
    {
        return "A Sphere is a "+super.getName();
    }
}
