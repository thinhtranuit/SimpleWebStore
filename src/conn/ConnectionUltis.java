package conn;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by THINH TRAN on 11-Mar-17.
 */
public class ConnectionUltis {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return MySQLConnUltis.getConnection();
    }

    public static void closeQuietly(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollbackQuietly(Connection connection){
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
