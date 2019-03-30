package Filter;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Manager;
import Dao.ManagerDao;

public class LoginFilter  implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//����ͳһ�����ʽ
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpServletRequest req = (HttpServletRequest) request;
		
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		String name = "";
		String pwd = "";
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			for(int i=0;i<cookies.length;i++) {
				if(cookies[i].getName().equals("id")){
					 String[] strings = cookies[i].getValue().split("=");
					  //��base64��ĸ�ʽ����
					  name = URLDecoder.decode(strings[0],"utf-8");
					  pwd =  strings[1];
					  Manager manager = ManagerDao.findByValue(name, pwd);
					  req.getSession().setAttribute("loginManager", manager);
				}
			}
		}
		
		
		//�ж��û��������Ƿ���������֤��
		String number = req.getParameter("RandomNumber");
		//������ɵ���֤��
		String checkCode =(String) req.getSession().getAttribute("checkCode");
		
		if(number==null||!number.equals(checkCode)) {
			//�����֤��Ϊ�ջ�����֤����Ϣ��ƥ���򷵻ص�¼���棬���Ҹ���������ʾ
			resp.sendRedirect("/Manager/Login.jsp");
			return;
		}else {
			//����
			chain.doFilter(request, response);
		}
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
