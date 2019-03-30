package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginOutServlet")
public class LoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.getSession().invalidate();
	   Cookie[] cookies = request.getCookies();
	   if(cookies!=null) {
		   for(int i=0;i<cookies.length;i++) {
			   if(cookies[i].getName().equals("id")) {
				   cookies[i].setMaxAge(0);
				   response.addCookie(cookies[i]);
			   }   
		   }
	   }
	  response.sendRedirect("/Manager/Login.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
