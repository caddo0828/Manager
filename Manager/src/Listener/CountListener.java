package Listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.tomcat.jni.OS;

public class CountListener implements HttpSessionListener ,ServletContextListener{
	//设置初始的在线人数为0
	private static int count ;
	private static Properties prop = new Properties();
	
	@Override
	public void sessionCreated(HttpSessionEvent s) {
		count = (int)s.getSession().getServletContext().getAttribute("onLineNum");
		count++;
		s.getSession().getServletContext().setAttribute("onLineNum", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent s) {
	    count = (int)s.getSession().getServletContext().getAttribute("onLineNum");
	    count--;
	    s.getSession().getServletContext().setAttribute("onLineNum", count);
	}

	@Override
	public void contextDestroyed(ServletContextEvent s) {
		prop.setProperty("onLineNum", s.getServletContext().getAttribute("onLineNum").toString());
		String path = CountListener.class.getResource("/").getPath()+"count.properties";
		//将在线人数存储在配置文件中
		OutputStream os = null;
		try {
			os = new FileOutputStream(path);
			prop.store(os, null);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent s) {
		//从配置文件中读取初始的在线人数
		String path = CountListener.class.getResource("/").getPath()+"count.properties";
		InputStream in = null;
		try {
			in = new FileInputStream(path);
			prop.load(in);
		    count = Integer.parseInt(prop.getProperty("onLineNum"));
		    //将在线人数存储在ServletContext域对象中
		    s.getServletContext().setAttribute("onLineNum", count);
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	

}
