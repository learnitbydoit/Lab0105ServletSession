package vn.edu.eiu.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/session-resp"})
public class SessionResponse extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Khai báo session
		HttpSession session = req.getSession();
		
		//Session là đối tượng lưu trên server gồm {Key,Value}
		session.setAttribute("name", "CSE 457 - Advanced Java Programming");
		//int credits = 5;
		session.setAttribute("credits", 4);
		
		
		//Trả về cho client
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("Xin chào, Session đã được tạo");
	}

}
