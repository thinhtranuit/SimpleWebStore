package ultis;

import bean.Product;
import bean.UserAccount;
import conn.ConnectionUltis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by THINH TRAN on 12-Mar-17.
 */
public class DBUltis {
    public static UserAccount findUser(Connection conn, String user, String password) throws SQLException {
        String querry = "Select * from user_account where USER_NAME = ? and PASSWORD = ?";
        PreparedStatement ps = conn.prepareStatement(querry);
        ps.setString(1, user);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String gender = rs.getString("GENDER");
            UserAccount account = new UserAccount(user, gender, password);
            return account;
        }
        return null;
    }

    public static UserAccount findUser(Connection conn, String user) throws SQLException {
        String querry = "Select * from user_account where USER_NAME = ?";
        PreparedStatement ps = conn.prepareStatement(querry);
        ps.setString(1, user);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String gender = rs.getString("GENDER");
            String password = rs.getString("PASSWORD");
            UserAccount account = new UserAccount(user, gender, password);
            return account;
        }
        return null;
    }

    public static List<Product> findAllProduct(Connection conn) throws SQLException {
        String query = "Select a.Code, a.Name, a.Price from Product a";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Product> products = new ArrayList<>();
        while (rs.next()) {
            String code = rs.getString("CODE");
            String name = rs.getString("NAME");
            float price = rs.getFloat("PRICE");
            Product product = new Product(code, name, price);
            products.add(product);

        }
        return products;
    }

    public static Product findProduct(Connection conn, String code) throws SQLException {
        String query = "Select a.Name, a.Price from Product a where a.Code = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, code);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String name = rs.getString(1);
            float price = rs.getFloat(2);
            Product product = new Product(code, name, price);
            return product;
        }
        return null;
    }

    public static void deleteProduct(Connection connection, Product product) throws SQLException {
        String query = "Delete from Product where code = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, product.getCode());
        ps.executeUpdate();
    }

    public static void insertProduct(Connection connection, Product product) throws SQLException {
        String query = "Insert into Product(Code, Name, Price) values (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, product.getCode());
        ps.setString(2, product.getName());
        ps.setFloat(3, product.getPrice());
        ps.executeUpdate();
    }

    public static void main(String[]agrs){
        Product product = new Product("IT001", "Nhap mon lap trinh", 150000);
        try {
            Connection connection = ConnectionUltis.getConnection();
            insertProduct(connection,product);
            List<Product> products = findAllProduct(connection);
            for(Product product1 : products){
                System.out.println(product1.getCode() + " " + product.getName() + " " + product1.getPrice());
            }
            deleteProduct(connection, product);
            products = findAllProduct(connection);
            for(Product product1 : products){
                System.out.println(product1.getCode() + " " + product.getName() + " " + product1.getPrice());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
