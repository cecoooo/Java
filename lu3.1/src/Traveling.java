public abstract class Traveling {
    private String destination;
    private int days;
    private double price;

    public void setDestination(String d){
        this.destination = d;
    }
    public void setDays(int d){
        this.days = d;
    }
    public void setPrice(double d){
        this.price = d;
    }
    public String getDestination(){
        return this.destination;
    }
    public int getDays(){
        return this.days;
    }
    public double getPrice(){
        return this.price;
    }

    public Traveling(String s, int i, double d){
        this.destination = s;
        this.days = i;
        this.price = d;
    }

    public abstract void fixPrice(double price);
}
