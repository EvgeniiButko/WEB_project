package DataBase;
import BAckEnd.*;
import BAckEnd.Filters.ClientType;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Class.forName;

public class DataReturner {
    private static String Url = "jdbc:mysql://localhost:3306?useSSL=false";
    private static String User = "root";
    private static String Password = "root";
    private static List<Post> returnArray = null;

    static{
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Post> getReturnArray() throws SQLException {
        returnArray = new LinkedList<Post>();
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try(
            Connection connection = DriverManager.getConnection(Url,User,Password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products.product2");) {


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                returnArray.add(new Post(resultSet.getInt("ID"),
                        resultSet.getString("Name"),resultSet.getString("information")));
            }

        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("блять.");
        }

        return returnArray;
    }

    public static void addPost(String txt,String i) throws SQLException {
       try(Connection connection = DriverManager.getConnection(Url,User,Password);
           PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products.product2(Name,information) VALUES (?,?)");){
           preparedStatement.setString(1,txt);
           preparedStatement.setString(2,i);
           preparedStatement.executeUpdate();
       }
    }

    public static void deletePost(int id) throws SQLException {
        try(Connection connection = DriverManager.getConnection(Url,User,Password);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products.product2 WHERE ID = ?");){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }

    public static void deleteOrder(final int id) throws SQLException{
        try(Connection connection = DriverManager.getConnection(Url,User,Password);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products.order2 WHERE ID = ?");){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }

    public static ClientType getClientTypeFromDB(String log,String pass) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(Url,User,Password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products.users WHERE EXISTS " +
                    "(SELECT * FROM products.users WHERE (login = ? AND password = ?))")){
            preparedStatement.setString(1,log);
            preparedStatement.setString(2,pass);
            int count = preparedStatement.executeUpdate();

            if(count == 1)return ClientType.GUEST;
            if(count == 0)return ClientType.NONE;
        } catch (SQLException e) {
           e.printStackTrace();
           return ClientType.NONE;
        }
        return ClientType.GUEST;
    }
//    public static void main(String[] args) {
//        try {
//            List<Post> list = DataReturner.getReturnArray();
//            list.forEach((a)-> System.out.println(a.getID()+" "+a.getName()));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
    }

