public class Teacher extends Person{

    private String subject;

    public Teacher(String f, String l, String p, String s){
        super(f,l,p);
        subject = s;
    }

    public String getSubject() {
        return subject;
    }
    @Override
    public String toString(){
        return super.toString() + " Subject: " + subject;
    }
}
