package com.syc.customlabel;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrintBodyTag extends SimpleTagSupport {

	private int lines;
	private boolean upCase;

	// 注意:自定义标签中,如果该标签带有属性,必须给该属性提供一个对应的公开的setXXX()方法.
	public void setLines(int lines) {
		this.lines = lines;
	}

	public void setUpCase(boolean upCase) {
		this.upCase = upCase;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// JspFragment body = getJspBody();
		// JspWriter out = getJspContext().getOut();

		// invoke()方法控制标签体里的内容是否输出.
		// 调用了invoke()方法就会输出标签体力的内容;否则就不输出
		// for (int i = 0; i < lines; i++) {
		// body.invoke(out);
		// body.invoke(null);
		// }

		// 得到标签体里的内容
		JspFragment body = getJspBody();
		// StringWriter是一个临时的输出容器,标签体里的内容被放到这个容器中
		StringWriter writer = new StringWriter();
		// 将标签体里的内容写到了这个临时输出容器中
		for (int i = 0; i < lines; i++) {
			body.invoke(writer);
		}
		// 把临时容器里的内容变成字符串,进行转换
		String content = writer.toString();
		if (upCase) {
			content = content.toUpperCase();
		}
		// 把标签体里的内容输出出来
		getJspContext().getOut().write(content);
		
		//如果抛出该异常,就会阻止标签体外面的内容输出
		throw new SkipPageException();
	}

}
