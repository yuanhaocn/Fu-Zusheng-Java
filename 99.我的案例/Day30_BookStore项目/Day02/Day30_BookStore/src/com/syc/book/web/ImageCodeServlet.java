package com.syc.book.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 负责生成验证码
 * 
 * @类名称:ImageCodeServlet
 * @创建人:SYC
 * @创建时间:2017年8月4日 上午10:47:26
 */
public class ImageCodeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// 用来存放成语的集合
	private List<String> words = new ArrayList<>();

	@Override
	public void init() throws ServletException {
		try {
			// 获取文件的路径
			String path = getServletContext().getRealPath("/WEB-INF/words.txt");
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File(path)), "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				words.add(line);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int width = 120;
		int height = 30;
		// 创建要输出的image
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 创建Graphics图像,image中要显示的内容.
		Graphics graphics = image.getGraphics();

		// 1.填充背景:颜色+填充
		graphics.setColor(getRandomColor(200, 250));
		graphics.fillRect(0, 0, width, height);

		// 2.绘制边框:颜色+填充
		graphics.setColor(Color.WHITE);
		//绘制矩形范围:
		graphics.drawRect(0, 0, width - 1, height - 1);

		// 3.绘制文字内容:颜色+样式
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setFont(new Font("宋体", Font.BOLD, 18));

		// 获取集合中某一个成语
		Random rd = new Random();
		int index = rd.nextInt(words.size());
		String word = words.get(index);
		
		//将成语存储到Session
		request.getSession().setAttribute("imageCodeSession", word);

		// x的初始坐标值
		int x = 10;
		for (int i = 0; i < word.length(); i++) {

			// 设置文字的随机颜色
			graphics2D.setColor(new Color(20 + new Random().nextInt(110), 20 + new Random().nextInt(110),
					20 + new Random().nextInt(110)));

			//随机设置的角度:-30~30
			int degress=new Random().nextInt(60)-30;
			//由角度得到对应的弧度
			double theta=degress*Math.PI/180;
			graphics2D.rotate(theta, x, 20);
			
			// 得到了单个的汉字
			char c = word.charAt(i);
			// 绘制文字
			graphics2D.drawString(String.valueOf(c), x, 20);
			
			//解决文字朝一个方向倾斜的问题
			graphics2D.rotate(-theta, x, 20);

			// x坐标改变
			x += 30;
		}
		
		// 4.绘制干扰线:颜色
		graphics.setColor(getRandomColor(160, 200));
		for(int i=0;i<50;i++){
			int x1=new Random().nextInt(width);
			int y1=new Random().nextInt(height);
			int x2=new Random().nextInt(12);
			int y2=new Random().nextInt(12);
			//随机的干扰线
			graphics.drawLine(x1, y1, x1+x2, y1+y2);
		}

		//是否graphics占的资源
		graphics.dispose();
		
		// 绘制要输出的内容:image,jpg格式.
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 获取随机颜色
	private Color getRandomColor(int fc, int bc) {
		Random rd = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}

		int r = fc + rd.nextInt(bc - fc);
		int g = fc + rd.nextInt(bc - fc);
		int b = fc + rd.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}