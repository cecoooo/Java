import java.io.Serializable;
import java.util.Scanner;

public class BrokenDevice extends Device implements Serializable {

    private static final long serialVersionUID = 1L;
    private String symptoms;
    private int daysToRecover;

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }


    public int getDaysToRecover() {
        return daysToRecover;
    }

    public void setDaysToRecover(int daysToRecover) {
        this.daysToRecover = daysToRecover;
    }


    public BrokenDevice(){

    }
    public BrokenDevice(String brand, String model, double price, String id, String symptoms, int daysToRecover){
        super(brand, model, price, id);
        this.symptoms = symptoms;
        this.daysToRecover = daysToRecover;
    }

    public void EnterData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter device data.");
        System.out.print("Symptoms:");
        this.symptoms = sc.nextLine();
        System.out.print("Days to recover:");
        this.daysToRecover = sc.nextInt();
    }

    public String toString(){
        return "Device data.\n" +
                "brand: " + this.getBrand()+"\n" +
                "model: " + this.getModel() + "\n" +
                "price: " + this.getPrice() +  "\n" +
                "symptoms: " + this.symptoms + "\n" +
                "Days to recover: " + this.daysToRecover;
    }
}
