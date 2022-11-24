import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Provider implements ValidatePhone{

    String phoneNumber;
    String name;

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        if(this.validatePhoneNumber(phoneNumber))
            this.phoneNumber = phoneNumber;
        else {
            try{
                throw  new WrongPhoneNumberException();
            }catch (WrongPhoneNumberException e){
                e.printStackTrace();
            }
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Provider(){

    }
    public Provider(String pn, String name){
        this.phoneNumber = pn;
        this.name = name;
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {
        Pattern patter = Pattern.compile("[0-9]{10}");
        Matcher matcher = patter.matcher(phoneNumber);
        if(matcher.matches())
            return true;
        else
            return false;
    }
}
