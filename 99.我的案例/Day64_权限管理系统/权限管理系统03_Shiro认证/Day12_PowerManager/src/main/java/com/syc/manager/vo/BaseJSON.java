package com.syc.manager.vo;

import java.io.Serializable;

/**
 * 将JavaBean转换为JSON数据
 * {status:"SUCCESS",data:{'登陆成功!'}}
 * @类名称:BaseJSON
 * @创建人:一一哥
 * @创建时间:2018年3月13日 上午11:27:20
 */
public class BaseJSON implements Serializable {

	private static final long serialVersionUID = 1L;

	private ResponseStatus status;// 后端向前端返回的响应信息

	private Object data;// 后端向前端返回的响应数据

	public BaseJSON() {
	}

	public BaseJSON(ResponseStatus status, Object data) {
		this.status = status;
		this.data = data;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static BaseJSON setOK(Object data){
		BaseJSON json=new BaseJSON();
		json.setStatus(ResponseStatus.SUCCESS);
		json.setData(data);
		return json;
	}
	
	public static BaseJSON setError(ResponseStatus status,Object data){
		return new BaseJSON(status,data);
	}
	
	@Override
	public String toString() {
		return "[data]="+data+",[status]="+status;
	}

}
