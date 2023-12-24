import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedReservation implements IReservation{
    private List<Flight> flights;
    private Lock lock;

    public SynchronizedReservation(List<Flight> flights) {
        this.lock= new ReentrantLock();
        this.flights = flights;
    }
    @Override
    public void makeReservation(String flightName,Customer customer) {
        lock.lock();
        try
        {
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
        finally {
            lock.unlock();
        }

    }

    @Override
    public void cancelReservation(String flightName, Customer customer) {
        lock.lock();
        try {
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
        finally {
            lock.unlock();
        }
    }

    @Override
    public void queryReservation(Customer customer) {
        lock.lock();
        try {
            for (Flight flight: flights) {
                System.out.println(Thread.currentThread().getName() + " querying reservation for " + flight.getFlightName() + " ("+flight.getEmptySeatCount()+" seat)"+
                        " as "+ customer.getName()+" "+ customer.getSurname());
            }
        }
        finally {
            lock.unlock();
        }
    }
}
