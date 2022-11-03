public class Rest extends Traveling{

    private String nameHotel;

    public String getNameHotel(){
        return this.nameHotel;
    }
    public void setNameHotel(String name){
        this.nameHotel = name;
    }

    public Rest(String s, int i, double d, String name) {
        super(s, i, d);
        this.nameHotel = name;
    }

    @Override
    public void fixPrice(double price) {
        this.setPrice(this.getPrice()*1.4);
    }
}
