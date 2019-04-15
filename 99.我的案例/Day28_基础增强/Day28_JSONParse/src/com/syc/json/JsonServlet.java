package com.syc.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class JsonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();

		// 1.创建JSON对象格式的数据:{id:"s001",name:"宋江",age:"38"}
		// Student stu=new Student();
		// stu.setId("s001");
		// stu.setName("宋江");
		// stu.setAge("38");

		// JSON的生成
		// JSONObject obj = JSONObject.fromObject(stu);
		// JSON的解析
		// Student stu2 = (Student) JSONObject.toBean(obj,Student.class);
		// System.out.println("name="+stu2.getName());

		// 2.生成JSONArray对象.
		// List<Student> students = new ArrayList<>();
		// Student stu = new Student();
		// stu.setId("s001");
		// stu.setName("宋江");
		// stu.setAge("38");
		// Student stu2 = new Student();
		// stu2.setId("s002");
		// stu2.setName("李逵");
		// stu2.setAge("28");
		// students.add(stu);
		// students.add(stu2);

		// 生成JSON数组
		// JSONArray array = JSONArray.fromObject(students);

		try {
			// 3.查询数据库,生成对应的JSON数据
			QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
			List<Student> students = qr.query("select * from student", 
					new BeanListHandler<>(Student.class));
			JsonConfig config = new JsonConfig();
			// 设置排除项
			config.setExcludes(new String[] { "java", "jsp" });
			JSONArray array = JSONArray.fromObject(students, config);
			writer.print(array);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}