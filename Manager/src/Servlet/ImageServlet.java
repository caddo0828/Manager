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
		//�����ı���ʽ���Լ�����
		response.setContentType("text/html;charset=utf-8");
		
		//����ͼƬ����
		BufferedImage image = new BufferedImage(60, 30, BufferedImage.TYPE_INT_RGB);
		//ͨ��BufferedImage����õ�Ϊ��ͼƬ����ͼ�εĻ��ƶ���
		Graphics g = image.getGraphics();
		
		//����ͼƬ�ı�����ɫ������������
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, 60, 30);
		
		String num = RandomHelp.number();
		//�������ֵ������Լ���ʽ
		g.setFont(new Font(null,java.awt.Font.ITALIC,20));
		
		//����������������ɫ
		g.setColor(Color.GRAY);
		
		//��ÿ�������������������session��
		request.getSession().setAttribute("checkCode", num);
		//���������д�����ͼ����
		g.drawString(num, 10, 30);
		
	
			
		Random random = new Random();
		//��������ĸ����ߣ�����5�����Լ����⣩
		for(int j=0; j<10;j++) {
			//���ø����ߵ������ɫ
			g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
			
			//������� �ӣ�x1,y1����ʼ �� ����x2,y2������
			g.drawLine(random.nextInt(60), random.nextInt(30), 10+random.nextInt(60), 5+random.nextInt(30));
			
		}
		
		
		//��ͼƬ���ڴ���д�뵽�������
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
