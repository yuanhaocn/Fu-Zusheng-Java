package com.syc.lucene.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.junit.Test;

import com.syc.lucene.domain.Message;
import com.syc.lucene.util.LuceneUtil;

/**
 * 利用工具类,实现前两个Demo
 * 
 * @创建人:一一哥
 */
public class Demo03 {

	@Test
	public void createIndex() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			Message msg = new Message(2, "娱乐", "贵圈年年乱,今年特别乱");
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
}
