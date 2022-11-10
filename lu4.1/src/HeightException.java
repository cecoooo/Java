public class HeightException extends Exception{
    public String getMessage(){
        return "Height of the Building must not be less than 2m.";
    }
}
