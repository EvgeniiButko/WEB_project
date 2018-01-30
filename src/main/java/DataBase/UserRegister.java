package DataBase;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegister {
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

    public static synchronized void addUser(String login,String password,String mail){
        if(login.length()<4 && password.length() < 4 && mail.length() < 4)return;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(Url,User,Password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products.users(login,password,mail) " +
                    "VALUES (?,?,?)");){
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,mail);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
