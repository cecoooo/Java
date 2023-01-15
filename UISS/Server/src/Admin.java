public class Admin extends User{
    public Admin(){

    }

    public String getUsername(){
        return this.username;
    }
    public void setUserName(String value) throws InvalidUsernameException{
        if(ValidateData.Username(value)) this.username = value;
        else throw new InvalidUsernameException();
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String value) throws InvalidPasswordException{
        if(ValidateData.Password(value)) this.password = value;
        else throw new InvalidPasswordException();
    }

    @Override
    public String getUserType() {
        return "Admin";
    }
}
