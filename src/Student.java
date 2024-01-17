public class Student extends Person{

    private int grade;

    public Student(String f, String l, String p, int g){
        super(f,l,p);
        grade = g;
    }
    public int getGrade() {
        return grade;
    }
    @Override
    public String toString(){
        return super.toString() + " Grade: " + grade;
    }
}
