public class Books extends Goods {
    private String author;
    private String header;

    public Books(){
        super();
    }

    public double checkPromo() {
        return this.getPrice()*0.85;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
