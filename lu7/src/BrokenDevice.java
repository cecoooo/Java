import java.util.Scanner;

public class BrokenDevice extends Device{

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
        super();
    }
    public BrokenDevice(String b, String m, double p, String id, String s, int d){
        super();
        this.symptoms = s;
        this.daysToRecover = d;
    }

    public void EnterData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter device data.");
        System.out.print("brand:");
        this.symptoms = sc.nextLine();
        System.out.print("model:");
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
