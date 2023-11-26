import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // First part for int numbers

        // Create Scanner object to get input
        Scanner scanner = new Scanner(System.in);
        String fileName;

        // Prompt user until a valid file name is provided
        do {
            System.out.println("Enter the input file name: ");
            fileName = scanner.nextLine();
        } while (!ReadFile.isValidFileName(fileName));

        List<Integer> integers = ReadFile.readIntegersFromFile(fileName);

        System.out.println("Unsorted Integers:");
        System.out.println(integers);

        // Create IntSort object
        IntSort intSort = new IntSort(integers);

        // Sort integer numbers with using quicksort
        intSort.quickSort();

        // Print sorted integer numbers
        System.out.println("Sorted Integers:");
        System.out.println(integers);


        System.out.printf("\n\n");


        // Second part for float numbers

        // Prompt user until a valid file name is provided
        do {
            System.out.println("Enter the input file name: ");
            fileName = scanner.nextLine();
        } while (!ReadFile.isValidFileName(fileName));

        List<Float> floats = ReadFile.readFloatsFromFile(fileName);

        System.out.println("Unsorted Floats:");
        System.out.println(floats);

        // Create FloatSort object
        FloatSort floatSort = new FloatSort(floats);

        // Sort float numbers with using quicksort
        floatSort.quickSort();

        // Print sorted float numbers
        System.out.println("Sorted Floats:");
        System.out.println(floats);
    }
}