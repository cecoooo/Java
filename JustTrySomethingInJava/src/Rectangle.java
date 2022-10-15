public class Rectangle extends BaseShape {

    private double a;
    private double b;

    public void setLength(double side) {this.a = side;}
    public double getLength(){return a;}
    public void setWidth(double side) {this.b = side;}
    public double getWidth(){return b;}

    public Rectangle(){}
    public Rectangle(double length, double width){
        this.a = length;
        this.b = width;
    }

    double Area(){
        return this.a*this.b;
    }
    double Perimeter() {
        return 2*(this.a+this.b);
    }
    public String toString(){
        return String.format("Shape type: Rectangle\n" +
                "Length: %s\n" +
                "Width: %s\n" +
                "Area: %s\n" +
                "Perimeter: %s", this.a, this.b, this.Area(), this.Perimeter());
    }
}
