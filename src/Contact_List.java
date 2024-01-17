import java.util.ArrayList;
import java.util.Scanner;

public class Contact_List {

    private ArrayList<Person> contacts;
    private Scanner s;

    private static boolean RUNNING;

    public Contact_List()
    {
        contacts = new ArrayList<Person>();
        s = new Scanner(System.in);
        RUNNING = true;
    }

    // Prints Interface
    public int printInterface(){
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts by Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By Phone Number");
        System.out.println("0. Exit");
        int n = s.nextInt();
        s.nextLine();
        return n;
    }
    // Return Contacts
    public ArrayList<Person> getContacts(){
       return contacts;
    }
    // Adds Contact
    public void addContact(){
        System.out.println("Select Type Of Contact To Add");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        int num = s.nextInt();
        s.nextLine();
        System.out.println("Please Fill In The Following Information");
        System.out.println("First Name: ");
        String f = s.nextLine();
        System.out.println("Last Name: ");
        String l = s.nextLine();
        System.out.println("Phone Number: ");
        String p = s.nextLine();
        if(num == 1){
            System.out.println("Grade: ");
            int g = s.nextInt();
            contacts.add(new Student(f,l,p,g));
        }
        if(num == 2){
            System.out.println("Subject: ");
            String sub = s.nextLine();
            contacts.add(new Teacher(f,l,p,sub));
        }
    }
    // Print Contacts
    public void printContacts(){
        for(Person p: contacts){
            System.out.println(p);
        }
    }
    //Bridge to Separate Sort Methods
    public void sort(int sortBy){
        if(sortBy == 0){
            sortFirst();
        }
        if(sortBy == 1){
            sortLast();
        }
        if(sortBy == 2){
            sortNum();
        }

    }
    //Sort by First Name;
    public void sortFirst(){
        for(int i = 0; i < contacts.size(); i++){
            for(int j = 0; j < contacts.size() - 1; j++){
                if(contacts.get(j).getFirstName().compareTo(contacts.get(i).getFirstName()) > 0){
                    Person temp = contacts.get(j);
                    contacts.remove(j);
                    contacts.add(j+1,temp);
                }
            }
        }
    }
    //Sort by Last Name;
    public void sortLast(){
        for(int i = 0; i < contacts.size(); i++){
            for(int j = 0; j < contacts.size() - 1; j++){
                if(contacts.get(j).getLastName().compareTo(contacts.get(i).getLastName()) > 0){
                    Person temp = contacts.get(j);
                    contacts.remove(j);
                    contacts.add(j+1,temp);
                }
            }
        }
    }
    //Sort by Number
    public void sortNum(){
        for(int i = 0; i < contacts.size(); i++){
            for(int j = 0; j < contacts.size() - 1; j++){
                if(contacts.get(j).getPhoneNumber().compareTo(contacts.get(i).getPhoneNumber()) > 0){
                    Person temp = contacts.get(j);
                    contacts.remove(j);
                    contacts.add(j+1,temp);
                }
            }
        }
    }
    // Search by First Name
    public Person searchFirst(String firstName){
        for(Person p: contacts){
            if(p.getFirstName().equalsIgnoreCase(firstName)){
                return p;
            }
        }
        return null;
    }
    // Search by Last Name
    public Person searchLast(String lastName){
        for(Person p: contacts){
            if(p.getFirstName().equalsIgnoreCase(lastName)){
                return p;
            }
        }
        return null;

    }
    // Search by Phone Number
    public Person searchNum(String phoneNumber){
        for(Person p: contacts){
            if(p.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                return p;
            }
        }
        return null;
    }
    //List Students
    public void listStudents(){
        for(Person p: contacts){
            if(p instanceof Student){
                System.out.println(p);
            }
        }

    }
    //Run the Show
    public void run(){
        while(RUNNING) {
            int num = printInterface();
            if (num == 0) {
                //exit
                RUNNING = false;
            }
            if (num == 1) {
                addContact();
            }
            if (num == 2) {
                sort(0);
                printContacts();
            }
            if (num == 3) {
                sort(1);
                printContacts();
            }
            if (num == 4) {
                sort(2);
                printContacts();
            }
            if (num == 5) {
                listStudents();
            }
            if (num == 6) {
                System.out.println("First Name: ");
                String name = s.nextLine();
                Person p = searchFirst(name);
                System.out.println(p);
            }
            if (num == 7) {
                System.out.println("Last Name: ");
                String name = s.nextLine();
                Person p = searchLast(name);
                System.out.println(p);
            }
            if (num == 8) {
                System.out.println("Phone Number: ");
                String phone = s.nextLine();
                Person p = searchNum(phone);
                System.out.println(p);
            }
        }
    }
}
