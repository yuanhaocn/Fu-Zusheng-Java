package getParamData;
/**
 *Map<String,String[]> getParameterMap()方法
 * 整合几乎所有的 表单字段
 	* 该方法一般不常用，但是在修饰模式（装饰模式），里面自定义请求类会使用
 	* 该方法的泛型一个是元素节点的name属性名，一个是value属性值
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
		// 接收前段所有的表单字段
		Map<String, String[]> parameterMap = req.getParameterMap();
		// 集合遍历
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		Iterator<Entry<String, String[]>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String[]> entry = iterator.next();
			System.out.println(entry.getKey() + "   " + Arrays.toString(entry.getValue()));
		}
	}
}