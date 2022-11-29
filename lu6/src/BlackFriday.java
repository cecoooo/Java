import java.io.IOException;

public class BlackFriday {

    private ProductLoader productLoader;

    public void setProductLoader(ProductLoader pr) {
        this.productLoader = pr;
    }

    public ProductLoader getProductLoader() {
        return productLoader;
    }

    public BlackFriday(){

    }
    public BlackFriday(ProductLoader pr){
        this.productLoader = pr;
    }

    public static void processSales(ProductLoader productLoader){
        int elLen = 0;
        int bookLen = 0;
        try {
            Object[] arr = productLoader.importDataFromFile();
            for (int i = 0; i < arr.length; i++){
                if(arr[i] instanceof Electronics)
                    elLen++;
                else
                    bookLen++;
            }
            Electronics[] electronics = new Electronics[elLen];
            Book[] books = new Book[bookLen];
            int elCount = 0;
            int bookCount = 0;
            for (int i = 0; i < arr.length; i++){
                if(arr[i] instanceof Electronics)
                    electronics[elCount] = (Electronics) arr[i];
                else
                    books[bookCount] = (Book) arr[i];
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
