public class InvalidPhoneException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid Phone.\n" +
                "Your phone must include only digits.";
    }
}
