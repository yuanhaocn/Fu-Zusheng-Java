package com.syc.lucene;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopFieldDocs;
import org.junit.Test;

/**
 * lucene的各种查询方案
 * 
 * @创建人:一一哥
 * @创建时间:2018年4月24日 上午9:49:58
 */
public class Demo05 {

	@Test
	public void createIndexTest() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			Product bean = new Product(5, "水果", "banana");
			Document doc = LuceneUtil.bean2Document(bean);
			writer.addDocument(doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 排序
	 */
	@Test
	public void sortTest() {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();
			QueryParser parser = new QueryParser("name", LuceneUtil.getAnalyzer());
			Query query = parser.parse("手机");

			// true:降序;false:升序
			Sort sort = new Sort(new SortField("id", SortField.Type.INT, true));
			// TopDocs docs = searcher.search(query, 100, sort);
			TopFieldDocs docs = searcher.search(query, 100, sort);

			for (int i = 0; i < docs.totalHits; i++) {
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				int docID = scoreDoc.doc;
				Document document = searcher.doc(docID);
				Product product = (Product) LuceneUtil.document2Bean(document, Product.class);
				System.out.println("product=" + product.toString());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据多列来进行查询
	 */
	@Test
	public void multiTest() {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			QueryParser parser = new MultiFieldQueryParser(new String[] { "name", "desc" }, LuceneUtil.getAnalyzer());
			Query query = parser.parse("水果");
			TopDocs docs = searcher.search(query, 100);

			for (int i = 0; i < docs.totalHits; i++) {
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				int docID = scoreDoc.doc;
				Document document = searcher.doc(docID);
				Product product = (Product) LuceneUtil.document2Bean(document, Product.class);
				System.out.println("product=" + product.toString());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 精确查询
	 */
	@Test
	public void jingqueTest() {
		MyQuery.searchByTerm("name", "水");
	}
	
	
	/**
	 * 范围查询
	 */
	@Test
	public void test3() {
		MyQuery.searchByRange("id", "1", "3");
	}
	
	/**
	 * 前缀查询
	 */
	@Test
	public void test4() {
		MyQuery.searchByPrefix("name", "手");
	}
	
	/**
	 * 通配符查询
	 */
	@Test
	public void test5() {
		MyQuery.searchByWildcard("desc", "*香*");
	}
	
	@Test
	public void test6() {
		MyQuery.searchByBoolean();
	}
	
	@Test
	public void test7() {
		MyQuery.searchByFuzzy("desc", "banana");
	}
}
