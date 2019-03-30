package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Manager;
import Dao.ManagerDao;


@WebServlet("/ManagerRegisterServlet")
public class ManagerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ManagerRegisterServlet() {
       
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		String sex = request.getParameter("sex");
		String city = request.getParameter("city");
	
		Manager user = new Manager(id,username,password,sex,city);
		
		//根据id判断数据是否存在，如果已经存在，显示注册失败，否则插入到数据中，并且刷新数据库
		Manager u = ManagerDao.findById(id);
		
		if(u==null) {
			ManagerDao.insert(user);
			response.sendRedirect("/Manager/Login.jsp");
		}else {
			request.setAttribute("err", "电话号码已经注册，请用注册的手机号登录");
			request.getRequestDispatcher("/DoRegister.jsp").forward(request, response);
			return ;
		}
		
		
		
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
