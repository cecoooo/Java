public class Ship extends Vehical implements IsSeaVessel{

    private double deadweight;

    public double getDeadweight(){
        return this.deadweight;
    }
    public void setDeadweight(double d){
        this.deadweight = d;
    }

    public Ship(int ms, String m, double p, double d) {
        super(ms, m, p);
        this.deadweight = d;
    }

    @Override
    public double ckeckPromo() {
        return this.getPrice()*0.997;
    }

    public void enterSea(){
        System.out.println("Swim");
    }
}
