import java.util.ArrayList;

public class Offert {
    private int offertId;
    private String destination;
    private String nameOfHotel;
    private double price;
    private double rating;
    private ArrayList<Double> evaluation = null;

    public Offert(){
        this.evaluation = new ArrayList<Double>();
    }

    public int getOffertId() {
        return offertId;
    }

    public void setOffertId(int offertId) {
        this.offertId = offertId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getNameOfHotel() {
        return nameOfHotel;
    }

    public void setNameOfHotel(String nameOfHotel) {
        this.nameOfHotel = nameOfHotel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public ArrayList<Double> getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(double evaluation) {
        this.evaluation.add(evaluation);
        double sum = 0;
        for (int i = 0; i < this.evaluation.size(); i++){
            sum+=this.evaluation.get(i);
        }
        this.rating = sum/this.evaluation.size();
    }

    public String toString(){
        return this.offertId+"\n"+
                this.destination+"\n"+
                this.nameOfHotel+"\n"+
                this.price+"\n"+
                this.rating;
    }
}
