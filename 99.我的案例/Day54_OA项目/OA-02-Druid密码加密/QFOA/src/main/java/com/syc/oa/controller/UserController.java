package com.syc.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.oa.domain.TbUser;
import com.syc.oa.service.UserService;
import com.syc.oa.vo.PageBean;

/**
 * 用户模块控制器
 * 
 * @类名称:UserController
 * @创建人:SYC
 * @创建时间:2017年11月1日 上午9:15:43
 */
@Controller
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	/**
	 * 跳转到登陆页面
	 */
	@RequestMapping("/loginForm")
	public String loginForm() {

		// 第一套登陆页面:
		// 跳转到login.jsp页面中
		// 对应着/WEB-INF/jsp/login.jsp页面
		return "login";

		// 第二套登陆页面:
		/// WEB-INF/jsp/loginForm.jsp页面
		// return "loginForm";
	}

	/**
	 * 跳转到显示查询用户界面
	 */
	@RequestMapping("/user/selectUser")
	public String selectUser() {

		// 对应/WEB-INF/jsp/user/user.jsp页面
		return "user/user";
	}

	/**
	 * 处理登陆请求
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String loginName, String password, String ishave, HttpServletRequest request,
			HttpServletResponse response) {

		// remeber必须与表单中checkbox的name一致!
		String options = "remeber";

		if (options.equals(ishave)) {
			// 记住账号
			// 如果勾选了机主账户,则需要把用户名和勾选状态保存到Cookie!
			Cookie stateCookie = new Cookie("remeber", "checked='checked'");
			Cookie nameCookie = new Cookie("loginName", loginName);
			// 设置Cookie的过期时间
			stateCookie.setMaxAge(Integer.MAX_VALUE);
			nameCookie.setMaxAge(Integer.MAX_VALUE);
			// 保存Cookie
			response.addCookie(stateCookie);
			response.addCookie(nameCookie);
		} else {
			// 没有勾选,则清除Cookie信息.
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie ck : cookies) {
					ck.setMaxAge(0);
					response.addCookie(ck);
				}
			}
		}

		// 执行登陆操作----查询user表
		TbUser user = userService.findUserNameByNameAndPassword(loginName, password);
		if (user != null) {
			// 将登陆的用户保存到session中
			request.getSession().setAttribute("user_session", user);
			request.getSession().setMaxInactiveInterval(24 * 60 * 60);

			// 跳转到主页面
			/// WEB-INF/jsp/index.jsp
			return "index";
		}

		/// WEB-INF/jsp/error.jsp
		return "error";
	}
	
	/**
	 * 添加用户的请求
	 */
	@RequestMapping("/user/addUser")
	public String addUser(Integer flag, TbUser user, HttpServletResponse response) throws IOException {
		
		//解决添加修改界面的中文乱码问题
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		// 我们自己重新输出了内容,所以有必要设置输出内容的编码
		PrintWriter writer = response.getWriter();

		if (flag == 1) {
			// 跳转到添加用户页面
			// WEB-INF/jsp/user/showAddUser.jsp
			return "user/showAddUser";
		} else {
			// 直接调用service里的添加方法.
			// 从showAddUser.jsp页面中的按钮点击事件中跳转过来.
			if (userService.addUser(user)) {
				// 注意:此处一定不能用println()方法,否则会导致多一个换行!
				writer.print("success");
				// writer.println("success");
			} else {
				writer.print("error");
			}
		}

		return null;
	}

	/**
	 *  处理查询用户的请求
	 *  注意:分页用的pageNumber和pageSize参数没有使用到.
	 *  此处的分页利用的layui来实现的.
	 *  注意:status状态默认值为0,所以默认会查询出status=0的记录.
	 */
	@RequestMapping("/ujson")
	@ResponseBody
	public PageBean<TbUser> userJson(@RequestParam(defaultValue = "1") Integer pageNumber,
			@RequestParam(defaultValue = "5") Integer pageSize, @RequestParam(defaultValue = "") String username,
			@RequestParam(defaultValue = "0") String status) {

		return userService.selectAll(pageNumber, pageSize, username, status);
	}
	
	/**
	 * 修改用户的方法;
	 * flag:标记具体的修改请求动作;
	 * id:修改请求的条件;
	 * user:包含了要修改的数据内容;
	 * model:保存对象到域中;
	 * response:输入响应信息.
	 */
	@RequestMapping("/user/updateUser")
	public String updateUser(Integer flag, Integer id, TbUser user, Model model, HttpServletResponse response)
			throws IOException {
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html;charset=UTF-8");

		PrintWriter writer = response.getWriter();
		if (flag == 1) {//点击user.jsp页面的"编辑"菜单跳转过来.
			//将要修改的user对象保存到域中,供修改页面进行数据回显!
			model.addAttribute("user", userService.findUserById(id));
			
			///WEB-INF/jsp/user/showUpdateUser.jsp页面
			return "user/showUpdateUser";
		} else {
			// 直接调用service里的修改方法,进行真正的修改操作.
			// 从showAddUser.jsp页面中的按钮点击事件中跳转过来.
			if (userService.updateUser(user)) {
				//输出响应结果:success或error
				writer.print("success");
			} else {
				writer.print("error");
			}
		}

		return null;
	}

	/**
	 * 用户删除操作
	 * flag:进行单个删除和批量删除的标记;
	 * id:单个删除时的参数; 
	 * ids:批量删除时的参数;
	 * response:用来输出响应信息.
	 */
	@RequestMapping("/user/removeUser")
	public String removeUser(Integer flag, Integer id, @RequestParam(value = "ids[]", required = false) Integer[] ids,
			HttpServletResponse response) throws IOException {

		PrintWriter writer = response.getWriter();
		boolean result = false;

		if (flag == 1) {
			// 删除单个对象
			result = userService.removeOne(id);
		} else {
			// 批量删除
			result = userService.remove(ids);
		}

		// 设置输出到前端页面的数据内容:success和error!
		if (result) {
			writer.print("success");
		} else {
			writer.print("error");
		}

		return null;

		// 删除之后也可以直接跳转到/WEB-INF/jsp/user/user.jsp页面
		/// WEB-INF/jsp/user/user.jsp
		// return "user/user";
	}

	/**
	 * 退出登陆的方法
	 * 
	 */
	@RequestMapping("/loginOut")
	public String loginOut() {
		// 重新跳转到登陆页面
		/// WEB-INF/jsp/login.jsp
		return "login";
	}
}
