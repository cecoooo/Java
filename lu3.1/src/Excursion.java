public class Excursion extends Traveling implements NumberOfNights{
    private int hotels;

    public int getHotels(){
        return this.hotels;
    }
    public void setHotels(int i){
        this.hotels = hotels;
    }

    public Excursion(String s, int i, double d, int hotels){
        super(s,i, d);
        this.hotels = hotels;
    }

    public void fixPrice(double price) {
        this.setPrice(this.getPrice()*1.1);
    }

    @Override
    public int NumOfNights(int days) {
        return days-1;
    }
}
