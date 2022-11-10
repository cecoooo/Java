public class PowerException extends Exception{
    public String getMessage(){
        return "Power must be greater than 0W and less than 1000W.";
    }
}
