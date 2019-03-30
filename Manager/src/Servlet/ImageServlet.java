package Servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helper.RandomHelp;
import java.awt.Font;


@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ImageServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//设置文本格式，以及编码
		response.setContentType("text/html;charset=utf-8");
		
		//创建图片对象
		BufferedImage image = new BufferedImage(60, 30, BufferedImage.TYPE_INT_RGB);
		//通过BufferedImage对象得到为此图片绘制图形的绘制对象
		Graphics g = image.getGraphics();
		
		//设置图片的背景颜色，并且填充矩形
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 60, 30);
		
		String num = RandomHelp.number();
		//设置数字的字体以及样式
		g.setFont(new Font(null,java.awt.Font.ITALIC,20));
		
		//生成随机数的随机颜色
		g.setColor(Color.GRAY);
		
		//将每次随机产生的数保存在session中
		request.getSession().setAttribute("checkCode", num);
		//将随机数字写入绘制图形中
		g.drawString(num, 10, 30);
		
	
			
		Random random = new Random();
		//绘制随机的干扰线，绘制5根（自己随意）
		for(int j=0; j<10;j++) {
			//设置干扰线的随机颜色
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			
			//画随机线 从（x1,y1）开始 ， 到（x2,y2）结束
			g.drawLine(random.nextInt(60), random.nextInt(30), 10+random.nextInt(60), 5+random.nextInt(30));
			
		}
		
		
		//将图片从内存中写入到浏览器中
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
