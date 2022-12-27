public class InvalidUsernameException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid username.\n" +
                "Your domain must be between 2-5 symbols long and include only lowercase letters.";
    }
}
