package com.syc.bookstore.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.syc.bookstore.dao.IBookDao;
import com.syc.bookstore.domain.Book;
import com.syc.bookstore.domain.Order;
import com.syc.bookstore.domain.OrderItem;
import com.syc.bookstore.utils.C3P0Util;

/**
 * Dao层实现图书Bood的CRUD
 * 
 * @类名称:BookDao
 * @创建人:SYC
 * @创建时间:2017年7月13日 下午5:21:47
 */
public class BookDaoImpl implements IBookDao {

	private QueryRunner qr;

	public BookDaoImpl() {
		qr = new QueryRunner(C3P0Util.getDataSource());
	}

	@Override
	public void addBook(Book book) throws SQLException {
		// QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql = "insert into book values(?,?,?,?,?,?,?)";
		qr.update(sql, book.getId(), book.getName(), book.getPrice(), book.getPnum(), book.getCategory(),
				book.getDescription(), book.getImg_url());
	}

	@Override
	public void deleteBookByID(String id) throws SQLException {
		String sql = "delete from book where id=?";
		qr.update(sql, id);
	}

	@Override
	public void deleteBooks(String[] ids) throws SQLException {
		String sql = "delete from book where id=?";
		// 批处理用的二维数组
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			// 将ids数组填充到params[][]二维数组中
			params[i] = new String[] { ids[i] };
		}
		qr.batch(sql, params);
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		String sql = "update book set name=?,price=?,pnum=?,category=?,description=? where id=?";
		qr.update(sql, book.getName(), book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription(),
				book.getId());
	}

	@Override
	public Book findBookByID(String id) throws SQLException {
		String sql = "select * from book where id=?";
		return qr.query(sql, new BeanHandler<>(Book.class), id);
	}

	// 实现搜索框中输入书名,进行图书的模糊查询
	@Override
	public List<Object> findBookNameByName(String name) throws SQLException {
		String sql = "select name from book where name like ?";
		return qr.query(sql, new ColumnListHandler("name"), "%" + name + "%");
	}

	@Override
	public List<Book> findAllBooks() throws SQLException {
		String sql = "select * from book";
		return qr.query(sql, new BeanListHandler<>(Book.class));
	}

	@Override
	public List<Book> findBookByPage(int pageSize, int currentPage, String category) throws SQLException {

		// 理解where 1=1 的作用!---->为了使得where语法成立!

		String sql = "select * from book where 1=1";

		// 定义一个集合,存储?参数值
		List<Object> params = new ArrayList<>();

		if (!"".equals(category) && category != null) {
			sql += " and category=?";
			params.add(category);
		}

		// 分页输出
		sql += " limit ?,?";

		// index,length参数
		params.add((currentPage - 1) * pageSize);
		params.add(pageSize);

		return qr.query(sql, new BeanListHandler<>(Book.class), params.toArray());
	}

	@Override
	public List<Book> searchBooks(String id, String name, String category, String minPrice, String maxPrice)
			throws SQLException {

		String sql = "select * from book where 1=1 ";

		List<Object> params = new ArrayList<>();
		if (!"".equals(id.trim()) && id != null) {
			sql += " and id like ?";
			params.add("%" + id.trim() + "%");
		}

		if (!"".equals(name.trim()) && name != null) {
			sql += " and name like ?";
			params.add("%" + name.trim() + "%");
		}

		// 与类别相同
		if (!"".equals(category.trim()) && category != null) {
			sql += " and category = ?";
			params.add(category.trim());
		}

		// 大于最低价
		if (!"".equals(minPrice.trim()) && minPrice != null) {
			sql += " and price > ?";
			params.add(Double.parseDouble(minPrice.trim()));
		}

		// 小于最高价
		if (!"".equals(maxPrice.trim()) && maxPrice != null) {
			sql += " and price < ?";
			params.add(Double.parseDouble(maxPrice.trim()));
		}

		return qr.query(sql, new BeanListHandler<>(Book.class), params.toArray());
	}

	@Override
	public int getTotalCount(String category) throws SQLException {
		String sql = "select count(*) from book where 1=1";

		if (!"".equals(category.trim()) && category != null) {
			sql += " and category = '" + category + "'";
		}

		long count = (Long) qr.query(sql, new ScalarHandler(1));

		return (int) count;
	}

	// 商品售出后,数量减少
	@Override
	public void updateBooksNum(Order order) throws SQLException {
		// 数量减少
		String sql = "update book set pnum=pnum-? where id=?";
		// 获取订单中的订单条目
		List<OrderItem> items = order.getOrderItems();
		Object[][] params = new Object[items.size()][];
		for (int i = 0; i < params.length; i++) {
			// 二维数组赋值
			params[i] = new Object[] { items.get(i).getBuynum(), items.get(i).getBook().getId() };
		}

		qr.batch(sql, params);
	}

	//根据那么查找图书信息
	@Override
	public Book findBookByName(String name) throws SQLException {
		String sql = "select * from book where name=?";
		return qr.query(sql, new BeanHandler<>(Book.class),name);
	}

}
