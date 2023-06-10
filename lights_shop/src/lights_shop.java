import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
            }
        });
        subData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String modelName = txtModel.getText();
                int numOFItems;
                while(true) {
                    try {
                        numOFItems = Integer.parseInt(quantity.getText());
                        break;
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter valid number");
                        quantity.setText("0");
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

    public static void main(String[] args) {
        lights_shop ls = new lights_shop();
        ls.setContentPane(new lights_shop().Main);
        ls.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ls.setVisible(true);
        ls.pack();
    }
}
