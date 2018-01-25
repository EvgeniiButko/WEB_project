package BAckEnd;
import DataBase.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public static synchronized List<Post> getPosts() throws SQLException {
        return DataReturner.getReturnArray();
    }

    public static synchronized void deletePost(int id){
        try {
            DataReturner.deletePost(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void addPost(String txt){
        try {
            DataReturner.addPost(txt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
