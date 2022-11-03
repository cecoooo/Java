public class Hovercraft extends Vehical implements IsLandVehical, IsSeaVessel{
    private int passengers;

    public int getNumOfPassengers(){
        return this.passengers;
    }

    public void setNumOfPassengers(int pass){
        this.passengers = pass;
    }

    public Hovercraft(int ms, String m, double p, int pass) {
        super(ms, m, p);
        this.passengers = pass;
    }

    @Override
    public double ckeckPromo() {
        return this.getPrice()*0.97;
    }

    public void enterLand(){
        System.out.println("Run");
    }
    public void enterSea(){
        System.out.println("Swim");
    }
}
