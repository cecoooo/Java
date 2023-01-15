import java.io.Serializable;

public class Grade implements Serializable {
    private static final long serialVersionUID = 1;
    private String subject;
    private int semester;
    private int grade;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String toString(){
        return this.subject+" sem: "+this.semester+" mark: "+this.grade;
    }
}
