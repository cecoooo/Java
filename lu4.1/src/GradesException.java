public class GradesException extends Exception{
    public String getMessage(){
        return "House grades must be between 1 and 6.";
    }
}
