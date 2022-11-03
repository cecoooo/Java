public class Car extends Vehical implements IsLandVehical{

    private int power;

    public int getPower(){
        return this.power;
    }
    public void setPower(int n){
        this.power = n;
    }

    public Car(int ms, String m, double p, int power) {
        super(ms, m, p);
        this.power = power;
    }

    @Override
    public double ckeckPromo() {
        return this.getPrice()*0.8;
    }

    public void enterLand(){
        System.out.println("Run");
    }
}
