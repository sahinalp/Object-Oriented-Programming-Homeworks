import java.util.List;
public class UnsynchronizedReservation implements IReservation{
    private List<Flight> flights;

    public UnsynchronizedReservation(List<Flight> flights) {

        this.flights = flights;
    }

    @Override
    public void makeReservation(String flightName,Customer customer) {
        for (Flight flight: flights) {
            if (flight.getFlightName()==flightName) {
                if (!flight.isReserved()) {
                    System.out.println(Thread.currentThread().getName() + " making reservation for " + flight.getFlightName() +
                            " as "+ customer.getName()+" "+ customer.getSurname());
                    flight.setEmptySeatCount(flight.getEmptySeatCount()-1);
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to make reservation for " + flight.getFlightName() +
                            " as "+ customer.getName()+" "+ customer.getSurname());
                }
            }
        }


    }

    @Override
    public void cancelReservation(String flightName, Customer customer) {
        for (Flight flight: flights) {
            if (flight.getFlightName()==flightName) {
                if (flight.isReserved()) {
                    System.out.println(Thread.currentThread().getName() + " canceling reservation for " + flight.getFlightName() +
                            " as "+ customer.getName()+" "+ customer.getSurname());
                    flight.setEmptySeatCount(flight.getEmptySeatCount()+1);
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to cancel reservation for " + flight.getFlightName() +
                            " as "+ customer.getName()+" "+ customer.getSurname());
                }
            }
        }

    }

    @Override
    public void queryReservation(Customer customer) {
        for (Flight flight: flights) {
            System.out.println(Thread.currentThread().getName() + " querying reservation for " + flight.getFlightName() + " ("+flight.getEmptySeatCount()+" seat)"+
                    " as "+ customer.getName()+" "+ customer.getSurname());
        }

    }
}
