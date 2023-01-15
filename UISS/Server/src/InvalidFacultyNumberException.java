public class InvalidFacultyNumberException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid faculty number.\n" +
                "Faculty number must contains 9 digits.";
    }
}
