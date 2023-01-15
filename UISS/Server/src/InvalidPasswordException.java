public class InvalidPasswordException extends Exception{
    public String getMessage(){
        return "Invalid password.\n" +
                "Password must include at least 5 characters.";
    }
}
