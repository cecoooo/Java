import java.util.ArrayList;

public class Student extends User{
    private ArrayList<Grade> grades;

    public Student(){

    }
    public String getUsername(){
        return this.username;
    }
    public void setUserName(String value){
        this.username = value;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String value){
        this.password = value;
    }

    public void addGrade(Grade grade){
        this.grades.add(grade);
    }
    public ArrayList<Grade> getGrades(){
        return this.grades;
    }


    @Override
    public String getUserType() {
        return "Student";
    }
}
