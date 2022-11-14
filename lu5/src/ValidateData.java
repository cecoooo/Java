import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {
    public static boolean validateUsername(String username){
        Pattern pattern = Pattern.compile("[a-zA-Z1-9-_]{3,15}");
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    public static boolean validatePassword(String pass){
        Pattern pattern = Pattern.compile("[a-zA-Z]{11,36}");
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String phNumber){
        Pattern pattern = Pattern.compile("[0-9]{8,20}");
        Matcher matcher = pattern.matcher(phNumber);
        return matcher.matches();
    }
}
