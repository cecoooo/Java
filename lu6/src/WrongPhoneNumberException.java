public class WrongPhoneNumberException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid phone number;";
    }
}
