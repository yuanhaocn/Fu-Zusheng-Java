package com.syc.book.service;

import java.util.List;

import com.syc.book.domain.Book;
import com.syc.book.domain.PageBean;

/**
 * Book图书模块,分2部分,后台管理员部分;前台会员部分.
 * @类名称:IBookService
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午9:23:01
 */
public interface IBookService {

	public List<Book> findAllBooks();
	
	public Book findBookById(String id);
	
	public void updateBook(Book book);

	public void deleteBookByID(String id);

	public void deleteBooks(String[] ckdValue);

	public void addBook(Book book);

	public List<Book> searchBooks(String id, String name, String category, String minPrice, String maxPrice);

	public PageBean pageBooks(int currentPage, int pageSize, String category);
}
