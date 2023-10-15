public class HeartRates {
    private String firstName;
    private String lastName;
    private int birthDay;
    private int birthMonth;
    private int birthYear;

    public HeartRates(String firstName, String lastName,int birthDay, int birthMonth, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
    }
    public String getDateOfBirth()
    {
        return String.valueOf(birthDay)+"/"+String.valueOf(birthMonth)+"/"+String.valueOf(birthYear);

    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public int getBirthDay() {
        return birthDay;
    }
}
