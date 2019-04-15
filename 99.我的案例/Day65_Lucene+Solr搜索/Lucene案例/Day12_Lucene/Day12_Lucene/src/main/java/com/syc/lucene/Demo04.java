package com.syc.lucene;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

/**
 * 从索引库中查询内容
 * 
 * @创建人:一一哥
 * @创建时间:2018年4月24日 上午9:49:58
 */
public class Demo04 {

	@Test
	public void updateIndexTest() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			// 类似于update product set name="xxx",desc="xx" where id=2
			Product bean = new Product(2, "男人", "男人是拦截登陆发");
			Document doc = LuceneUtil.bean2Document(bean);
			writer.updateDocument(new Term("id", "2"), doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteIndexTest() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			//类似于:delete from product where id=2
			writer.deleteDocuments(new Term("id","3"));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteAllIndexTest() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			writer.deleteAll();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void queryTest() {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();
			QueryParser parser=new QueryParser("id", LuceneUtil.getAnalyzer());
			Query query = parser.parse("3");
			TopDocs docs = searcher.search(query, 100);
			for(int i=0;i<docs.totalHits;i++){
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				int docID = scoreDoc.doc;
				Document document = searcher.doc(docID);
				Product product = (Product) LuceneUtil.document2Bean(document, Product.class);
				System.out.println("product="+product.toString());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
