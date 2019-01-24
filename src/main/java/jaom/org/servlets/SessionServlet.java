package jaom.org.servlets;

import jaom.org.utils.DB;
import jaom.org.utils.PropertiesReader;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(name = "SessionServlet",urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject body = new JSONObject(request.getReader().lines().collect(Collectors.joining(System.lineSeparator())));
        JSONObject res = new JSONObject();
        PrintWriter out = response.getWriter();
        DB db = new DB();
        JSONArray rs = db.executeQuery(PropertiesReader.getInstance().getValue("login"),body.getInt("ced"),body.getString("password"));
        if (rs.length()>0){
            db.closeCon();
            HttpSession session = request.getSession();
            session.setAttribute("user",body.toString());
            out.print(res.put("status",200).put("message","login successful"));
        }else{
            out.print(res.put("status",404).put("message","Username or password incorrect").toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
