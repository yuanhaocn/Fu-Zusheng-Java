package getParamData;

/**
 * 	String[]  getParameterValues(String name)     ר�Ż�ȡǰ�˶�ѡ���ֵ
 * ����ֵ��
		��ѡ��ѡ�е�ѡ���ֵ������
		ע�⣺
		��������ö�ѡ���value���ԣ���ôѡ����on����ѡ����null
 */
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo05")
public class GetCheckboxData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����ǰ�ε�ֵ
		String[] value = req.getParameterValues("fruit");
		System.out.println(Arrays.toString(value));
	}
}