package servlet;

import bean.UserAccount;
import ultis.MyUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by THINH TRAN on 17-Mar-17.
 */
@WebServlet(name = "UserInfoServlet", urlPatterns = "/userInfo")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Kiểm tra người dùng login chưa
        UserAccount loginedUser = MyUtils.getLoginedUser(session);

        // Chưa login.
        if (loginedUser == null) {
            // Chuyển hướng về trang login.
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        // Ghi thông tin vào request trước khi forward.
        request.setAttribute("user", loginedUser);

        // Đã login rồi thì chuyển tiếp sang /WEB-INF/views/userInfoView.jsp
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/userInfoView.jsp");
        dispatcher.forward(request, response);
    }
}
