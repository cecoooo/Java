public class TVs extends Goods implements ElectricalAppliance{
    private String manufacturer;
    private String model;
    private int powerW;

    public TVs(){
        super();
    }

    public double checkPromo() {
        return this.getPrice()*0.91;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPowerW() {
        return powerW;
    }

    public void setPowerW(int powerW) throws PowerException{
        if(powerW > 1000 || powerW <= 0)
            throw new PowerException();
        else
            this.powerW = powerW;
    }

    public double ElectricityExpense(double timeInHours) {
        return this.powerW*timeInHours;
    }
}
