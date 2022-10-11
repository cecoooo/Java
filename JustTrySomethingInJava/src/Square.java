import javax.swing.*;

class Square extends BaseShape {
    private double side;

    public double getSide() {
        return this.side;
    }

    public void setSide(double s) {
        this.side = s;
    }

    public Square(){

    }
    public Square(double S){
        this.side = S;
    }

    double Area() {
        return this.side * this.side;
    }

    double Perimeter() {
        return 4 * this.side;
    }

    public String toString() {
        return String.format("Shape type: Square\n" +
                "Side length: %s\n" +
                "Ares: %s\n" +
                "Perimeter: %s", this.side, this.Area(), this.Perimeter());
    }
}
