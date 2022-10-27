public class Student extends Person{
    private String fNum;
    private int pik;
    private int te;
    private int ppe;

    public String getfNum(){
        return this.fNum;
    }
    public int getPIK_Mark(){
        return this.pik;
    }
    public int getTE_Mark(){
        return this.te;
    }
    public int getPPE_Mark(){
        return this.ppe;
    }
    public void setFNum(String n){
        this.fNum = n;
    }
    public void setPIK_Mark(int n){
        this.pik = n;
    }
    public void setTE_Mark(int n){
        this.te = n;
    }
    public void setPPE_Mark(int n){
        this.ppe = n;
    }
    public Student(){
        super();
        this.fNum = "";
        this.pik = 0;
        this.te = 0;
        this.ppe = 0;
    }
    public Student(String name, String birthday, String fnum, int p, int t, int pp){
        super(name, birthday);
        this.fNum = fnum;
        this.pik = p;
        this.te = t;
        this.ppe = pp;
    }
}
