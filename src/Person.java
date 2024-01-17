public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Person(String f, String l, String p){
        firstName = f;
        lastName = l;
        phoneNumber = p;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    @Override
    public String toString(){
        return firstName + " "  + lastName + " - #" + phoneNumber;
    }
}

