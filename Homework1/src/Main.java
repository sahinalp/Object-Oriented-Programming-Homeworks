import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create Scanner object to read input
        Scanner sc= new Scanner(System.in);
        //Create Calendar object to get current year
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);

        //Read a string input(user's first name) from the user
        System.out.print("Enter your first name: ");
        String name= sc.nextLine();

        //Read a string input(user's last name) from the user
        System.out.print("Enter your last name: ");
        String lastName= sc.nextLine();

        //Read a string input(user's date of birth) from the user
        System.out.print("Enter your date of birth(dd/mm/yyyy): ");
        String dateOfBirth= sc.nextLine();
        int day;
        int month;
        int year;

        //The code will continue to run if the user did not enter the date in the correct format
        while (true) {
            try {
                day = Integer.parseInt(dateOfBirth.split("/")[0]);
                month = Integer.parseInt(dateOfBirth.split("/")[1]);
                year = Integer.parseInt(dateOfBirth.split("/")[2]);

                //The loop will break if the user entered the date in the correct format and between 1900 and currentYear.
                if (day<=31 && month<=12 && year>=1900 && year<currentYear) break;
            } catch (Exception e) {

            }
            System.out.print("Please enter your date of birth(dd/mm/yyyy like 01/01/2000): ");
            dateOfBirth = sc.nextLine();
        }

        //Create HeartRates object
        HeartRates heartRates = new HeartRates(name,lastName,day,month,year);
        //Create HeartRatesCore object to do calculations
        HeartRatesCore heartRatesCore = new HeartRatesCore(heartRates);

        //Calculate age with help of HeartRatesCore object
        int age= heartRatesCore.calculateAge();
        //Calculate maximum heart rate with help of HeartRatesCore object
        int maxHearthRate  = heartRatesCore.calculateMaximumHeartRate();
        //Calculate target heart rate with help of HeartRatesCore object
        String targetHearthRate = heartRatesCore.calculateTargetHeartRateRange();

        //Print the user's data
        System.out.println("Welcome "+heartRates.getFirstName()+" "+heartRates.getLastName());
        System.out.println("Date Of Birth: "+heartRates.getDateOfBirth());
        System.out.println("Age: "+age);
        System.out.println("Maximum Hearth Rate: "+maxHearthRate);
        System.out.println("Target Hearth Rate: "+targetHearthRate);

    }
}