import java.util.Arrays;
import java.util.Scanner;

public class House extends Building{
    private int grades;
    private String owner;

    public House(){
        super();
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) throws GradesException{
        if(grades < 1 || grades > 6)
            throw new GradesException();
        else
            this.grades = grades;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        System.out.print("Grades: ");
        int grades = sc.nextInt();
        sc.nextLine();
        System.out.print("Owner: ");
        String owner = sc.nextLine();
        try{
            this.setHeight(h);
            this.setArea(area);
            this.setAddress(address);
            this.setGrades(grades);
            this.setOwner(owner);
        }
        catch (HeightException e){
            e.printStackTrace();
        }
        catch (AreaException e){
            e.printStackTrace();
        }
        catch (GradesException e){
            e.printStackTrace();
        }
    }

    public String toString(){
        return "Data:\n" +
                "height: " + this.getHeight() + "\n" +
                "area: " + this.getArea() + "\n" +
                "address: " + this.getAddress() + "\n" +
                "grades: " + this.getGrades() + "\n" +
                "Owner: " + this.getOwner();
    }

    public House heightestGrade(House[] arr){
        House obj = new House();
        double max = Integer.MIN_VALUE;
        for (House house : arr) {
            try {
                double curr = house.getHeight() / house.getGrades() * 1.0;
                if(curr > max){
                    max = curr;
                    obj = house;
                }
            }
            catch (ArithmeticException e){
                e.printStackTrace();
            }
        }
        return obj;
    }
}
