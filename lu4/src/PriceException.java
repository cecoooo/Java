public class PriceException extends Exception{
    public String getMessage(){
        return "Price must not be lower than zero.";
    }
}
