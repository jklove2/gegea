package com.zyz.empSys.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 图片校验servlet
 * 
 * @author Administrator
 *
 */
@WebServlet("/ImgCheckServlet")
@SuppressWarnings("serial")
public class ImgCheckServlet extends HttpServlet {
	private static int width = 100;// 生成的图片的宽度
	private static int height = 30;// 生成的图片的高度

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = req.getServletContext();
		String encoding = context.getInitParameter("encoding");
		req.setCharacterEncoding(encoding);
		
		String validate = "qwertyuopasdfghjkzxcvbnm123456789";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			sb.append(validate.charAt(getRandom(validate.length())));
		}

		// 1.在内存中创建一张图片
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 2.得到图片
		Graphics g = img.getGraphics();
		// 3.设置图片的背影色
		g.setColor(Color.WHITE);
		// 4. 填充区域
		g.fillRect(0, 0, width, height);
		// 设置边框颜色
		g.setColor(Color.BLUE);
		// 边框区域
		g.drawRect(1, 1, width - 2, height - 2);
		// 5.在图片上画干扰线
		drawRandomLine(g);
		g.setFont(new Font("楷体", Font.BOLD, 20));

		g.drawString(sb.toString(), 30, 20);
		// 设置响应头通知浏览器以图片形式打开
		resp.setContentType("image/jpeg");// 等同于response.setHeader("Content-Type", "image/jpeg");
		// 9.设置响应头控制浏览器不要缓存
		resp.setDateHeader("expries", -1);
		resp.setHeader("Cache-Control", "no-cache");
		resp.setHeader("Pragma", "no-cache");
		// 10.将图片写给浏览器
		ImageIO.write(img, "jpg", resp.getOutputStream());

	}

	/**
	 * 产生随机直线的方法
	 * 
	 * @param g
	 */
	private void drawRandomLine(Graphics g) {

		// 设置线条个数并画线,随机生成4个参数（两个参数确定一个点），然后连接成线
		for (int i = 0; i < 5; i++) {
			// 设置颜色
			g.setColor(new Color(getRandom(256), getRandom(256), getRandom(256)));
			int x1 = new Random().nextInt(width);
			int y1 = new Random().nextInt(height);
			int x2 = new Random().nextInt(width);
			int y2 = new Random().nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	/**
	 * 产生随机数的方法
	 * 
	 * @param r
	 * @return
	 */

	private int getRandom(int r) {
		Random random = new Random();
		return random.nextInt(r);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}
}
