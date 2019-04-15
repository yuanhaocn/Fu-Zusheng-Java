package com.syc.car;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟数据库操作
 * 
 * @类名称:ProductDao
 * @创建人:SYC
 * @创建时间:2017年7月20日 上午9:38:23
 */
public class ProductDao {

	// 存放商品的集合
	private static ArrayList<Product> products = new ArrayList<>();

	static {
		for (int i = 1; i <= 10; i++) {
			Product product = new Product("00" + i, "电视机" + i, "100" + i, "家电");
			products.add(product);
		}
	}
	
	//查询全部商品
	public List<Product> findAll(){
		if(products!=null){
			return products;
		}
		return null;
	}
	
	//根据id查找指定的商品
	public Product findById(String id){
		for(Product p : products){
			if(p.getId().equals(id)){
				return p;
			}
		}
		return null;
	}
}
