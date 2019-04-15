package com.syc.activiti;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ActivitiDemo02 {

	// 加载zip压缩包
	@Test
	public void test1() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		RepositoryService service = engine.getRepositoryService();

		InputStream stream = getClass().getClassLoader().getResourceAsStream("leave.zip");

		Deployment deploy = service.createDeployment()
				.name("请假申请2")
				.category("请假2")
				.addZipInputStream(new ZipInputStream(stream)).deploy();

		System.out.println("部门的name=" + deploy.getName());
	}

	// 将指定id的资源保存到本地磁盘
	@Test
	public void test2() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();

		RepositoryService service = engine.getRepositoryService();
		// 获取指定部署id下所有资源的名称
		List<String> names = service.getDeploymentResourceNames("7501");
		String imgName = "";
		for (String name : names) {
			if (name.indexOf(".png") > 0) {
				imgName = name;
			}
		}

		// 将指定名称的资源,变成流
		InputStream stream = service.getResourceAsStream("7501", imgName);
		//将流变成file保存
		try {
			FileUtils.copyInputStreamToFile(stream, new File("C:/OA/" + imgName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test3() {
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		
		RepositoryService service = engine.getRepositoryService();

		//单表删除
		service.deleteDeployment("7501");
		
		//级联删除
		//service.deleteDeployment("7501", true);
		
		System.out.println("删除成功!");
	}
}
