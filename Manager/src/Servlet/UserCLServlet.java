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
		//�����û����������
		String id = request.getParameter("id");
		String userName = request.getParameter("userName");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		
		//�����ύ�Ĵ�������,�鿴�����û�
		String type = request.getParameter("type");
		if(type!=null&&type.equals("look")) {
			//���ҵ������û�����Ϣ,�����������
			ArrayList<User> list = UserDao.search();
			request.setAttribute("userList", list);
			request.getRequestDispatcher("User.jsp").forward(request, response);
			return ;
		}

		User user = null;
		String paramType = (String) request.getSession().getAttribute("function");
		if(paramType.equals("add")) {
			//����û�,���ж�ѧ���Ƿ��Ѿ�����
			boolean flag = UserDao.searchById(id);
			user = new User(id,userName,Integer.parseInt(age),sex,email,date);
			if(flag) {
				request.setAttribute("err", "�û��Ѿ�����,�����ظ����!");
				request.getRequestDispatcher("addSearch.jsp?type=add").forward(request, response);
				return ;
			}else {
				//���û��������ݿ�
				if(!UserDao.insert(user)) {
					request.setAttribute("err", "�û����ʧ��");
					request.getRequestDispatcher("addSearch.jsp?type=add").forward(request, response);
					return ;
				}
			}
			
		}else if(paramType.equals("update")) {
			 //���ж��û��Ƿ����
			 boolean flag = UserDao.searchById(id);
			 if(flag) {
				//����������޸�
				user = new User(id,userName,Integer.parseInt(age),sex,email,date);
			    UserDao.update(user);
			 }else {
				 //�û�ԭ���Ͳ����ڣ�������ʾ��Ϣ
				 request.setAttribute("err", "�û������ڣ���������û���");
				 request.getRequestDispatcher("addSearch.jsp?type=update").forward(request, response);
				 return ;
			 }
			
		}else if(paramType.equals("delete")) {
			//�����û�idɾ����Ӧ���û�
			user = UserDao.findByIdName(id, userName);
			if(!UserDao.delete(id,userName)) {
				request.setAttribute("err", "�û�ɾ��ʧ�ܣ��û�id���������������������룡");
				request.getRequestDispatcher("findDelete.jsp?type=delete").forward(request, response);
				return ;
			}
		}else if(paramType.equals("search")) {
			//�����û�id���Ҷ�Ӧ���û�
			user = UserDao.findByIdName(id, userName);
			if(user==null) {
				request.setAttribute("err", "��ѯ�û�������");
				request.getRequestDispatcher("findDelete.jsp?type=search").forward(request, response);
				return ;
			}
		}
		
		request.setAttribute("message", paramType+"�û��ɹ�");
		request.setAttribute("user", user);
		request.getRequestDispatcher("success.jsp").forward(request, response);
		return ;
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
