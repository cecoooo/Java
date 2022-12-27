public class InvalidResponceException extends Exception{
    @Override
    public String getMessage() {
        return "Your response is NOT valid!\n" +
                "Please follow our rules and requirements.";
    }
}
