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
		
		//获取用户输入提交的用户数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//获取用户是否保存账号信息的判断
		String var = request.getParameter("statue");
		
		if(var!=null&&var.equals("keep")) {
			//以base64码编码的格式保存中文信息
			String uname = java.net.URLEncoder.encode(request.getParameter("username"),"utf-8");
			Cookie cookie = new Cookie("id", uname+"="+password);
			//设置生命周期
			cookie.setMaxAge(3600*24);
			response.addCookie(cookie);
		}else if(var!=null&&var.equals("nokeep")) {
			//删除cookie
			Cookie[] cookies = request.getCookies();
			if(cookies!=null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals("id")) {
						//删除cookie，设置生命周期为0
						cookie.setMaxAge(0);
						//要将重新设置的cookie加载到response对象中
						response.addCookie(cookie);
					}
				}
			}
		}
		
		//判断用户输入的数据是否则正确
		//正确则跳转用户主界面，否则给出错误的状态信息
		//判断是否与数据库信息匹配
		Manager user = ManagerDao.findByValue(username, password);
		if(user!=null) {
			request.getSession().setAttribute("loginManager", user);
			request.getRequestDispatcher("/Manager.html").forward(request, response);
			return;
		}else {
			request.setAttribute("err", "用户账号或密码错误!");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return ;
		}	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
