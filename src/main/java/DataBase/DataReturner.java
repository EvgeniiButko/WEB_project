package DataBase;
import BAckEnd.*;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products.product");) {


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                returnArray.add(new Post(resultSet.getInt("ID"),
                        resultSet.getString("Name")));
            }

        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("блять.");
        }

        return returnArray;
    }

    public static void addPost(String txt) throws SQLException {
       try(Connection connection = DriverManager.getConnection(Url,User,Password);
           PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO products.product(Name) VALUES (?)");){
           preparedStatement.setString(1,txt);
           preparedStatement.executeUpdate();
       }
    }

    public static void deletePost(int id) throws SQLException {
        try(Connection connection = DriverManager.getConnection(Url,User,Password);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM products.product WHERE ID = ?");){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
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

