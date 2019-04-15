package com.syc.lucene.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

import com.syc.lucene.domain.Message;
import com.syc.lucene.util.LuceneUtil;

/**
 * 对Lucene索引进行CRUD操作
 * 
 * @创建人:一一哥
 */
public class Demo04 {

	/**
	 * 添加索引
	 */
	@Test
	public void addIndex() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			Message msg = new Message(3, "娱乐圈", "圈外的人想进来,圈里的人不想出来");
			Document doc = LuceneUtil.bean2Document(msg);
			// 添加索引
			writer.addDocument(doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询文档
	 */
	@Test
	public void searchTest() {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			QueryParser parser = new QueryParser("title", LuceneUtil.getAnalyzer());
			Query query = parser.parse("娱乐");
			TopDocs topDocs = searcher.search(query, 100);

			List<Message> msgs = new ArrayList<Message>();
			for (int i = 0; i < topDocs.totalHits; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				msgs.add(msg);
			}

			for (Message msg : msgs) {
				System.out.println("msg=" + msg.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新索引库
	 */
	@Test
	public void updateTest() {
		try {
			Message msg = new Message(2,"娱乐圈","贵圈年年乱,今年特别乱,下年会更乱!");
			Document doc = LuceneUtil.bean2Document(msg);
			IndexWriter writer = LuceneUtil.createIndexWriter();
			//update doc set content="贵圈年年乱,今年特别乱,下年会更乱" where id=2;
			//Term("id", "2"):相当于where后的条件,根据id=2来进行修改.
			writer.updateDocument(new Term("id", "2"), doc);
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据条件删除索引库
	 */
	@Test
	public void deleteByConditionTest(){
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			//delete from doc where id=3;
			//根据条件进行删除
			writer.deleteDocuments(new Term("id", "3"));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 全部删除索引库
	 */
	@Test
	public void deleteAllTest(){
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			//无条件进行删除
			writer.deleteAll();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
