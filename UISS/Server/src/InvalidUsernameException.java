public class InvalidUsernameException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid username.\n" +
                "Username must include at least one character and domain '@tu-sofia.bg'";
    }
}
