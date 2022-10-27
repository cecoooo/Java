public class Laptop extends Device{
    private int ram;
    private int ssd;

    public int getRAM(){
        return this.ram;
    }
    public int getSSD(){
        return this.ssd;
    }
    public void setRAM(int n){
        this.ram = n;
    }
    public void setSSD(int n){
        this.ssd = n;
    }

    public Laptop(){
        super();
        this.ram = 0;
        this.ssd = 0;
    }
    public Laptop(int uv, String pr, int r, int s){
        super(uv, pr);
        this.ram = r;
        this.ssd = s;
    }
    public Boolean isBetter(Laptop laptop){
        Boolean bool = false;
        if(laptop.getSSD() < this.getSSD() && laptop.getRAM() < this.getSSD()){
            bool = true;
        }
        return bool;
    }
    public String toString(){
        return "Voltage: " + this.getuV() + "\n" +
                "Processor: " + this.getProcessor() + "\n" +
                "RAM: " + this.ram + "\n" +
                "SSD: " + this.ssd;
    }
}
