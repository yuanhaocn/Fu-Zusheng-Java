package com.syc.lucene;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

/**
 * 从索引库中查询内容
 * 
 * @创建人:一一哥
 * @创建时间:2018年4月24日 上午9:49:58
 */
public class Demo02 {

	@Test
	public void readerTest() {
		try {
			Directory directory = FSDirectory.open(new File("E:/lucene"));
			IndexReader reader = DirectoryReader.open(directory);
			// reader.document(docID);
			IndexSearcher searcher = new IndexSearcher(reader);

			// f:要查询的是哪个字段.
			QueryParser parser = new QueryParser("name", new StandardAnalyzer());
			// name="女朋友",指明关键词的内容
			// 效果类似于:select * from product where name="女朋友"
			Query query = parser.parse("朋友");
			// 进行检索
			TopDocs docs = searcher.search(query, 100);

			// 遍历结果集,docs.totalHits,命中的总数量;
			for (int i = 0; i < docs.scoreDocs.length; i++) {
				// 取出数组中的每一个符合条件的Doc对象
				ScoreDoc doc = docs.scoreDocs[i];
				// 每个文档的id
				int docID = doc.doc;
				Document document = searcher.doc(docID);
				// IndexableField idField = document.getField("id");
				// String idValue = idField.stringValue();
				String id = document.get("id");
				String name = document.get("name");
				String desc = document.get("desc");

				System.out.println("id=" + id + ",name=" + name + ",desc=" + desc);
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void copyPropertiesTest() {
		try {
			Product origPro = new Product(1, "商品1", "商品1的描述");
			Product destPro = new Product();

			// copyProperties:底层的实现原理:反射+setXXX..
			// destPro.setId(origPro.getId());
			// destPro.setName(origPro.getName());
			// destPro.setDesc(origPro.getDesc());

			BeanUtils.copyProperties(destPro, origPro);

			System.out.println("结果=" + destPro.toString());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void copyPropertyTest() {
		try {
			Product bean = new Product();

			BeanUtils.copyProperty(bean, "id", 1);
			BeanUtils.copyProperty(bean, "name", "商品2");
			BeanUtils.copyProperty(bean, "desc", "miaoshu");

			System.out.println("结果=" + bean.toString());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

}
