public class InvalidEGNException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid EGN.\n" +
                "EGN must contains 10 digits.";
    }
}
