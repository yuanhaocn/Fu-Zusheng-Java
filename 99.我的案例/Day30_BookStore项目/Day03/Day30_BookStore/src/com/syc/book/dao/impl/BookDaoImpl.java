package com.syc.book.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.syc.book.dao.IBookDao;
import com.syc.book.domain.Book;
import com.syc.book.domain.Order;
import com.syc.book.domain.OrderItem;
import com.syc.book.utils.C3P0Util;

/**
 * Dao层对Book模块的实现
 * 
 * @类名称:BookDaoImpl
 * @创建人:SYC
 * @创建时间:2017年8月7日 上午9:29:15
 */
public class BookDaoImpl implements IBookDao {

	private QueryRunner qr = null;

	public BookDaoImpl() {
		qr = new QueryRunner(C3P0Util.getSource());
	}

	@Override
	public List<Book> findAllBooks() throws SQLException {
		String sql = "select * from book";
		return qr.query(sql, new BeanListHandler<>(Book.class));
	}

	@Override
	public Book findBookByID(String id) throws SQLException {
		String sql = "select * from book where id=?";
		return qr.query(sql, new BeanHandler<>(Book.class), id);
	}

	@Override
	public void updateBook(Book book) throws SQLException {
		String sql = "update book set name=?,price=?,pnum=?,category=?,description=?  where id=?";
		qr.update(sql, book.getName(), book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription(),
				book.getId());
	}

	@Override
	public void deleteBookById(String id) throws SQLException {
		String sql = "delete from book where id=?";
		qr.update(sql, id);
	}

	@Override
	public void deleteBooks(String[] ids) throws SQLException {
		String sql = "delete from book where id=?";
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			// 给二维数组赋值
			params[i] = new String[] { ids[i] };
		}
		// 效率高
		qr.batch(sql, params);
	}

	@Override
	public void addBook(Book book) throws SQLException {
		String sql = "insert into book values(?,?,?,?,?,?,?)";
		qr.update(sql, book.getId(), book.getName(), book.getPrice(), book.getPnum(), book.getCategory(),
				book.getDescription(), book.getImg_url());
	}

	@Override
	public List<Book> searchBooks(String id, String name, String category, String minPrice, String maxPrice)
			throws SQLException {

		// 1=1存在的意义:只是为了保证sql的语法正确.
		String sql = "select * from book where 1=1";

		// 存放参数值
		List<Object> params = new ArrayList<>();

		if (!"".equals(id) && id != null) {
			sql += " and id like ?";
			params.add("%" + id.trim() + "%");
		}

		if (!"".equals(name) && name != null) {
			sql += " and name like ?";
			params.add("%" + name.trim() + "%");
		}

		if (!"".equals(category) && category != null) {
			sql += " and category = ?";
			params.add(category.trim());
		}

		if (!"".equals(minPrice) && minPrice != null) {
			sql += " and price > ?";
			params.add(Double.parseDouble(minPrice));
		}

		if (!"".equals(maxPrice) && maxPrice != null) {
			sql += " and price < ?";
			params.add(Double.parseDouble(maxPrice));
		}

		System.out.println(sql);

		return qr.query(sql, new BeanListHandler<>(Book.class), params.toArray());
	}

	// 查询某一类或者全部图书的数量
	@Override
	public int getTotalCount(String category) throws SQLException {
		String sql = "select count(*) from book where 1=1";

		// List<String> params=new ArrayList<>();
		if (!"".equals(category) && category != null) {
			sql += " and category='" + category + "'";
			// params.add(category);
		}

		long count = (long) qr.query(sql, new ScalarHandler(1));
		return (int) count;
	}

	// 查询每一页对应的图书信息
	@Override
	public List<Book> findBooksByPage(int pageSize, String category, int currentPage) throws SQLException {

		String sql = "select * from book where 1=1";

		List<Object> params = new ArrayList<>();
		if (!"".equals(category) && category != null) {
			sql += " and category=?";
			params.add(category);
		}

		// limit index,count
		// 15个商品,每页显示4个,总共4页
		// 第一页的数据:0~3 limit 0,4
		// 第二页的数据:4~7 limit 4,4
		// 第三页的数据:8~11 limit 8,4
		// 第4页的数据:12~14 limit 12,4
		// (currentPage-1)*pageSize

		sql += " limit ?,?";

		params.add((currentPage - 1) * pageSize);
		params.add(pageSize);

		return qr.query(sql, new BeanListHandler<>(Book.class), params.toArray());
	}

	// 修改图书数量
	@Override
	public void updateBookNum(Order order) throws SQLException {
		// update book set pnum=pnum-order.getBuyCount where id=order.id

		String sql = "update book set pnum=pnum-? where id=?";

		List<OrderItem> items = order.getOrderItems();
		Object[][] params = new Object[items.size()][];
		for (int i = 0; i < items.size(); i++) {
			params[i] = new Object[] { items.get(i).getBuynum(), items.get(i).getBook().getId() };
		}
		qr.batch(sql, params);
	}

}
