package com.syc.bookstore.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.syc.bookstore.dao.IBookDao;
import com.syc.bookstore.dao.impl.BookDaoImpl;
import com.syc.bookstore.domain.Book;
import com.syc.bookstore.domain.PageBean;
import com.syc.bookstore.service.IBookService;

/**
 * Service层的具体实现. 图书相关业务的增删改查.
 * 
 * @类名称:BookServiceImpl
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午4:55:06
 */
public class BookServiceImpl implements IBookService {

	// 创建IBookDao对象
	private IBookDao dao = new BookDaoImpl();

	@Override
	public void addBook(Book book) {
		try {
			dao.addBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteBookByID(String id) {
		try {
			dao.deleteBookByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteBooks(String[] ids) {
		try {
			dao.deleteBooks(ids);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateBook(Book book) {
		try {
			dao.updateBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Book findBookByID(String id) {
		try {
			return dao.findBookByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Object> findBookNameByName(String name) {
		try {
			return dao.findBookNameByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Book> findAllBooks() {
		try {
			return dao.findAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public PageBean pageBooks(int pageSize, int currentPage, String category) {
		try {
			// 获取商品总数量
			int totalCount = dao.getTotalCount(category);
			
			// 向上取整
			int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);

			//查找当前页的Books
			List<Book> books = dao.findBookByPage(pageSize, currentPage, category);

			// 封装PageBean
			PageBean bean = new PageBean();
			bean.setTotalPage(totalPage);
			bean.setTotalCount(totalCount);
			bean.setPageSize(pageSize);
			bean.setCurrentPage(currentPage);
			bean.setCategory(category);
			bean.setBooks(books);
			
			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public List<Book> searchBooks(String id, String name, String category, String minPrice, String maxPrice) {
		try {
			return dao.searchBooks(id, name, category, minPrice, maxPrice);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Book findBookByName(String name) {
		try {
			return dao.findBookByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
