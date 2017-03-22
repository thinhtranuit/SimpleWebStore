package servlet;

import bean.Product;
import ultis.DBUltis;
import ultis.MyUtils;

import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "DeleteProductServlet", urlPatterns = "/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codeParam = request.getParameter("code");
        Connection connection = MyUtils.getStoredConnection(request);
        try {
            Product product = DBUltis.findProduct(connection, codeParam);
            DBUltis.deleteProduct(connection, product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath() + "/productList");
    }
}
