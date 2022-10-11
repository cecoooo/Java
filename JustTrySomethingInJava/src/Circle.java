class Circle extends BaseShape {
    private double radius = 0;


    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double rad){
        this.radius = rad;
    }

    public Circle(){

    }
    public Circle(double rad){
        this.radius = rad;
    }

    double Area(){
        return this.radius*this.radius*Math.PI;
    }
    double Perimeter(){
        return this.radius*2*Math.PI;
    }
    public String toString(){
        return String.format("Shape type: Circle\n" +
                "Radius length: %s\n" +
                "Ares: %s\n" +
                "Perimeter: %s", this.radius, this.Area(), this.Perimeter());
    }
}
