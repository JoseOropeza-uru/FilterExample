package jaom.org.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(urlPatterns = "/Servlet",name = "Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = new JSONObject();
		
		if(request.getHeader("Origin")!=null) {
			json.put("status", 200).put("msg", "GET OK, This CORS filtered");	
		}
		else {
			json.put("status", 200).put("msg", "GET OK, this is not CORS filtered");
		}
		response.getWriter().print(json.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject json = new JSONObject();
		
		if(request.getHeader("Origin")!=null) {
			json.put("status", 200).put("msg", "POST OK, This CORS filtered");	
		}
		else {
			json.put("status", 200).put("msg", "POST OK, this is not CORS filtered");
		}
		response.getWriter().print(json.toString());
	}

}
