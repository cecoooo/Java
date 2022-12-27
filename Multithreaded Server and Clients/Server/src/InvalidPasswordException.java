public class InvalidPasswordException extends Exception{
    @Override
    public String getMessage() {
        return "Invalid Password.\n" +
                "Password must be between 8 and 30 symbols and include at least one:\n" +
                "- uppercase letter\n" +
                "- lowercase letter\n" +
                "- digit\n" +
                "- special symbol (@$!%*#?&^())";
    }
}
