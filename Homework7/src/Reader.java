public class Reader implements Runnable{
    private IReservation reservation;
    private Customer customer;

    public Reader(IReservation reservation,Customer customer) {
        this.reservation = reservation;
        this.customer = customer;
    }

    @Override
    public void run() {
        reservation.queryReservation(customer);
    }
}
