package filter;

import conn.ConnectionUltis;
import ultis.MyUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by THINH TRAN on 14-Mar-17.
 */
@WebFilter(filterName = "DBFilter", urlPatterns = "/*")
public class DBFilter implements Filter {
    public void destroy() {
    }

    private static boolean checkNeedDatabase(HttpServletRequest request){
        String urlPartten = request.getServletPath();
        String pathInfo = request.getPathInfo();
        if (pathInfo != null){
            urlPartten += "/*";
        }
        Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
                .getServletRegistrations();

        Collection<? extends ServletRegistration> values = servletRegistrations.values();
        for (ServletRegistration sr : values) {
            Collection<String> mappings = sr.getMappings();
            if(mappings.contains(urlPartten)){
                return true;
            }
        }
        return false;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (checkNeedDatabase((HttpServletRequest) req)){
            try {
                MyUtils.storeConnection(req, ConnectionUltis.getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
