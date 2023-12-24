import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Create customers
        Customer customer1 = new Customer(1,"Alp","Akosman","12345678901","01.01.1998");
        Customer customer2 = new Customer(2,"Ali","Velioğlu","12345678901","01.01.1987");
        Customer customer3 = new Customer(3,"Ayşe","Ayşegiller","12345678901","01.01.1995");

        // Create flights
        Flight flight1 = new Flight(1,"AEE994","ATHENS","ISTANBUL",1);
        Flight flight2 = new Flight(2,"PGT53XP","ANTALYA","MUNICH",1);
        Flight flight3 = new Flight(3,"SXS7WF","DUSSELDORF","IZMIR",0);
        Flight flight4 = new Flight(4,"THY4LD","ANKARA","ANTALYA",0);
//        Flight flight5 = new Flight(5,"WMT6BL","VENICE","SHARM EL-SHEIKH",0);
//        Flight flight6 = new Flight(6,"SEH7AT","HERAKLION","ATHENS",0);
//        Flight flight7 = new Flight(7,"PGT2256","ISTANBUL","BODRUM",2);
//        Flight flight8 = new Flight(8,"SXS6Y","IZMIR","STOCKHOLM",4);
//        Flight flight9 = new Flight(9,"PGT43UC","ANKARA","IZMIR",1);

        // Create flights list and add created flights in this list.
        List<Flight> flights = new ArrayList<>();
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);

        // Create reservation objects from interface
        IReservation reservation1 = null;
        IReservation reservation2 = null;
        IReservation reservation3 = null;

        // Create two ExecutorService object to use at synchronized and unsynchronized versions
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        System.out.println("Enter 1 for case 1 - 3 Customers tries to make reservations flight with 1 seat.");
        System.out.println("Enter 2 for case 2 - 1 Customer cancels reservation flight with 0 seat and 2 customers try to make reservations.");
        System.out.println("Enter 3 for case 3 - 1 Customer tries to make reservation flight with 1 seat and 2 customers try to read reservations.");

        Scanner scanner = new Scanner(System.in);
        int caseNumber = scanner.nextInt();
        switch (caseNumber)
        {
            case 1:
                System.out.println("Unsynchronized version:\n\n");

                // Create UnsynchronizedReservation objects
                reservation1 = new UnsynchronizedReservation(flights);
                reservation2 = new UnsynchronizedReservation(flights);
                reservation3 = new UnsynchronizedReservation(flights);

                // Create 1 read and 1 write threads for each customer
                executorService1.execute(new Reader(reservation1,customer1));
                executorService1.execute(new Reader(reservation2,customer2));
                executorService1.execute(new Reader(reservation3,customer3));
                executorService1.execute(new Writer(reservation1,"AEE994",customer1,true));
                executorService1.execute(new Writer(reservation1,"AEE994",customer2,true));
                executorService1.execute(new Writer(reservation1,"AEE994",customer3,true));

                executorService1.shutdown();

                // Wait until executions ended
                executorService1.awaitTermination(1, TimeUnit.SECONDS);

                System.out.println("\n\nSynchronized version:\n\n");

                // Create SynchronizedReservation objects
                reservation1 = new SynchronizedReservation(flights);
                reservation2 = new SynchronizedReservation(flights);
                reservation3 = new SynchronizedReservation(flights);

                // Create 1 read and 1 write threads for each customer
                executorService2.execute(new Reader(reservation1,customer1));
                executorService2.execute(new Reader(reservation2,customer2));
                executorService2.execute(new Reader(reservation3,customer3));
                executorService2.execute(new Writer(reservation1,"PGT53XP",customer1,true));
                executorService2.execute(new Writer(reservation1,"PGT53XP",customer2,true));
                executorService2.execute(new Writer(reservation1,"PGT53XP",customer3,true));

                executorService2.shutdown();
                break;
            case 2:
                System.out.println("Unsynchronized version:\n\n");

                // Create UnsynchronizedReservation objects
                reservation1 = new UnsynchronizedReservation(flights);
                reservation2 = new UnsynchronizedReservation(flights);
                reservation3 = new UnsynchronizedReservation(flights);

                // Customer 1 canceling reservation.
                executorService1.execute(new Reader(reservation1,customer1));
                executorService1.execute(new Writer(reservation1,"SXS7WF",customer1,false));

                // Customer 2 and 3 tries to make reservation.
                executorService1.execute(new Reader(reservation2,customer2));
                executorService1.execute(new Reader(reservation3,customer3));
                executorService1.execute(new Writer(reservation1,"SXS7WF",customer2,true));
                executorService1.execute(new Writer(reservation1,"SXS7WF",customer3,true));

                executorService1.shutdown();

                // Wait until executions ended
                executorService1.awaitTermination(1, TimeUnit.SECONDS);

                System.out.println("\n\nSynchronized version:\n\n");

                // Create SynchronizedReservation objects
                reservation1 = new SynchronizedReservation(flights);
                reservation2 = new SynchronizedReservation(flights);
                reservation3 = new SynchronizedReservation(flights);

                // Customer 1 canceling reservation.
                executorService2.execute(new Reader(reservation1,customer1));
                executorService2.execute(new Writer(reservation1,"THY4LD",customer1,false));

                // Customer 2 and 3 tries to make reservation.
                executorService2.execute(new Reader(reservation2,customer2));
                executorService2.execute(new Reader(reservation3,customer3));
                executorService2.execute(new Writer(reservation1,"THY4LD",customer2,true));
                executorService2.execute(new Writer(reservation1,"THY4LD",customer3,true));

                executorService2.shutdown();
                break;

            case 3:
                System.out.println("Unsynchronized version:\n\n");

                reservation1 = new UnsynchronizedReservation(flights);
                reservation2 = new UnsynchronizedReservation(flights);
                reservation3 = new UnsynchronizedReservation(flights);

                // Customer 2 and 3 tries to read reservations.
                for (int i = 0; i < 3; i++) {
                    executorService1.execute(new Reader(reservation2, customer2));
                    executorService1.execute(new Reader(reservation3, customer3));
                }

                // Customer 1 tries to make reservation
                executorService1.execute(new Writer(reservation1,"AEE994",customer1,true));
                executorService1.shutdown();

                // Wait until executions ended
                executorService1.awaitTermination(1, TimeUnit.SECONDS);

                System.out.println("\n\nSynchronized version:\n\n");

                reservation1 = new SynchronizedReservation(flights);
                reservation2 = new SynchronizedReservation(flights);
                reservation3 = new SynchronizedReservation(flights);

                // Customer 2 and 3 tries to read reservations.
                for (int i = 0; i < 3; i++) {
                    executorService2.execute(new Reader(reservation2,customer2));
                    executorService2.execute(new Reader(reservation3,customer3));
                }

                // Customer 1 tries to make reservation
                executorService2.execute(new Writer(reservation1,"PGT53XP",customer1,true));
                executorService2.shutdown();
                break;

        }




    }
}