package jaom.org.servlets;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutServlet",urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request,javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        JSONObject json = new JSONObject();
        response.getWriter().print(json.put("status",200).put("message","Session finished").toString());
    }
}
