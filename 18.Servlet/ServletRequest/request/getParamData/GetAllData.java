package getParamData;
/**
 *Map<String,String[]> getParameterMap()����
 * ���ϼ������е� ���ֶ�
 	* �÷���һ�㲻���ã�����������ģʽ��װ��ģʽ���������Զ����������ʹ��
 	* �÷����ķ���һ����Ԫ�ؽڵ��name��������һ����value����ֵ
 */
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rdemo06")
public class GetAllData extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����ǰ�����еı��ֶ�
		Map<String, String[]> parameterMap = req.getParameterMap();
		// ���ϱ���
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		Iterator<Entry<String, String[]>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String[]> entry = iterator.next();
			System.out.println(entry.getKey() + "   " + Arrays.toString(entry.getValue()));
		}
	}
}