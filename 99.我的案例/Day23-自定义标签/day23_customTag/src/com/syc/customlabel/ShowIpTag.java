package com.syc.customlabel;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShowIpTag extends SimpleTagSupport {

	// 自定义标签必须要实现的方法.
	@Override
	public void doTag() throws JspException, IOException {
		// 创造一个显式jsp页面所在url地址的标签
		PageContext context = (PageContext) getJspContext();
		HttpServletRequest request = (HttpServletRequest) context.getRequest();
		// 得到jsp页面的url地址
		String url = request.getRequestURL().toString();
		
		context.getOut().write("url=" + url + "<br>");
	}

	@Override
	public void setJspContext(JspContext pc) {
		super.setJspContext(pc);
	}

	@Override
	protected JspContext getJspContext() {
		return super.getJspContext();
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		super.setJspBody(jspBody);
	}

	@Override
	protected JspFragment getJspBody() {
		return super.getJspBody();
	}

	@Override
	public void setParent(JspTag parent) {
		super.setParent(parent);
	}

	@Override
	public JspTag getParent() {
		return super.getParent();
	}

}
