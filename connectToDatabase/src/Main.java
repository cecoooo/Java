import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://@localhost:3306/lights_shop", "root", "nPcFu9W^DmCyDP*f");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from models");

            while(resultSet.next()){
                Model model = new Model(resultSet.getDouble(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getInt(5));
                System.out.println(model.ToString()+"\n");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}