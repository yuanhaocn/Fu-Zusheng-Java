package a$Create_Servlet_Method;
/**
 * �̳�HttpServletû�б���ʵ�ֵ���
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo03 extends HttpServlet {
		//��дdoGet   ��  doPost
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//���������������ַ�Ļس��൱�ڳ����ӵĵ��   Ĭ����get����
			System.out.println("�������ǵ�get����������");
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			super.doPost(req, resp);
		}
}
