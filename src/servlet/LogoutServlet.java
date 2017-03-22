package servlet;

import bean.UserAccount;
import com.sun.deploy.net.cookie.CookieUnavailableException;
import ultis.DBUltis;
import ultis.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by THINH TRAN on 20-Mar-17.
 */
@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserAccount acc = MyUtils.getLoginedUser(session);
        Cookie[] cookies = request.getCookies();
        if (acc != null) {
            MyUtils.logout(session);
        }
        for (Cookie cookie : cookies){
            if (MyUtils.ATT_NAME_USER_NAME.equals(cookie.getName())){
                MyUtils.deleteUserCookie(response);
                break;
            }
        }
        response.sendRedirect(request.getContextPath());
    }
}
