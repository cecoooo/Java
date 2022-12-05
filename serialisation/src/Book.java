public class Book {
    private String author;
    private String title;
    private double price;

    public void setAuthor(String author){
        this.author = author;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public String getAuthor(){
        return this.author;
    }
    public String getTitle(){
        return this.title;
    }
    public double getPrice(){
        return this.price;
    }

    public Book(){

    }
    public Book(String author, String title, double price){
        this.author = author;
        this.title = title;
        this.price = price;
    }
}
