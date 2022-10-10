import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("------This is our Geometric Calculator------");
        Scanner sc = new Scanner(System.in);
        Square sq = new Square();
        sq.setSide(sc.nextInt());
        System.out.println(sq.toString());
    }
}

class Square extends BaseShape{
    private double side;

    public double getSide(){
        return this.side;
    }
    public void setSide(double s){
        this.side = s;
    }

    double Area(){
        return this.side*this.side;
    }

    double Perimeter(){
        return 4*this.side;
    }
    public String toString(){
        return String.format("Shape type: Square\n" +
                "Side length: %s\n" +
                "Ares: %s\n" +
                "Perimeter: %s", this.side, this.Area(), this.Perimeter());
    }
}

abstract class BaseShape{
    abstract double Area();
    abstract double Perimeter();

    public String toString(){
        return "";
    }
}