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
		//设置统一编码格式
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
					  //以base64码的格式解码
					  name = URLDecoder.decode(strings[0],"utf-8");
					  pwd =  strings[1];
					  Manager manager = ManagerDao.findByValue(name, pwd);
					  req.getSession().setAttribute("loginManager", manager);
				}
			}
		}
		
		
		//判断用户访问是是否输入了验证码
		String number = req.getParameter("RandomNumber");
		//随机生成的验证码
		String checkCode =(String) req.getSession().getAttribute("checkCode");
		
		if(number==null||!number.equals(checkCode)) {
			//如果验证码为空或者验证码信息不匹配则返回登录界面，并且给出错误提示
			resp.sendRedirect("/Manager/Login.jsp");
			return;
		}else {
			//放行
			chain.doFilter(request, response);
		}
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
