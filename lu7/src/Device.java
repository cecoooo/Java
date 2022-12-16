import java.io.Serializable;
import java.util.Scanner;

public class Device implements Serializable {
    private static final long serialVersionUID = 1L;
    private String brand;
    private double price;
    private String model;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Device(){

    }
    public Device(String brand, String model, double price, String id){
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.id = id;
    }

    public void EnterData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter device data.");
        System.out.print("brand:");
        brand = sc.nextLine();
        System.out.print("model:");
        model = sc.nextLine();
        System.out.print("price:");
        price = sc.nextDouble();
    }

    public String toString(){
        return "Device data.\n" +
                "brand: " + this.brand+"\n" +
                "model: " + this.model + "\n" +
                "price: " + this.price;
    }
}
