public class InvalidAgeException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid age.\n" +
                "You must be between 14 and 122 years-old.";
    }
}
