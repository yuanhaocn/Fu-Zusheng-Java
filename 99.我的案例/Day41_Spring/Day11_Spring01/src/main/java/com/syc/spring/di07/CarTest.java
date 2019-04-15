package com.syc.spring.di07;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		// context:环境--->Spring容器环境.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans07.xml");

		Car car = context.getBean("car",Car.class);
		int id = car.getId();
		String color = car.getColor();
		float price = car.getPrice();
		System.out.println("id="+id+",color="+color+",price="+price);
		
		String logo = car.getBmw().getLogo();
		System.out.println("logo="+logo);
		
		List<?> carList = car.getCarList();
		for(int i=0;i<carList.size();i++){
			Object obj = carList.get(i);
			System.out.println("obj="+obj.toString());
		}
		
		Set<String> carSet = car.getCarSet();
		Iterator<String> iterator = carSet.iterator();
		while(iterator.hasNext()){
			System.out.println("set="+iterator.next());
		}
		
		Map<String, String> carMap = car.getCarMap();
		for(Entry<String, String> entry: carMap.entrySet()){
			System.out.println("key="+entry.getKey());
			System.out.println("value="+entry.getValue());
		}
		
		Object[] objs = car.getObjs();
		for(int i=0;i<objs.length;i++){
			System.out.println("obj="+objs[i]);
		}
		
		Properties props = car.getProps();
		String logo2 = props.getProperty("logo");
		String price2 = props.getProperty("price");
		System.out.println("logo2="+logo2+",price2="+price2);
		
		context.close();
	}
}
