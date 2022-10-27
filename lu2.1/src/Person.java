public class Person {
    private String name;
    private String birthDay;

    public String getName(){
        return this.name;
    }
    public void setName(String n){
        this.name = n;
    }
    public String getBirthDay(){
        return this.birthDay;
    }
    public void setBirthDay(String n){
        this.birthDay = n;
    }
    public Person(){

    }
    public Person(String name, String birthDay){
        this.name = name;
        this.birthDay = birthDay;
    }
}