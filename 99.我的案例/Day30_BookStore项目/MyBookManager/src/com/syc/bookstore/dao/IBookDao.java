package com.syc.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.syc.bookstore.domain.Book;
import com.syc.bookstore.domain.Order;

/**
 * Dao层的图书Dao
 * 
 * @类名称:IBookDao
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午5:11:09
 */
public interface IBookDao {

	// 添加图书
	public void addBook(Book book) throws SQLException;

	// 根据ID删除图书
	public void deleteBookByID(String id) throws SQLException;

	// 删除多个图书
	public void deleteBooks(String[] ids) throws SQLException;

	// 修改图书
	public void updateBook(Book book) throws SQLException;

	// 根据ID查找图书
	public Book findBookByID(String id) throws SQLException;

	// 查找名称图书
	public List<Object> findBookNameByName(String name) throws SQLException;
	
	//根据名称查找图书
	public Book findBookByName(String name) throws SQLException;

	// 查找所有图书
	public List<Book> findAllBooks() throws SQLException;
	
	// 按页查找当前页的图书
	public List<Book> findBookByPage(int pageSize,int currentPage,String category) throws SQLException;

	// 搜索图书
	public List<Book> searchBooks(String id, String name, String category, String minPrice, String maxPrice) throws SQLException;
	
	//获取图书总数量
	public int getTotalCount(String category) throws SQLException;

	//修改图书数量
	public void updateBooksNum(Order order) throws SQLException;
	
}
