public class Student extends Person{
    private String fNum;

    public String getfNum(){
        return this.fNum ;
    }
    public void setfNum(String f){
        this.fNum = f;
    }

    public Student(){
        super();
        this.fNum = "";
    }
    public Student(String name, String egn, String fnum){
        super(name, egn);
        this.fNum = fnum;
    }
}
