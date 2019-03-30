package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.User;
import Dao.UserDao;

@WebServlet("/UserCLServlet")
public class UserCLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//接受用户传入的数据
		String id = request.getParameter("id");
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		
		//接收提交的处理类型,查看所有用户
		String type = request.getParameter("type");
		if(type!=null&&type.equals("look")) {
			//查找到所有用户的信息,放在域对象中
			ArrayList<User> list = UserDao.search();
			request.setAttribute("userList", list);
			request.getRequestDispatcher("User.jsp").forward(request, response);
			return ;
		}

		User user = null;
		String paramType = (String) request.getSession().getAttribute("function");
		if(paramType.equals("add")) {
			//添加用户,先判断学号是否已经存在
			boolean flag = UserDao.searchById(id);
			user = new User(id,userName,Integer.parseInt(age),sex,email,date);
			if(flag) {
				request.setAttribute("err", "用户已经存在,不能重复添加!");
				request.getRequestDispatcher("addSearch.jsp?type=add").forward(request, response);
				return ;
			}else {
				//将用户插入数据库
				if(!UserDao.insert(user)) {
					request.setAttribute("err", "用户添加失败");
					request.getRequestDispatcher("addSearch.jsp?type=add").forward(request, response);
					return ;
				}
			}
			
		}else if(paramType.equals("update")) {
			 //先判断用户是否存在
			 boolean flag = UserDao.searchById(id);
			 if(flag) {
				//存在则进行修改
				user = new User(id,userName,Integer.parseInt(age),sex,email,date);
			    UserDao.update(user);
			 }else {
				 //用户原本就不存在，给出提示信息
				 request.setAttribute("err", "用户不存在，请先添加用户！");
				 request.getRequestDispatcher("addSearch.jsp?type=update").forward(request, response);
				 return ;
			 }
			
		}else if(paramType.equals("delete")) {
			//根据用户id删除对应的用户
			user = UserDao.findByIdName(id, userName);
			if(!UserDao.delete(id,userName)) {
				request.setAttribute("err", "用户删除失败，用户id或者姓名有误，请重新输入！");
				request.getRequestDispatcher("findDelete.jsp?type=delete").forward(request, response);
				return ;
			}
		}else if(paramType.equals("search")) {
			//根据用户id查找对应的用户
			user = UserDao.findByIdName(id, userName);
			if(user==null) {
				request.setAttribute("err", "查询用户不存在");
				request.getRequestDispatcher("findDelete.jsp?type=search").forward(request, response);
				return ;
			}
		}
		
		request.setAttribute("message", paramType+"用户成功");
		request.setAttribute("user", user);
		request.getRequestDispatcher("success.jsp").forward(request, response);
		return ;
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
