package vn.edu.eiu.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/session-welcome"})
public class SessionWelcome extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		String userName = "";
		
		HttpSession session = req.getSession();
		Object objUserName = session.getAttribute("username");
		
		//Test context
		System.out.println(objUserName != null);
		System.out.println(session.getMaxInactiveInterval());
		
		if(objUserName != null) 
			userName = (String) objUserName;
		else
			resp.sendRedirect("/Lab0105ServletSession/session-login");
		writer.println("Xin chào " + userName + "</br>Bạn đã đăng nhập thành công.");
		
		//Tạo nút logout
		writer.println("</br><a href='/Lab0105ServletSession/session-logout'> Logout </a>");
	}
}
