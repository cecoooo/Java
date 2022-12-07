import java.io.IOException;

public class BlackFriday {
    public static Electronics[] electronicsArray;
    public static Book[] booksArray;
    public void processSales(){
        ProductLoader productLoader = new ProductLoader();
        try {
            Object[] arr = productLoader.importDataFromFile();
            int countEl = 0;
            int countBook = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] instanceof Electronics)
                    countEl++;
                else if (arr[i] instanceof Book)
                    countBook++;
            }
            Electronics[] arrEl = new Electronics[countEl];
            Book[] arrB = new Book[countBook];
            int e = 0;
            int b = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] instanceof Electronics) {
                    arrEl[e] = (Electronics) arr[i];
                    e++;
                }
                else if (arr[i] instanceof Book) {
                    arrB[b] = (Book) arr[i];
                    b++;
                }
            }
            this.electronicsArray = arrEl;
            this.booksArray = arrB;
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
