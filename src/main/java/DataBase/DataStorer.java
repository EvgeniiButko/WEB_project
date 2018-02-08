package DataBase;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorer {
    private static String Url = "jdbc:mysql://localhost:3306?useSSL=false";
    private static String User = "root";
    private static String Password = "root";

    static{
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addOrder(String city,
                         String name,
                         String sername,
                         String number,
                         String mail, int id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Url,User,Password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products.order2 (id,city," +
                    "name,sername,number,mail) VALUES (?,?,?,?,?,?)");

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,city);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,sername);
            preparedStatement.setString(5,number);
            preparedStatement.setString(6,mail);

            preparedStatement.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex){}
    }

    public static List<Order> getOrders() throws SQLException {
        List<Order> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(Url,User,Password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products.order2");

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                list.add(new Order(resultSet.getInt("id"),
                                   resultSet.getString("city"),
                                   resultSet.getString("name"),
                                   resultSet.getString("sername"),
                                   resultSet.getString("number"),
                                   resultSet.getString("mail"),
                                   resultSet.getString("information")));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }
}