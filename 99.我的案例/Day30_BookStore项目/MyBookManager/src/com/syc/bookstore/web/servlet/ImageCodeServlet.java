package com.syc.bookstore.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成验证码的Servlet
 * 
 * @类名称:ImageCodeServlet
 * @创建人:SYC
 * @创建时间:2017年7月6日 下午5:24:30
 */
public class ImageCodeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	// 存放从/WEB-INF/目录下words.txt读取出来的成语字符串.
	private List<String> words = new ArrayList<>();

	@Override
	public void init() throws ServletException {
		try {
			/// WEB-INF/下的资源必须用真实路径来获取.
			String realPath = getServletContext().getRealPath("/WEB-INF/words.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(realPath), "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				// 将读取到的每一行追加到集合中
				words.add(line);
			}
			reader.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 进行成语的绘制
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
		
		// 进制缓存:可能会因为缓存导致验证码不变.
		// 控制是否缓存资源： 利用response设置expires、Cache-Control、Pragma实现浏览器是否缓存资源，
		// 这三个头都可以实现，但是由于历史原因，不同浏览器实现不同，所以一般配合这三个头使用 .
		// 控制浏览器不要缓存(验证码图片不缓存):
		// 设置expires为0或-1设置Cache-Control为no-cache、Pragma为no-cache.
		// response.setHeader("Cache-Control", "no-cache");
		// response.setHeader("Pragma", "no-cache");
		// response.setDateHeader("Expires", -1);

		// 绘制验证码:
		// 1.矩形背景;
		// 2.矩形边框;
		// 3.文字内容;
		// 4.干扰线.
		// 每一部分都应该设置其对应的颜色

		// 设置验证码的绘制范围.
		int width = 120;
		int height = 30;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 得到要绘制的图像对象
		Graphics graphics = image.getGraphics();

		// 1.绘制矩形背景部分:颜色+填充
		graphics.setColor(getRandomColor(200, 250));
		graphics.fillRect(0, 0, width, height);

		// 2.绘制矩形边框:颜色+绘制
		graphics.setColor(Color.WHITE);
		// 绘制矩形边框
		graphics.drawRect(0, 0, width - 1, height - 1);

		// 3.绘制文字内容:颜色+字体样式
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setFont(new Font("宋体", Font.BOLD, 18));

		// 获取要绘制的文字内容
		Random rdm = new Random();
		// 限定随机数范围
		int index = rdm.nextInt(words.size());
		String word = words.get(index);

		// 将文字内容存储到session中,用于后期验证对比
		request.getSession().setAttribute("imageCodeSession", word);

		// 设置要绘制的文字在x轴上的坐标
		int x = 10;
		for (int i = 0; i < word.length(); i++) {
			// 在这里设置文字颜色,是为了使得每个文字的颜色都不同.
			graphics2D.setColor(new Color((20 + new Random().nextInt(110)), (20 + new Random().nextInt(110)),
					(20 + new Random().nextInt(110))));

			// 角度范围:-30~~30
			int degress = new Random().nextInt(60) - 30;
			// 弧度=角度*PI/180
			double theta = degress * Math.PI / 180;
			// 设置文字的旋转角度---弧度
			graphics2D.rotate(theta, x, 20);

			// 取得成语中的每一个字
			char c = word.charAt(i);
			// 绘制要输出的文字内容,一个字一个字的输出,否则会造成重叠现象.
			graphics2D.drawString(String.valueOf(c), x, 20);

			// 解决文字只超一个方向倾斜的问题
			graphics2D.rotate(-theta, x, 20);

			// 更改文字坐标
			x += 30;
		}

		// 4.绘制干扰线:颜色+线
		graphics.setColor(getRandomColor(160, 200));
		for (int i = 0; i < 30; i++) {
			int x1 = new Random().nextInt(width);
			int y1 = new Random().nextInt(height);
			int x2 = new Random().nextInt(12);
			int y2 = new Random().nextInt(12);
			graphics.drawLine(x1, y1, x1 + x2, y1 + y2);
		}

		// 是否图像所占用的资源
		graphics.dispose();

		// 利用ImageIO进行内容的输出,输出要绘制的BufferedImage.
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	// 获取随机颜色值
	private Color getRandomColor(int fc, int bc) {
		Random rdm = new Random();
		if (fc > 255) {
			fc = 255;
		}

		if (bc > 255) {
			bc = 255;
		}

		int r = fc + rdm.nextInt(bc - fc);
		int g = fc + rdm.nextInt(bc - fc);
		int b = fc + rdm.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
