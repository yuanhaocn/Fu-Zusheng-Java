package getParamData;

/**
 * 	String[]  getParameterValues(String name)     专门获取前端多选框的值
 * 返回值：
		多选框被选中的选项的值的数组
		注意：
		如果不设置多选框的value属性，那么选中是on，不选中是null
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
		// 接收前段的值
		String[] value = req.getParameterValues("fruit");
		System.out.println(Arrays.toString(value));
	}
}