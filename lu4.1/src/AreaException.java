public class AreaException extends Exception{
    public String getMessage(){
        return "Area must not be lower than or equal to zero.";
    }
}
