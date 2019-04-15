package com.syc.customlabel;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport {

	private Object items;
	private String var;

	public void setItems(Object items) {
		this.items = items;
	}

	public void setVar(String var) {
		this.var = var;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void doTag() throws JspException, IOException {

		PageContext context = (PageContext) getJspContext();

		/*
		 * if (items instanceof List) { List list = (List) items; for (Object
		 * obj : list) { context.setAttribute(var, obj);
		 * getJspBody().invoke(null); } }
		 * 
		 * if (items instanceof Map) { Map map = (Map) items; Set<Entry>
		 * entrySet = map.entrySet(); for (Entry entry : entrySet) {
		 * context.setAttribute(var, entry); getJspBody().invoke(null); } }
		 */

		Collection clct = null;
		if (items instanceof List) {
			List list = (List) items;
			clct = list;
		}

		if (items instanceof Map) {
			Map map = (Map) items;
			clct = map.entrySet();
		}

		for (Object obj : clct) {
			context.setAttribute(var, obj);
			getJspBody().invoke(null);
		}

	}
}
