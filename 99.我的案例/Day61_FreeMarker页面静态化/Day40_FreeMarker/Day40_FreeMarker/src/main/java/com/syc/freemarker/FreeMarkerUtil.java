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

public class FreeMarkerUtil {

	//ftlPath:模板文件的位置;ftlName:模板文件的名称.
	public Template getTemplate(String ftlPath,String ftlName){
		try {
			Configuration cfg=new Configuration(Configuration.getVersion());
			//指定模板文件的位置
			cfg.setClassForTemplateLoading(this.getClass(), ftlPath);
			return cfg.getTemplate(ftlName);
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
	
	//将模板文件的内容输出到控制台
	public void printToConsole(String ftlPath,String ftlName,Map<String,Object> dataModel){
		try {
			Template template = getTemplate(ftlPath, ftlName);
			//将模板生成的文件内容,直接输出到控制台
			template.process(dataModel, new PrintWriter(System.out));
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//将模板文件的内容变成文件输出到某个目录下
	public void printToFile(String ftlPath,String ftlName,Map<String,Object> dataModel,String targetFile){
		try {
			Template template = getTemplate(ftlPath, ftlName);
			//将模板生成的文件内容,直接输出到文件
			FileWriter writer=new FileWriter(new File("src/main/html/"+targetFile));
			template.process(dataModel, writer);
			writer.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
