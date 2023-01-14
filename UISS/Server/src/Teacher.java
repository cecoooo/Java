public class Teacher extends User{

    public Teacher(){

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

    @Override
    public String getUserType() {
        return "Teacher";
    }
}
