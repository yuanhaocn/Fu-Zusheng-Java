package com.syc.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.syc.book.domain.Book;
import com.syc.book.domain.Order;

/**
 * Dao层的接口
 * 
 * @类名称:IBookDao
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午9:28:45
 */
public interface IBookDao {

	public List<Book> findAllBooks() throws SQLException;

	public Book findBookByID(String id) throws SQLException;

	public void updateBook(Book book) throws SQLException;

	public void deleteBookById(String id) throws SQLException;

	public void deleteBooks(String[] ckdValue) throws SQLException;

	public void addBook(Book book) throws SQLException;

	public List<Book> searchBooks(String id, String name, String category, String minPrice, String maxPrice)
			throws SQLException;

	public int getTotalCount(String category) throws SQLException;

	public List<Book> findBooksByPage(int pageSize, String category, int currentPage) throws SQLException;
	
	//修改图书数量
	public void updateBookNum(Order order) throws SQLException;
}
