// Concrete class representing a Cube, extends from ThreeDimensionalShape
public class Cube extends ThreeDimensionalShape{

    private double length;

    public Cube(double length)
    {
        this.length=length;
    }


    // Method to calculate surface area of the shape
    @Override
    public void calculateArea() {
        super.area=6*length*length;
    }

    // Method to calculate volume of the shape
    @Override
    public void calculateVolume() {
        super.volume=length*length*length;
    }

    // Method to get the name of shape
    public String getName()
    {
        return "A Cube is a "+super.getName();
    }
}
