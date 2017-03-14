package ultis;

import bean.UserAccount;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Connection;

/**
 * Created by THINH TRAN on 11-Mar-17.
 */
public class MyUtils {
    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";
    private static final String LOGINED_USER = "USER_ACCOUNT_WHO_HAVE_LOG_IN_WAS_STORE_IN_SESSION";


    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }

    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }

    public static void storeLoginedUser(HttpSession session, UserAccount user){
        session.setAttribute(LOGINED_USER, user);
    }

    public static UserAccount getLoginedUser(HttpSession session){
        return (UserAccount) session.getAttribute(LOGINED_USER);
    }

    public static void storeUserInCookie(HttpServletResponse response, UserAccount account){
        Cookie cookie = new Cookie(ATT_NAME_USER_NAME, account.getUserName());
        cookie.setMaxAge(3 * 60 * 60);
        response.addCookie(cookie);
    }

    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 giây. (Hết hạn ngay lập tức)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }
}
