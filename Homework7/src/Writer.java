public class Writer implements Runnable{
    private IReservation reservation;
    private boolean makeReservation;
    private Customer customer;
    private String flightName;

    public Writer(IReservation reservation,String flightName,Customer customer, boolean makeReservation) {
        this.reservation = reservation;
        this.flightName = flightName;
        this.customer = customer;
        this.makeReservation = makeReservation;
    }

    @Override
    public void run() {
        if (makeReservation) {
            reservation.makeReservation(flightName,customer);
        }
        else
        {
            reservation.cancelReservation(flightName,customer);
        }
    }
}
