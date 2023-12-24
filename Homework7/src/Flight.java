public class Flight {
    private int ID;
    private String flightName;
    private String from;
    private String where;
    private int emptySeatCount;

    public Flight(int ID, String flightName, String from, String where, int emptySeatCount) {
        this.ID = ID;
        this.flightName = flightName;
        this.from = from;
        this.where = where;
        this.emptySeatCount = emptySeatCount;
    }
    public boolean isReserved()
    {
        if(emptySeatCount>0)
        {
            return false;
        }
        return true;
    }

    public int getID() {
        return ID;
    }

    public String getFlightName() {
        return flightName;
    }

    public String getFrom() {
        return from;
    }

    public String getWhere() {
        return where;
    }

    public int getEmptySeatCount() {
        return emptySeatCount;
    }

    public void setEmptySeatCount(int emptySeatCount) {
        this.emptySeatCount = emptySeatCount;
    }
}
