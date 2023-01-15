import java.util.ArrayList;

public class Student extends User {
    private ArrayList<Grade> grades = null;
    private String fnum;
    private String egn;

    public Student(){
        this.grades = new ArrayList<Grade>();
    }
    public void addGrade(Grade grade){
        this.grades.add(grade);
    }
    public ArrayList<Grade> getGrades(){
        return this.grades;
    }


    public String getFnum() {
        return this.fnum;
    }
    public void setFnum(String fnum) throws InvalidFacultyNumberException{
        if(ValidateData.Fnum(fnum)) this.fnum = fnum;
        else throw new InvalidFacultyNumberException();
    }
    public String getEgn() {
        return this.egn;
    }
    public void setEgn(String egn) throws InvalidEGNException{
        if(ValidateData.EGN(egn)) this.egn = egn;
        else throw new InvalidEGNException();
    }

    @Override
    public String getUserType() {
        return "Student";
    }
}
