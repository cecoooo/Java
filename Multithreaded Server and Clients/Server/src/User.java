import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable, ValidateData {

    private static final long serialVersionUID = 1L;
    private String username = "";
    private String password = "";
    private String firstName = "";
    private String lastName = "";
    private int age = 0;
    private String phone = null;


    public User(){

    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) throws InvalidUsernameException{
        if(ValidateUsername(username)) this.username = username;
        else{
            try{
                throw new InvalidUsernameException();
            }catch (InvalidUsernameException e){
                e.printStackTrace();
            }
        }
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) throws InvalidPasswordException{
        if(ValidatePassword(password)) this.password = password;
        else {
            try{
                throw new InvalidPasswordException();
            }catch (InvalidPasswordException e){
                e.printStackTrace();
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) throws InvalidFirstOrLastNameException{
        if(ValidateFirstName(firstName)) this.firstName = firstName;
        else {
            try{
                throw new InvalidFirstOrLastNameException();
            }catch (InvalidFirstOrLastNameException e){
                e.printStackTrace();
            }
        }
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) throws InvalidFirstOrLastNameException{
        if(ValidateLastName(lastName)) this.lastName = lastName;
        else {
            try{
                throw new InvalidFirstOrLastNameException();
            }catch (InvalidFirstOrLastNameException e){
                e.printStackTrace();
            }
        }
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) throws InvalidAgeException{
        if(ValidateAge(age)) this.age = age;
        else {
            try{
                throw new InvalidAgeException();
            }catch (InvalidAgeException e){
                e.printStackTrace();
            }
        }
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) throws InvalidPhoneException{
        if(ValidatePhone(phone)) this.phone = phone;
        else {
            try{
                throw new InvalidPhoneException();
            }catch (InvalidPhoneException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean ValidateUsername(String username) {
        Pattern pattern = Pattern.compile("\\w{3,15}@[a-z]{2,5}.[a-z]{2,5}");
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }

    @Override
    public boolean ValidatePassword(String password) {
        Pattern pattern = Pattern.compile("^([A-Z+a-z+0-9@$!%*#?&^()]{8,30})$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    @Override
    public boolean ValidateFirstName(String firstName) {
        Pattern patter = Pattern.compile("^[A-Za-z]{2,15}$");
        Matcher matcher = patter.matcher(firstName);
        return matcher.find();
    }

    @Override
    public boolean ValidateLastName(String lastName) {
        Pattern patter = Pattern.compile("^[A-Za-z]{2,15}$");
        Matcher matcher = patter.matcher(lastName);
        return matcher.find();
    }

    @Override
    public boolean ValidateAge(int age) {
        boolean isValid = true;
        if(age < 14 || age > 122) isValid = false;
        return isValid;
    }

    @Override
    public boolean ValidatePhone(String phone) {
        boolean isValid = true;
        for (int i = 0; i < phone.length(); i++) if(!Character.isDigit(phone.charAt(i))) isValid = false;
        return isValid;
    }
}
