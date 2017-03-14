package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by THINH TRAN on 11-Mar-17.
 */
public class MySQLConnUltis {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String hostname = "localhost";
        String user = "root";
        String password = "215333325";
        String databasename = "store";
        String connectionUrl = "jdbc:mysql://" + hostname + ":3306/" + databasename;
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(connectionUrl,user, password);
    }
}
