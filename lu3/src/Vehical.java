public abstract class Vehical {
    private int maxSpeed;
    private String model;
    private double price;

    public String getModel(){
        return this.model;
    }
    public int getMaxSpeed(){
        return this.maxSpeed;
    }
    public double getPrice(){
        return this.price;
    }
    public void setModel(String m){
        this.model = m;
    }
    public void setMaxSpeed(int m){
        this.maxSpeed = m;
    }
    public void setPrice(double m){
        this.price = m;
    }

    public Vehical(int ms, String m, double p){
        this.maxSpeed = ms;
        this.model = m;
        this.price = p;
    }

    public abstract double ckeckPromo();
}
