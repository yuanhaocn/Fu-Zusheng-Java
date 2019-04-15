package com.syc.lucene;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.util.BytesRef;

/**
 * 为查询封装一个简单工具类
 * 
 * @类名称:MyQuery
 * @创建人:一一哥
 * @创建时间:2018年4月24日 下午2:30:40
 */
public class MyQuery {

	/**
	 * 精确查询
	 */
	public static void searchByTerm(String field, String value) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			// 精确查询
			// 注意:做精确查询的时候,一定要注意分词器的影响!
			// select * from product where name="水果"
			Query query = new TermQuery(new Term(field, value));
			TopDocs docs = searcher.search(query, 100);

			for (int i = 0; i < docs.totalHits; i++) {
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				int docID = scoreDoc.doc;
				Document document = searcher.doc(docID);
				Product product = (Product) LuceneUtil.document2Bean(document, Product.class);
				System.out.println("product=" + product.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按范围查询
	 */
	public static void searchByRange(String field, String lower, String upper) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();
			// [1,3]
			BytesRef lowerTerm = new BytesRef(lower);
			BytesRef upperTerm = new BytesRef(upper);
			Query query = new TermRangeQuery(field, lowerTerm, upperTerm, false, false);

			TopDocs docs = searcher.search(query, 100);

			for (int i = 0; i < docs.totalHits; i++) {
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				int docID = scoreDoc.doc;
				Document document = searcher.doc(docID);
				Product product = (Product) LuceneUtil.document2Bean(document, Product.class);
				System.out.println("product=" + product.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 前缀查询
	 */
	public static void searchByPrefix(String field, String value) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			Query query = new PrefixQuery(new Term(field, value));

			TopDocs docs = searcher.search(query, 100);

			for (int i = 0; i < docs.totalHits; i++) {
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				int docID = scoreDoc.doc;
				Document document = searcher.doc(docID);
				Product product = (Product) LuceneUtil.document2Bean(document, Product.class);
				System.out.println("product=" + product.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通配符查询.?:代表任意一个;*:代表任意多个.
	 */
	public static void searchByWildcard(String field, String value) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			Query query = new WildcardQuery(new Term(field, value));

			TopDocs docs = searcher.search(query, 100);

			for (int i = 0; i < docs.totalHits; i++) {
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				int docID = scoreDoc.doc;
				Document document = searcher.doc(docID);
				Product product = (Product) LuceneUtil.document2Bean(document, Product.class);
				System.out.println("product=" + product.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 布尔类型的多条件查询
	 */
	public static void searchByBoolean() {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			BooleanQuery query = new BooleanQuery();
			//Must,必须满足该条件:id=1
			query.add(new TermQuery(new Term("id","1")), Occur.MUST);
			//SHOULD,表示不一定
			query.add(new TermQuery(new Term("name","飞鸡")), Occur.SHOULD);

			TopDocs docs = searcher.search(query, 100);

			for (int i = 0; i < docs.totalHits; i++) {
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				int docID = scoreDoc.doc;
				Document document = searcher.doc(docID);
				Product product = (Product) LuceneUtil.document2Bean(document, Product.class);
				System.out.println("product=" + product.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 只针对英文有效的模糊查询
	 */
	public static void searchByFuzzy(String field,String value) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			Query query = new FuzzyQuery(new Term(field,value));

			TopDocs docs = searcher.search(query, 100);

			for (int i = 0; i < docs.totalHits; i++) {
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				int docID = scoreDoc.doc;
				Document document = searcher.doc(docID);
				Product product = (Product) LuceneUtil.document2Bean(document, Product.class);
				System.out.println("product=" + product.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
