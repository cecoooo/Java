public class Teacher extends Person{
    private Course course;

    public Course getCourse(){
        return this.course;
    }
    public void setCourse(Course course){
        this.course = course;
    }
    public Teacher(){
        super();
        this.course = new Course("");
    }
    public Teacher(String name, String egn, Course course){
        super(name, egn);
        this.course = course;
    }
}
