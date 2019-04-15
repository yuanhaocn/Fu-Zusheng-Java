package com.syc.manager.shiro;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.springframework.beans.factory.annotation.Autowired;

import com.syc.manager.service.MenuService;
import com.syc.manager.util.InitDatabaseUtil;
import com.syc.manager.util.MyLog;
import com.syc.manager.vo.Perms;

/*
 * 1.检查并初始化数据库脚本的执行;
 * 2.设置Shiro的授权访问规则.
 */
public class FilterChainDefinationMapBuilder {
	
	@Autowired
	private MenuService menuService;

	public LinkedHashMap<String, String> build(){
		try {
			InputStream stream = Resources.getResourceAsStream("config/db.properties");
			Properties props=new Properties();
			props.load(stream);
			
			if(!InitDatabaseUtil.isInitialized(props)){
				InitDatabaseUtil.importSql(props);
				MyLog.log("数据库正在初始化...");
				Thread.sleep(10000);
				MyLog.log("数据库初始化完毕!");
			}
			
			//添加对某些资源的访问规则.
			///user.html = authc
			///user.html = perms[task:index]
			LinkedHashMap<String, String> map=new LinkedHashMap<>();
			List<Perms> perms = menuService.findAllUrlPerms();
			for(Perms perm : perms){
				map.put(perm.getUrl(), "perms["+perm.getPerms()+"]");
			}
			
			//对于静态资源,不需要拦截,直接放行
			map.put("/images/**", "anon");
			map.put("/css/**", "anon");
			map.put("/html/**", "anon");
			map.put("/libs/**", "anon");
			map.put("/login.html", "anon");
			map.put("/login.action", "anon");
			
			//其他的资源,都需要登陆后才能访问
			map.put("/**", "user");
			
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
