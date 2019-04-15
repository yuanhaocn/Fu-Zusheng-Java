package com.syc.manager.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

/**
 * 检查数据库是否已经在服务器中创建,如果没有则创建出来.
 * @类名称:InitDatabaseUtil
 * @创建人:一一哥
 * @创建时间:2018年3月14日 上午9:31:58
 */
public class InitDatabaseUtil {

	/**
	 * 判断数据库是否已经初始化创建出来了
	 */
	public static boolean isInitialized(Properties props){
		if(props.getProperty("status").startsWith("0")){
			MyLog.log("数据库未初始化!");
			return false;
		}
		MyLog.log("数据库已初始化!");
		return true;
	}
	
	/**
	 * 导入sql脚本文件,并且执行该脚本,创建出数据库.
	 */
	public static void importSql(Properties props){
		try {
			//相当于是在cmd中执行某个命令.
			Runtime runtime = Runtime.getRuntime();
			//mysql -uroot -psyc -hhost -P3306 -Dmysql
			String[] commands = getImportCommand(props);
			
			//执行第一个命令.
			Process process = runtime.exec(commands[0]);
			
			OutputStream os = process.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(os);
			writer.write(commands[1]+"\r\n"+commands[2]);
			writer.flush();
			writer.close();
			os.close();
			
			//修改Properties配置文件的内容
			props.setProperty("status", "1");
			FileOutputStream fos = new FileOutputStream(Resources.getResourceURL("config/db.properties").getFile());
			//保存修改的信息
			props.store(fos, "database initialized!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//从Properties中获取某些信息,拼接出要执行的命令行.
	private static String[] getImportCommand(Properties props) {
		//mysql -uroot -psyc -hhost -P3306 -Dmysql
		String username = props.getProperty("jdbc.user");
		String password = props.getProperty("jdbc.password");
		String host = props.getProperty("jdbc.host");
		String port = props.getProperty("jdbc.port");
		String importDatabaseName = props.getProperty("jdbc.importDatabaseName");
		
		try {
			 String filePath = Resources.getResourceURL("import/powermanager.sql").getFile();
			 MyLog.log("path="+filePath);
			 if(filePath.contains(":")){
				 filePath=filePath.substring(1, filePath.length());
			 }
			 
			 MyLog.log("path2="+filePath);
			 
			 //第一步:拼接出mysql服务器登陆时的命令
			 String loginCommand = new StringBuffer()
			 .append("mysql -u")
			 .append(username)
			 .append(" -p")
			 .append(password)
			 .append(" -h")
			 .append(host)
			 .append(" -P")
			 .append(port)
			 .toString();
			 
			 //第二步:拼接要使用的数据库
			 String dbCommand = new StringBuffer()
					.append("use ")
					.append(importDatabaseName)
					.toString();
			 
			 //第三步:拼接要导入的sql脚本
			 String sqlCommand = new StringBuffer()
			 .append("source ")
			 .append(filePath)
			 .toString();
			 
			return new String[]{loginCommand,dbCommand,sqlCommand};
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
