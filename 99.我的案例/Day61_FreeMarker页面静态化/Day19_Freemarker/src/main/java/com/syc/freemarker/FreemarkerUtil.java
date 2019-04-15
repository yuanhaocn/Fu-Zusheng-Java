package com.syc.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class FreemarkerUtil {

	public Template loadTemplate(String path, String filename) {
		try {
			// Freemarker配置对象
			Configuration cfg = new Configuration(Configuration.getVersion());
			// 用来去某个路径下,加载模板文件
			cfg.setClassForTemplateLoading(this.getClass(), path);
			return cfg.getTemplate(filename);
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	//输出信息到控制台
	public void showAtConsole(String path, String filename, Map<String, Object> model) {
		try {
			Template template = loadTemplate(path, filename);
			// 将模板里的内容输出到控制台
			template.process(model, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//根据模板,动态生成一个文件.
	public void generateFile(String path, String filename, String targetName, Map<String, Object> model) {
		try {
			Template template = loadTemplate(path, filename);
			FileWriter writer = new FileWriter(new File("src/main/html/" + targetName));
			template.process(model, writer);
			writer.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
