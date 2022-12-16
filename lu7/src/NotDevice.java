public class NotDevice extends Exception {
    public String getMessage(){
        return "The given object to DeviceIsBroken() is a not from type Device().";
    }
}
