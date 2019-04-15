package com.syc.mvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	//@RequestBody:
	//Annotation indicating a method parameter 
	//should be bound to the body of the web request.
	//该注解,将方法的参数与web的request请求体绑定在一起.也就是说该注解,
	//可以将JSON对象里的数据自动封装进Java对象里.
	//如何将JSON对象转换为Java对象?
	//MappingJackson2HttpMessageConverter类会得到request对象;
	//然后利用request对象,取出里面的json对象;
	//解析json对象,根据key取出对应的值;
	//然后将取出的json数据封装进方法的带了@RequestBody注解的参数上.
	// 定义请求方法
	@RequestMapping("/requestJSON")
	public void requestJSON(@RequestBody User user) {
		System.out.println("name="+user.getUsername()+",birthday="+user.getBirthday());
	}
	
	//服务器向前端做出响应
	//Annotation that indicates a method return value 
	//should be bound to the web response body. 
	//@ResponseBody:该注解指示出该方法的返回值与响应体绑定在一起.
	//该注解,可以将Java对象自动转换为对应的JSON对象!
	@RequestMapping("/responseJSON")
	public @ResponseBody User responseJSON(){
		User user=new User();
		user.setId("u002");
		user.setUsername("川普");
		user.setAge(70);
		user.setAddress("美国");
		user.setBirthday(new Date());
		
		return user;//---->{"id":"u002","username":"川普"...}
	}
	
	@RequestMapping("/responseJSONS")
	public @ResponseBody List<User> responseJSONS(){
		
		List<User> users=new ArrayList<User>();
		
		User user=new User();
		user.setId("u002");
		user.setUsername("川普");
		user.setAge(70);
		user.setAddress("美国");
		user.setBirthday(new Date());
		
		User user2=new User();
		user2.setId("u004");
		user2.setUsername("安倍吃屎");
		user2.setAge(38);
		user2.setAddress("日本省");
		user2.setBirthday(new Date());
		
		users.add(user);
		users.add(user2);
		
		return users;//---->[{"id":"001"},{"id":"002"}]
	}
	
	@RequestMapping("/responseMovieJSONS")
	public @ResponseBody Movies responseMoviesJSON(){
		
		Movies movies=new Movies();
		movies.setRetcode("200");
		movies.setRetdesc("操作成功");
		
		List<Movie> list=new ArrayList<Movie>();
		
		Movie movie=new Movie();
		movie.setId("49100");
		movie.setName("寻梦环游记");
		movie.setHighlight("在爱的记忆消失前，请记住我");
		
		Movie movie2=new Movie();
		movie2.setId("49101");
		movie2.setName("正义联盟");
		movie2.setHighlight("孤胆难救世，正义不独行");
		
		list.add(movie);
		list.add(movie2);
		movies.setList(list);
		
		return movies;
	}
}
