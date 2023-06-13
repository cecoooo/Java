package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LightShop extends JFrame{
    private Model[] databaseModel = {
        new Model(1, 88.90, 6, "desk lamp", 100),
        new Model(2, 20.00, 6, "ceiling lamp", 160),
        new Model(3, 31.90, 12, "LED", 100),
        new Model(4, 2.30, 9, "bulb", 1000),
        new Model(5, 213.90, 40, "chandelier", 5)
    };
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtCity;
    private JButton submitCustomerData;
    private JPanel Main;
    private JTextField txtModel;
    private JTextField quantity;
    private JButton subData;
    private JLabel chooseAProduct;
    private JLabel quan;
    private JComboBox comboDelivary;
    private JLabel labelDelivary;

    public LightShop() {
        submitCustomerData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String email = txtEmail.getText();
                String phone = txtPhone.getText();
                String city = txtCity.getText();
                if(name.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your name");
                    makeInvisible();
                }
                else if(email.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your email");
                    makeInvisible();
                }
                else if(phone.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your phone");
                    makeInvisible();
                }
                else if(city.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your city");
                    makeInvisible();
                }
                else{
                    makeVisible();
                }
            }
        });
        subData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = createCustomer();
                String modelName = txtModel.getText();
                int numOFItems = createNumOFItems();
                try {
                    Model model = null;
                    for (int i = 0; i < databaseModel.length; i++){
                        if(modelName.equals(databaseModel[i].getName())){
                            model = databaseModel[i];
                        }
                    }
                    if(model != null){
                        if(model.getQuantity_left() < numOFItems){
                            JOptionPane.showMessageDialog(null,"Model is available but we do not have that quantity.");
                        }
                        else{
                            Order order = createOrder();
                            JOptionPane.showMessageDialog(null, orderMessage(numOFItems, modelName, customer, order));
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No model like that in the shop.");
                    }
                }catch (Exception exx){
                    exx.printStackTrace();
                }
            }
        });
    }

    private void makeVisible(){
        txtModel.setVisible(true);
        quan.setVisible(true);
        quantity.setVisible(true);
        subData.setVisible(true);
        chooseAProduct.setVisible(true);
        comboDelivary.setVisible(true);
        labelDelivary.setVisible(true);
    }
    private void makeInvisible(){
        txtModel.setVisible(false);
        quan.setVisible(false);
        quantity.setVisible(false);
        subData.setVisible(false);
        chooseAProduct.setVisible(false);
        comboDelivary.setVisible(false);
        labelDelivary.setVisible(false);
    }
    private Customer createCustomer(){
        return new Customer(this.txtName.getText(), this.txtEmail.getText(), this.txtPhone.getText(), this.txtCity.getText());
    }
    private Order createOrder(){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(utilDate.getTime());
        return new Order(sqlDate, this.comboDelivary.getSelectedItem().toString());
    }
    private int createNumOFItems(){
        int numOFItems = 0;
        while(true) {
            try {
                numOFItems = Integer.parseInt(quantity.getText());
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid number");
                try {
                    subData.getActionListeners()[0].wait();
                }catch ( InterruptedException exception){
                    exception.printStackTrace();
                }
            }
        }
        return numOFItems;
    }
    private String orderMessage(int numOFItems, String modelName, Customer customer, Order order){
        StringBuilder sb = new StringBuilder();
        sb.append("-ORDER DETAILS-\n").append("Model: "+modelName).append("\nQuantity: ").append(numOFItems+"\n").
                append("Delivery firm: "+order.getFirmName()+"\n\n").
                append("-YOUR DATA-\n").append("Name: " + customer.getName()+"\n").
                append("Email: "+customer.getEmail()+"\n").
                append("Phone: "+customer.getPhone()+"\n").
                append("City: "+customer.getCity());
        return sb.toString();
    }

    public static void main(String[] args) {
        LightShop ls = new LightShop();
        ls.setContentPane(new LightShop().Main);
        ls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ls.setVisible(true);
        ls.pack();
    }
}