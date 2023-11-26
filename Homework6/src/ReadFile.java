import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {


    public static boolean isValidFileName(String fileName) {
        if (!fileName.isEmpty()) {
            try {
                new FileReader(fileName);
                return true;
            } catch (IOException e) {
                System.err.println("Error reading from file: " + e.getMessage());
                return false;
            }
        }
        else
        {
            System.err.println("\nEmpty Input\n");
            return false;
        }

    }

    public static List<Integer> readIntegersFromFile(String fileName)
    {
        List<Integer> integers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // Loop will continue until there is no line at file.
            while ((line = br.readLine()) != null) {

                // If it is integer it will add to integers
                try {

                    int num = Integer.parseInt(line);
                    integers.add(num);

                }
                catch (NumberFormatException e) {
                    // Print invalid integers
                    System.err.println("Skipping invalid integer: " + line);
                }
            }
        }
        // If there is a problem with reading file print error message
        catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return integers;
    }

    public static List<Float> readFloatsFromFile(String fileName)
    {
        List<Float> floats = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;

            // Loop will continue until there is no line at file.
            while ((line = br.readLine()) != null) {

                // If it is a number it will add to floats
                try {

                    Float num = Float.parseFloat(line);
                    floats.add(num);

                }
                catch (NumberFormatException e) {
                    // Print invalid floats
                    System.err.println("Skipping invalid integer: " + line);
                }
            }
        }
        // If there is a problem with reading file print error message
        catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

        return floats;
    }
}
