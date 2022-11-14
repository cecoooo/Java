import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class User {
    private String userName = "";
    private String password = "";
    private String telNumber = "";

    public User(){

    }

    public User(String name, String pass, String tel){
        this.setUserName(name);
        this.setPassword(pass);
        this.setTelNumber(tel);
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        if(ValidateData.validatePhoneNumber(telNumber))
            this.telNumber = telNumber;
        else {
            try{
                throw new WrongPhoneNumberException();
            }catch(WrongPhoneNumberException e){
                e.printStackTrace();
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(ValidateData.validatePassword(password))
            this.password = password;
        else{
            try{
                throw new WrongUserException();
            }catch (WrongUserException e){
                e.printStackTrace();
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(ValidateData.validateUsername(userName)) {
            this.userName = userName;
        }
        else{
            try{
                throw new WrongUserException();
            }catch (WrongUserException e){
                e.printStackTrace();
            }
        }
    }

    public void saveToDatabase(){
        if(!this.password.equals("") && !this.userName.equals("") && !this.telNumber.equals("")){
            try{
                FileWriter writer = new FileWriter("C:\\Users\\User\\Desktop\\database.txt", true);
                writer.write(this.userName+"/"+this.password+"/"+this.telNumber+"\n");
                writer.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            if(this.userName.equals("") || this.password.equals(""))
            {
                try{
                    throw new WrongUserException();
                }catch(WrongUserException e){
                    e.printStackTrace();
                }
            }
            else{
                try{
                    throw new WrongPhoneNumberException();
                }catch(WrongPhoneNumberException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
