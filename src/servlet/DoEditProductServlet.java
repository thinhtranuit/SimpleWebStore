package servlet;

import bean.Product;
import ultis.DBUltis;
import ultis.MyUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by THINH TRAN on 19-Mar-17.
 */
@WebServlet(name = "DoEditProductServlet", urlPatterns = "/doEditProduct")
public class DoEditProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String newName = request.getParameter("newName");
        float newPrice = Float.parseFloat(request.getParameter("newPrice"));
        Connection connection = MyUtils.getStoredConnection(request);
        try {
            Product newProduct = new Product(code, newName, newPrice);
            DBUltis.updateProduct(connection, newProduct);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/productList");
    }
}
