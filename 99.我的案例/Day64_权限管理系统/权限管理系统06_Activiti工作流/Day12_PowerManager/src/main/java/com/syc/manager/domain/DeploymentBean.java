package com.syc.manager.domain;

import java.io.Serializable;
import java.util.Date;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * 自定义的流程部署Bean
 * 
 * @类名称:DeploymentBean
 * @创建人:一一哥
 * @创建时间:2018年3月19日 上午9:49:03
 */
public class DeploymentBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private Date deploymentTime;
	private String category;
	private String tenantId=ProcessEngineConfiguration.NO_TENANT_ID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDeploymentTime() {
		return deploymentTime;
	}

	public void setDeploymentTime(Date deploymentTime) {
		this.deploymentTime = deploymentTime;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

}
