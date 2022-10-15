import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String args[]) {
        System.out.println("------This is our Geometric Calculator------");
        Scanner sc = new Scanner(System.in);
        Circle circle = new Circle(5);
        System.out.println(circle.toString());
        System.out.println("------------------------");
        Square sq = new Square(6);
        System.out.println(sq.toString());
        Rectangle rect = new Rectangle(4, 6);
        System.out.println("------------------------");
        System.out.println(rect.toString());
    }
}

