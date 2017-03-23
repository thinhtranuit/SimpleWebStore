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
 * Created by THINH TRAN on 23-Mar-17.
 */
@WebServlet(name = "DoAddProductServlet", urlPatterns = "/doAddProduct")
public class DoAddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("newCode");
        String name = request.getParameter("newName");
        Float price = Float.valueOf(request.getParameter("newPrice"));
        Connection connection = MyUtils.getStoredConnection(request);
        try {
            Product product = DBUltis.findProduct(connection, code);
            if (product != null){
                request.setAttribute("error","This product is under control by our store");
                RequestDispatcher rd = request.getRequestDispatcher("/addProduct");
                rd.forward(request, response);
            } else {
                Product newProduct = new Product(code, name, price);
                DBUltis.insertProduct(connection, newProduct);
                response.sendRedirect(request.getContextPath() + "/productList");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
