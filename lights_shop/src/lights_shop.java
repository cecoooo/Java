import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lights_shop extends JFrame{
    private JTextField txtName;
    private JTextField txtEmail;
    private JTextField txtPhone;
    private JTextField txtCity;
    private JButton submitCustomerData;
    private JPanel Main;

    public lights_shop() {
        submitCustomerData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
