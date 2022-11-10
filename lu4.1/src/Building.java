import java.util.Scanner;

public class Building {
    private int height;
    private double area;
    private String address;

    public Building(){

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws HeightException {
        if(height < 2)
            throw new HeightException();
        else
            this.height = height;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) throws AreaException{
        if(area <= 0)
            throw new AreaException();
        else
            this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void EnterDataForObject(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter data for house:");
        System.out.print("Height: ");
        int h = sc.nextInt();
        sc.nextLine();
        System.out.print("Area: ");
        double area = sc.nextDouble();
        sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        try{
            this.setHeight(h);
            this.setArea(area);
            this.setAddress(address);
        }
        catch (HeightException e){
            e.printStackTrace();
        }
        catch (AreaException e){
            e.printStackTrace();
        }
    }

    public String toString(){
        return "Data:\n" +
                "height: " + this.getHeight() + "\n" +
                "area: " + this.getArea() + "\n" +
                "address: " + this.getAddress() + "\n";
    }
}
