public class WrongUserException extends Exception{
    public String getMessage(){
        return "Invalid username or password.";
    }
}
