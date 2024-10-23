package vn.edu.eiu.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/session-login"})
public class SessionLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<form action='session-login' method='post'>");
		writer.println("Username: <input type='text' name='username'/>");
		writer.println("Password: <input type='password' name='password'/>");
		writer.println("<input type='submit' value='login'/>");
		writer.println("</form>");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("username");
		String passWD = req.getParameter("password");
		
		//test
		System.out.println(userName + " " + passWD);
		
		if(userName.equalsIgnoreCase("Thao") && passWD.equals("123456")) {
			//Tạo session để lưu trữ lại username đã đăng nhập thành công
			HttpSession session = req.getSession();
			session.setAttribute("username", userName);
			session.setMaxInactiveInterval(10);
			
			//test
			System.out.println(userName + " " + passWD);
			System.out.println(session.getMaxInactiveInterval());
			
			resp.sendRedirect("/Lab0105ServletSession/session-welcome");
		}
		else {
			resp.sendRedirect("/Lab0105ServletSession/session-login");
		}
	}

}
