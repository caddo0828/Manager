package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Manager;
import Dao.ManagerDao;

@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡ�û������ύ���û�����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//��ȡ�û��Ƿ񱣴��˺���Ϣ���ж�
		String var = request.getParameter("statue");
		
		if(var!=null&&var.equals("keep")) {
			//��base64�����ĸ�ʽ����������Ϣ
			String uname = java.net.URLEncoder.encode(request.getParameter("username"),"utf-8");
			Cookie cookie = new Cookie("id", uname+"="+password);
			//������������
			cookie.setMaxAge(3600*24);
			response.addCookie(cookie);
		}else if(var!=null&&var.equals("nokeep")) {
			//ɾ��cookie
			Cookie[] cookies = request.getCookies();
			if(cookies!=null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("id")) {
						//ɾ��cookie��������������Ϊ0
						cookie.setMaxAge(0);
						//Ҫ���������õ�cookie���ص�response������
						response.addCookie(cookie);
					}
				}
			}
		}
		
		//�ж��û�����������Ƿ�����ȷ
		//��ȷ����ת�û������棬������������״̬��Ϣ
		//�ж��Ƿ������ݿ���Ϣƥ��
		Manager user = ManagerDao.findByValue(username, password);
		if(user!=null) {
			request.getSession().setAttribute("loginManager", user);
			request.getRequestDispatcher("/Manager.html").forward(request, response);
			return;
		}else {
			request.setAttribute("err", "�û��˺Ż��������!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return ;
		}	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
