public class InvalidFirstOrLastNameException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid Name.\n" +
                "Both names must be between 2 and 15 symbols long and include only letters.";
    }
}
