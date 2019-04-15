package com.syc.bookstore.service;

import java.util.List;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.domain.PageBean;

/**
 * Service层中对Book图书管理的类
 * 
 * @类名称:IBookService
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午4:38:42
 */
public interface IBookService {

	// 添加图书
	public void addBook(Book book);

	// 根据ID删除图书
	public void deleteBookByID(String id);

	// 删除多个图书
	public void deleteBooks(String[] ids);

	// 修改图书
	public void updateBook(Book book);

	// 根据ID查找图书
	public Book findBookByID(String id);

	// 查找图书名称
	public List<Object> findBookNameByName(String name);
	
	//根据name查找图书
	public Book findBookByName(String name);

	// 查找所有图书
	public List<Book> findAllBooks();

	// 实现图书分页.
	public PageBean pageBooks(int pageSize, int currentPage, String category);

	// 搜索图书
	public List<Book> searchBooks(String id, String name, String category, String minPrice, String maxPrice);
}
