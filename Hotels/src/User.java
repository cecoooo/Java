import java.util.ArrayList;

public class User {
    private String email;
    private String pass;
    private ArrayList<Grade> grades;

    public User(){
        this.grades = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Grade grade) {
        this.grades.add(grade);
    }
}
