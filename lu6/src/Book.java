import java.awt.dnd.DragSourceMotionListener;

public class Book extends Product{
    String author;
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(){

    }

    public Book(String author, String title){
        this.author = author;
        this.title = title;
    }

    @Override
    double getPromotionalPrice() {
        return this.price*0.5;
    }

    @Override
    boolean sellProduct(int piece) {
        int remain = this.quantity - piece;
        if(remain >= 0)
            return true;
        try{
            throw new NoMoreProductsException();
        }catch (NoMoreProductsException e){
            e.printStackTrace();
        }
        return false;
    }
}
