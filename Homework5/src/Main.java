public class Main {
    public static void main(String[] args) {

        // Array of Shape references containing objects of different concrete classes
        Shape[] shapes = {
                new Circle(3.56),
                new Square(2.5),
                new Triangle(5),
                new Sphere(4),
                new Cube(3.41),
                new Tetrahedron(2.34)
        };

        // Loop through each shape in the array
        for (Shape shape:shapes)
        {
            System.out.println("\n"+shape.getName());

            // Check if it is two-dimensional shape
            if (shape instanceof TwoDimensionalShape)
            {
                TwoDimensionalShape twoDShape = (TwoDimensionalShape) shape;
                twoDShape.calculateArea();
                System.out.println(String.format("Area of %s: %.2f",twoDShape.getClass().getName(),twoDShape.getArea()));
            }
            else
            {
                ThreeDimensionalShape threeDShape = (ThreeDimensionalShape) shape;
                threeDShape.calculateArea();
                threeDShape.calculateVolume();
                System.out.println(String.format("Surface Area of %s: %.2f",threeDShape.getClass().getName(),threeDShape.getArea()));
                System.out.println(String.format("Volume of %s: %.2f",threeDShape.getClass().getName(),threeDShape.getVolume()));
            }
        }
    }
}