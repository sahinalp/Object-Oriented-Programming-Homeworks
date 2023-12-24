public class Customer {
    private int ID;
    private String name;
    private String surname;
    private String identificationNumber;
    private String birthDate;

    public Customer(int ID, String name, String surname, String identificationNumber, String birthDate) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.identificationNumber = identificationNumber;
        this.birthDate = birthDate;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        String temp = name.substring(0,2);
        temp=temp.toUpperCase();
        for (int i = 2; i < name.length(); i++) {
            temp+="*";
        }
        return temp;
    }

    public String getSurname() {
        String temp = surname.substring(0,3);
        temp=temp.toUpperCase();
        for (int i = 3; i < surname.length(); i++) {
            temp+="*";
        }
        return temp;
    }

    public String getIdentificationNumber() {
        String temp = identificationNumber.substring(0,3);
        for (int i = 3; i < identificationNumber.length()-2; i++) {
            temp+="*";
        }
        temp+=identificationNumber.substring(identificationNumber.length()-2,identificationNumber.length());
        return temp;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
