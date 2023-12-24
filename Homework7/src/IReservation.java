public interface IReservation {
    void makeReservation(String flightName, Customer customer);
    void cancelReservation(String flightName, Customer customer);
    void queryReservation(Customer customer);
}
