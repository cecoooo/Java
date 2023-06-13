package org.example;

public class Model {
    private int id;
    private double price;
    private int power;
    private String name;
    private int quantity_left;

    public Model(){

    }
    public Model(int id, double price, int power, String name, int quantity_left){
        this.id = id;
        this.price = price;
        this.power = power;
        this.name = name;
        this.quantity_left = quantity_left;
    }


    public double getPrice() {
        return price;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public int getQuantity_left() {
        return quantity_left;
    }

    public String ToString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.price+"\n").
                append(this.power+"\n").
                append(this.name+"\n").
                append(this.quantity_left+"\n");
        return sb.toString();
    }
}
