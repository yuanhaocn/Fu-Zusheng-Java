package com.syc.manager.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syc.manager.domain.DeploymentBean;
import com.syc.manager.util.JSONUtil;
import com.syc.manager.vo.BaseJSON;
import com.syc.manager.vo.PageBean;
import com.syc.manager.vo.ResponseStatus;

/**
 * Activity流程管理
 * 
 * @类名称:ActivityController
 * @创建人:一一哥
 * @创建时间:2018年3月19日 上午9:14:48
 */
@Controller
public class ActivitiController {

	@Autowired
	private RepositoryService repositoryService;

	// 跳转到流程管理
	@RequestMapping("/sys/activiti/index")
	public String showActivitiManager() {

		return "sys/activiti/index";
	}

	/**
	 * 实现流程信息查询
	 */
	@ResponseBody
	@RequestMapping("/sys/activiti/list")
	public String showActivitiInfo(Integer offset, Integer limit) {
		PageHelper.startPage(offset / limit + 1, limit);
		// 创建流程部署的查询对象
		DeploymentQuery query = repositoryService.createDeploymentQuery();
		List<Deployment> list = query.list();

		List<DeploymentBean> beans = new ArrayList<>();
		for (Deployment dept : list) {
			DeploymentBean bean = new DeploymentBean();
			bean.setId(dept.getId());
			bean.setCategory(dept.getCategory());
			bean.setName(dept.getName());
			bean.setDeploymentTime(dept.getDeploymentTime());
			beans.add(bean);
		}

		PageInfo<DeploymentBean> info = new PageInfo<>(beans);
		long total = info.getTotal();
		return JSONUtil.objectToJson(new PageBean<>(total, beans));
	}

	/**
	 * 实现流程删除
	 */
	@ResponseBody
	@RequestMapping("/sys/activiti/delete")
	public String deleleDeployment(@RequestBody String[] ids) {
		try {
			for (String id : ids) {
				repositoryService.deleteDeployment(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSONUtil.objectToJson(BaseJSON.setError(ResponseStatus.ERROR, "删除失败!"));
		}

		return JSONUtil.objectToJson(BaseJSON.setOK("删除成功!"));
	}

	/**
	 * 跳转到发布流程界面
	 */
	@RequestMapping("/sys/activiti/deploy")
	public String showDeployment() {

		return "sys/activiti/deploy";
	}

	/**
	 * 实现流程部署
	 */
	@ResponseBody
	@RequestMapping(value = "/sys/activiti/deploy", params = { "commit" },produces={"text/plain;charset=UTF-8"})
	public String commitDeployment(@RequestParam("profile") CommonsMultipartFile profile, String name, String type) {
		try {
			ZipInputStream zipInputStream = new ZipInputStream(profile.getInputStream());
			// 获取流程部署对象
			Deployment deploy = repositoryService.createDeployment().addZipInputStream(zipInputStream).name(name)
					.category(type).deploy();
			if (deploy.getId() != null) {
				return JSONUtil.objectToJson(BaseJSON.setOK("发布成功!"));
			}
			return JSONUtil.objectToJson(BaseJSON.setError(ResponseStatus.ERROR, "发布失败!"));
		} catch (IOException e) {
			e.printStackTrace();
			return JSONUtil.objectToJson(BaseJSON.setError(ResponseStatus.ERROR, "发布失败!"));
		}

	}

}
