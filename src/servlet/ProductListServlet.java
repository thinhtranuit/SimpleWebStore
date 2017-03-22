package servlet;

import bean.Product;
import bean.UserAccount;
import conn.MySQLConnUltis;
import ultis.DBUltis;
import ultis.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by THINH TRAN on 19-Mar-17.
 */
@WebServlet(name = "ProductListServlet", urlPatterns = "/productList")
public class ProductListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = MyUtils.getStoredConnection(request);
        HttpSession session = request.getSession();
        UserAccount acc = MyUtils.getLoginedUser(session);
        String error = "";
        if (acc == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        } else {
            List<Product> products = new ArrayList<>();
            try {
                products = DBUltis.findAllProduct(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (products.size() == 0) {
                error = "There is no product";
            }
            request.setAttribute("products", products);
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/productListView.jsp");
            rd.forward(request, response);
        }
    }
}
