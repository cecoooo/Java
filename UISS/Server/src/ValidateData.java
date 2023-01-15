import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateData {
    public static boolean Username(String username){
        Pattern pattern = Pattern.compile("^\\w+@tu-sofia.bg$");
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }
    public static boolean Password(String password){
        Pattern pattern = Pattern.compile("^.{5,30}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
    public static boolean Fnum(String fnum){
        Pattern pattern = Pattern.compile("^\\d{9}$");
        Matcher matcher = pattern.matcher(fnum);
        return matcher.find();
    }
    public static boolean EGN(String egn){
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(egn);
        return matcher.find();
    }
}
