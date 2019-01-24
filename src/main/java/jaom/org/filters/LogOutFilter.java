package jaom.org.filters;

import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LogOutFilter", urlPatterns = {"/logout","/session-info"})
public class LogOutFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse ) resp;
        HttpSession session = request.getSession(false);

        if (session!=null) {
            chain.doFilter(req, resp);
        }
        else{
            JSONObject json = new JSONObject();
            response.getWriter().print(json.put("status",401).put("message","Not Logged In"));
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
