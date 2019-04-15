package response.encoding;
/**
 *解决乱码的方式三
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rde2")
public class EncodeSolution03 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 PrintWriter writer = resp.getWriter();
	String s="你好";
	byte[] bytes = s.getBytes("ISO-8859-1");
	String ss = new String(bytes,"utf-8");
	writer.print(ss);
	}
}
