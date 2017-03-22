package servlet;

import bean.UserAccount;
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

/**
 * Created by THINH TRAN on 17-Mar-17.
 */
@WebServlet(name = "DoLoginServlet", urlPatterns = "/doLogin")
public class DoLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String rememberStr = request.getParameter("remember");
        boolean remember = "Y".equals(rememberStr);
        Connection connection = MyUtils.getStoredConnection(request);

        boolean hasError = false;
        String error = null;
        UserAccount account = null;
        if (userName == null || password == null || userName.length() == 0 || password.length() == 0){
            hasError = true;
            error = "Required username and password";
        } else {
            try {
                account = DBUltis.findUser(connection, userName, password);
                if (account == null){
                    hasError = true;
                    error = "Invalid username or password";
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (hasError){
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/loginView.jsp");
            rd.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedUser(session, account);
            System.out.println(rememberStr);
            System.out.println(remember);
            if (remember){
                MyUtils.storeUserInCookie(response, account);
            } else {
                MyUtils.deleteUserCookie(response);
            }
            response.sendRedirect(request.getContextPath() + "/userInfo");
        }
    }
}
