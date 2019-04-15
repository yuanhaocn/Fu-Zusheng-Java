package com.syc.lucene.demo;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.syc.lucene.domain.Message;
import com.syc.lucene.util.LuceneUtil;

/**
 * 根据多字段进行搜索
 * 
 * @创建人:一一哥
 */
public class Demo03 {

	@Test
	public void addDocumentTest() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			Message msg = new Message(3, "飞机", "我有钱了就买一个私人飞机");
			Document doc = LuceneUtil.bean2Document(msg);
			writer.addDocument(doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void multiQueryTest() {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			// 默认情况:只能是单字段查询
			//QueryParser parser = new QueryParser("title", new IKAnalyzer());

			// 多字段查询
			QueryParser parser = new MultiFieldQueryParser(
					new String[] { "title", "content" }, new IKAnalyzer());

			Query query = parser.parse("私人");
			TopDocs topDocs = searcher.search(query, 100);

			// 输出结果
			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
