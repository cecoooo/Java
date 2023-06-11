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
    private JLabel txtData;
    private JLabel txtDataEmail;
    private JLabel txtDataPhone;
    private JLabel txtDataCity;
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
                txtData.setText("Name: " + name);
                txtDataEmail.setText("Email: " + email);
                txtDataPhone.setText("Phone: " + phone);
                txtDataCity.setText("City: " + city);
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

            private void makeVisible(){
                txtData.setVisible(true);
                txtDataEmail.setVisible(true);
                txtDataPhone.setVisible(true);
                txtDataCity.setVisible(true);
                txtModel.setVisible(true);
                quan.setVisible(true);
                quantity.setVisible(true);
                subData.setVisible(true);
                chooseAProduct.setVisible(true);
                comboDelivary.setVisible(true);
                labelDelivary.setVisible(true);
            }
            private void makeInvisible(){
                txtData.setVisible(false);
                txtDataEmail.setVisible(false);
                txtDataPhone.setVisible(false);
                txtDataCity.setVisible(false);
                txtModel.setVisible(false);
                quan.setVisible(false);
                quantity.setVisible(false);
                subData.setVisible(false);
                chooseAProduct.setVisible(false);
                comboDelivary.setVisible(false);
                labelDelivary.setVisible(false);
            }
        });
        subData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer customer = createCustomer();
                String modelName = txtModel.getText();
                int numOFItems;
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
                try {
                    Model model = null;
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lights_shop", "root", "nPcFu9W^DmCyDP*f");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from models where name_light = " + "\"" + modelName+ "\"");
                    while(resultSet.next()) {
                        model = new Model(resultSet.getDouble(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
                    }
                    if(model != null){
                        if(model.getQuantity_left() < numOFItems){
                            JOptionPane.showMessageDialog(null,"Model is available but we do not have that quantity.");
                        }
                        else{
                            StringBuilder sb = new StringBuilder();
                            sb.append("You successfully ordered ").append(numOFItems).append(" lights of type ").append(modelName);
                            ResultSet resultSetCustomers = statement.executeQuery("select name from customers where name = "+ "\"" + txtName.getText()+ "\"");
                            if(resultSetCustomers.getFetchSize() == 0){
                                PreparedStatement ps = connection.prepareStatement(" insert into customers (name, email, phone, city)"
                                        + " values (?, ?, ?, ?)");
                                ps.setString(1, customer.getName());
                                ps.setString(2, customer.getEmail());
                                ps.setString(3, customer.getPhone());
                                ps.setString(4, customer.getCity());
                                ps.execute();
                            }else{

                            }
                            ResultSet resultSetCustomer = statement.executeQuery("select id from customers where name = "+ "\"" + customer.getName()+ "\"");
                            Order order = createOrder(resultSetCustomer.getInt(1));
                            PreparedStatement psO = connection.prepareStatement(" insert into orders (order_date, firm_name, is_filled, customer_id)"
                                    + " values (?, ?, ?, ?)");
                            psO.setDate(1, order.getOrderDate());
                            psO.setString(2, order.getFirmName());
                            psO.setBoolean(3, order.isFilled());
                            psO.setInt(4, order.getCustomerId());
                            psO.execute();
                            OrderedProduct orderedProduct = createOrderProduct(numOFItems ,modelName, order.getOrderDate(), order.getCustomerId());
                            PreparedStatement psOP = connection.prepareStatement(" insert into ordered_product (quantity, model_id, order_id)"
                                    + " values (?, ?, ?, ?)");
                            psOP.setInt(1, orderedProduct.getQuantity());
                            psOP.setInt(2, orderedProduct.getModelId());
                            psOP.setInt(3, orderedProduct.getOrderId());
                            psOP.execute();
                            connection.close();
                            JOptionPane.showMessageDialog(null, sb.toString());
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

    private Customer createCustomer(){
        return new Customer(this.txtName.getText(), this.txtEmail.getText(), this.txtPhone.getText(), this.txtCity.getText());
    }
    private Order createOrder(int cusId){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return new Order(sqlDate, this.comboDelivary.getToolTipText(), false, cusId);
    }

    private OrderedProduct createOrderProduct(int numOfItems, String modelName, java.sql.Date orderDate, int CustomerId){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lights_shop", "root", "nPcFu9W^DmCyDP*f");
            Statement statement = connection.createStatement();
            ResultSet resultSetM = statement.executeQuery("select id from models where name_light = " + "\"" + modelName + "\"");
            ResultSet resultSetO = statement.executeQuery("select id from orders where order_date = " + "\"" + orderDate + "\" and customer_id = "+ "\"" + CustomerId + "\"");
            return new OrderedProduct(numOfItems, resultSetM.getInt(1), resultSetO.getInt(1));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        lights_shop ls = new lights_shop();
        ls.setContentPane(new lights_shop().Main);
        ls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ls.setVisible(true);
        ls.pack();
    }
}