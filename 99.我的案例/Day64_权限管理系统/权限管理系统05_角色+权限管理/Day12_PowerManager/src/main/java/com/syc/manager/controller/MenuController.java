package com.syc.manager.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.manager.domain.Menu;
import com.syc.manager.service.MenuService;
import com.syc.manager.util.JSONUtil;
import com.syc.manager.vo.BaseJSON;
import com.syc.manager.vo.PageBean;
import com.syc.manager.vo.ResponseStatus;

/**
 * 权限管理模块
 * 
 * @类名称:MenuController
 * @创建人:一一哥
 * @创建时间:2018年3月16日 上午9:57:13
 */
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;

	@ResponseBody
	@RequestMapping(value = "/sys/menu/getAllMenuForTree", produces = { "text/plain;charset=UTF-8" })
	public String getAllMenuForTree() {
		List<Menu> menus = menuService.getAllMenuForTree();
		if (menus != null) {
			return JSONUtil.objectToJson(BaseJSON.setOK(menus));
		}
		return null;
	}

	/**
	 * 跳转到权限管理界面
	 */
	@RequestMapping("/sys/menu/index")
	public String showMenuManager() {

		return "sys/menu/index";
	}

	/**
	 * 分页查询所有的菜单(权限)
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/menu/findAllMenu", produces = { "text/plain;charset=UTF-8" })
	public String findAllMenus(Integer offset, Integer limit) {
		PageBean<Menu> bean = menuService.findAllMenu(offset / limit + 1, limit);
		if (bean != null) {
			return JSONUtil.objectToJson(bean);
		}
		return null;
	}

	/**
	 * 跳转到新增菜单界面
	 */
	@RequestMapping(value = "/sys/menu/form", params = { "add" })
	public String showAddMenu(Model model) {
		model.addAttribute("title", "添加菜单");
		model.addAttribute("flag", "add");
		Menu menu = new Menu();
		menu.setType(0);
		model.addAttribute("menu", menu);

		return "sys/menu/form";
	}

	/**
	 * 实现真正的添加菜单操作
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/menu/addMenu", produces = { "text/plain;charset=UTF-8" })
	public String addMenus(@RequestBody Menu menu) {
		BaseJSON json = null;
		try {
			menuService.addMenu(menu);
			json = BaseJSON.setOK("添加成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			json = BaseJSON.setError(ResponseStatus.ERROR, "网络异常,请检查你的网络!");
		}
		return JSONUtil.objectToJson(json);
	}

	/**
	 * 跳转到编辑菜单界面
	 */
	@RequestMapping(value = "/sys/menu/form", params = { "edit" })
	public String showUpdateMenu(Integer menuId, Model model) {
		model.addAttribute("title", "编辑菜单");
		model.addAttribute("flag", "edit");
		model.addAttribute("menuId", menuId);

		try {
			Menu menu = menuService.findMenuById(menuId);
			model.addAttribute("menu", menu);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "sys/menu/form";
	}

	/**
	 * 注意:需要先实现info.action方法,否则会导致编辑界面中,用户的角色信息无法显示!
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/menu/info", produces = { "text/plain;charset=UTF-8" })
	public String showMenuInfo(Integer menuId) {
		try {
			Menu menu = menuService.findMenuById(menuId);
			if (menu != null) {
				return JSONUtil.objectToJson(BaseJSON.setOK(menu));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 实现菜单修改
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/menu/updateMenu", produces = { "text/plain;charset=UTF-8" })
	public String updateMenu(@RequestBody Menu menu) {
		if (menu != null) {
			menuService.updateMenu(menu);
			return JSONUtil.objectToJson(BaseJSON.setOK("修改成功!"));
		} else {
			return JSONUtil.objectToJson(BaseJSON.setError(ResponseStatus.ERROR, "数据为空!"));
		}
	}

	/**
	 * 删除功能
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/menu/delete", produces = { "text/plain;charset=UTF-8" })
	public String removeMenu(@RequestBody Integer[] ids) {
		BaseJSON json = null;
		try {
			menuService.removeMenu(ids);
			json = BaseJSON.setOK("删除成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			json = BaseJSON.setError(ResponseStatus.ERROR, "请检查网络");
		}
		return JSONUtil.objectToJson(json);
	}
}
