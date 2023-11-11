// Concrete class representing a Tetrahedron, extends from ThreeDimensionalShape
public class Tetrahedron extends ThreeDimensionalShape{
    private double length;

    public Tetrahedron(double length)
    {
        this.length = length;
    }

    // Method to calculate surface area of the shape
    @Override
    public void calculateArea() {
        super.area= Math.sqrt(3)*length*length;
    }

    // Method to calculate volume of the shape
    @Override
    public void calculateVolume() {
        super.volume= (Math.sqrt(2)*Math.pow(length,3))/(12.0);
    }

    // Method to get the name of shape
    public String getName()
    {
        return "A Tetrahedron is a "+super.getName();
    }
}
