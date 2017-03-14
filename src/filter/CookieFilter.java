package filter;

import bean.UserAccount;
import ultis.DBUltis;
import ultis.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by THINH TRAN on 14-Mar-17.
 */
@WebFilter(filterName = "CookieFilter")
public class CookieFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        UserAccount account = MyUtils.getLoginedUser(session);

        //Nếu đã log in thì cho qua servlet tiếp theo
        if (account != null){
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(req, resp);
        } else {
            Connection connection = MyUtils.getStoredConnection(request);
            String check = (String) session.getAttribute("COOKIE_CHECKED");
            if (check == null && connection != null) {
                String userName = MyUtils.getUserNameInCookie(request);
                try {
                    UserAccount acc = DBUltis.findUser(connection, userName);
                    MyUtils.storeLoginedUser(session, acc);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                session.setAttribute("COOKIE_CHECKED", "CHECKED");
            }
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
