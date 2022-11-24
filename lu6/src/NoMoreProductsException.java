public class NoMoreProductsException extends Exception{
    @Override
    public String getMessage() {
        return "There are no more products.";
    }
}
