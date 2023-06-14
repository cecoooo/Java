import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class lights_shop extends JFrame{
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

    public lights_shop() {
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
                    ResultSet resultSet = resultSet("select * from models where name_light = " + "\"" + modelName+ "\"");
                    while(resultSet.next()) {
                        model = new Model(resultSet.getDouble(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
                    }
                    if(model != null){
                        if(model.getQuantity_left() < numOFItems){
                            JOptionPane.showMessageDialog(null,"Model is available but we do not have that quantity.");
                        }
                        else{
                            insertIntoCustomers(customer);
                            ResultSet resultSetCustomer = resultSet("select id from customers where name = "+ "\"" + customer.getName()+ "\"");
                            int customerGetId = 0;
                            while(resultSetCustomer.next()){
                                customerGetId = resultSetCustomer.getInt(1);
                            }
                            Order order = createOrder(customerGetId);
                            InsertIntoOrders(order);
                            OrderedProduct orderedProduct = createOrderProduct(numOFItems, modelName, order.getCustomerId());
                            insertIntoOrderedProduct(orderedProduct);
                            connection().close();
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
    private Statement statement(){
        try {
            return connection().createStatement();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    private Connection connection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/lights_shop", "root", "nPcFu9W^DmCyDP*f");
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private ResultSet resultSet(String query){
        try {
            return statement().executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement prepareStatement(String query){
        try {
            return connection().prepareStatement(query);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private Customer createCustomer(){
        return new Customer(this.txtName.getText(), this.txtEmail.getText(), this.txtPhone.getText(), this.txtCity.getText());
    }
    private Order createOrder(int cusId){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(utilDate.getTime());
        return new Order(sqlDate, this.comboDelivary.getSelectedItem().toString(), false, cusId);
    }

    private OrderedProduct createOrderProduct(int numOfItems, String modelName, int CustomerId){
        try {
            int model_id = 0;
            int order_id = 0;
            ResultSet resultSetM = resultSet("select id from models where name_light = " + "\"" + modelName + "\"");
            ResultSet resultSetO = resultSet("select id from orders where customer_id = " + "\"" + CustomerId + "\"");
            while(resultSetM.next()){
                model_id = resultSetM.getInt(1);
            }
            while(resultSetO.next()){
                order_id = resultSetO.getInt(1);
            }
            return new OrderedProduct(numOfItems, model_id, order_id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
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

    private void insertIntoCustomers(Customer customer){
        try {
            PreparedStatement ps = prepareStatement(" insert into customers (name, email, phone, city)"
                    + " values (?, ?, ?, ?)");
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getCity());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void InsertIntoOrders(Order order){
        try {
            PreparedStatement psO = prepareStatement("insert into orders (order_date, firm_name, is_filled, customer_id)"
                    + " values (?, ?, ?, ?)");
            psO.setTimestamp(1, order.getOrderDate());
            psO.setString(2, order.getFirmName());
            psO.setBoolean(3, order.isFilled());
            psO.setInt(4, order.getCustomerId());
            psO.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void insertIntoOrderedProduct(OrderedProduct orderedProduct){
        try {
            PreparedStatement psOP = prepareStatement(" insert into ordered_product (quantity, model_id, order_id)"
                    + " values (?, ?, ?)");
            psOP.setInt(1, orderedProduct.getQuantity());
            psOP.setInt(2, orderedProduct.getModelId());
            psOP.setInt(3, orderedProduct.getOrderId());
            psOP.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
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
        lights_shop ls = new lights_shop();
        ls.setContentPane(new lights_shop().Main);
        ls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ls.setVisible(true);
        ls.pack();
    }
}