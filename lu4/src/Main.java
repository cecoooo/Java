public class Main {
    public static void main(String[] args) {
        Books book = new Books();
        TVs tv = new TVs();
        try{
            book.setPrice(-10);
        }catch (PriceException e){
            e.printStackTrace();
        }
        try{
            tv.setPowerW(1500);
        }catch (PowerException e){
            e.printStackTrace();
        }
    }
}