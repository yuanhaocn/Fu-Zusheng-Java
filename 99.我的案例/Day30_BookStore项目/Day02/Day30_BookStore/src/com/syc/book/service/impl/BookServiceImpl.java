package com.syc.book.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.syc.book.dao.IBookDao;
import com.syc.book.dao.impl.BookDaoImpl;
import com.syc.book.domain.Book;
import com.syc.book.domain.PageBean;
import com.syc.book.service.IBookService;

/**
 * Service层对Book模块的实现
 * 
 * @类名称:BookServiceImpl
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午9:27:18
 */
public class BookServiceImpl implements IBookService {

	private IBookDao dao = new BookDaoImpl();

	@Override
	public List<Book> findAllBooks() {
		try {
			return dao.findAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book findBookById(String id) {
		try {
			return dao.findBookByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateBook(Book book) {
		try {
			dao.updateBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBookByID(String id) {
		try {
			dao.deleteBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBooks(String[] ckdValue) {
		try {
			dao.deleteBooks(ckdValue);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addBook(Book book) {
		try {
			dao.addBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> searchBooks(String id, String name, String category, String minPrice, String maxPrice) {
		try {
			return dao.searchBooks(id, name, category, minPrice, maxPrice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 实现分页查询
	@Override
	public PageBean pageBooks(int currentPage, int pageSize, String category) {

		try {
			// 查询某一类图书或者全部图书的总数量
			int totalCount = dao.getTotalCount(category);
			// totalCount=20,pageSize=4,totalPage=20/4=5;
			// totalCount=21,pageSize=4,totalPage=21/4=5;

			// 21.0/5=4.2
			// int totalPage = totalCount / pageSize;
			// 1.取余方式:
			// int mod = totalCount % pageSize;
			// if (mod > 0) {
			// totalPage += 1;
			// }

			// 2.利用类型转换和数学函数
			int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);

			// 得到了每一页对应的Book
			List<Book> books = dao.findBooksByPage(pageSize, category, currentPage);

			PageBean bean = new PageBean();
			// 封装图书总量
			bean.setTotalCount(totalCount);
			// 封装总页数
			bean.setTotalPage(totalPage);
			bean.setBooks(books);
			bean.setPageSize(pageSize);
			bean.setCategory(category);
			bean.setCurrentPage(currentPage);

			return bean;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
