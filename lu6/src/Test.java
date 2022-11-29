import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        ProductLoader productLoader = new ProductLoader();
        try {
            productLoader.importDataFromFile();
            BlackFriday blackFriday = new BlackFriday();
            blackFriday.processSales(productLoader);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}