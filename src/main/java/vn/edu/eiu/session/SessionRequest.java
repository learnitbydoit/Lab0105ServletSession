package vn.edu.eiu.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/session-req"})
public class SessionRequest extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter writer = resp.getWriter();
		
		String name = "";
		int credits = 0;
		
		//Tạo session để nhận session gửi từ server
		HttpSession session = req.getSession();
		
		//lấy thong tin từ session
		Object courseName =  session.getAttribute("name");
		Object courseCredits = session.getAttribute("credits");
		
		
		//xử lý nếu session chưa có
		
		if(courseName != null) {
			name = String.valueOf(courseName);
			
			//ép kiểu
			//credits = Integer.valueOf(String.valueOf(courseCredits));
			credits = (Integer) courseCredits; //courseCredits là object
			
		}
		else {
			resp.sendRedirect("/Lab0105ServletSession/session-resp");
		}
		writer.println("Course Name: " + name + "</br>");
		writer.println("Course Credits: "+ credits);
		writer.close();
		System.out.println(session.getServletContext());
		System.out.println(session.getId());
		System.out.println(session.getAttributeNames());
	}
	
}
