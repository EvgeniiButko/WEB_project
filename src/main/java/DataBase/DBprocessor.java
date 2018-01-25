package DataBase;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBprocessor {
    private Connection connection;
    public DBprocessor() throws SQLException {
        DriverManager.registerDriver(new FabricMySQLDriver());
    }

    public Connection getConnection(String url, String username, String password)throws SQLException{
        if(connection != null)
            return connection;

        connection = DriverManager.getConnection(url,username,password);
        if(connection == null){
            System.out.println("connection == null in DBprocessor");
        }
        return connection;
    }
}
