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
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopFieldDocs;
import org.junit.Test;

import com.syc.lucene.domain.Message;
import com.syc.lucene.util.LuceneUtil;

/**
 * 对Lucene索引进行CRUD操作
 * 
 * @创建人:一一哥
 */
public class Demo05 {

	/**
	 * 添加索引
	 */
	@Test
	public void addIndex() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			Message msg = new Message(3, "笔记本", "神州也贵啊...");
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
	
	//索引库查询.默认情况下,是根据搜索结果的相关度的分数(score)来对结果进行排序;
	//但是也可以根据自己指定的字段来进行排序.
	@Test
	public void sortTest() {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();
			QueryParser parser = new QueryParser("content", LuceneUtil.getAnalyzer());
			Query query = parser.parse("也贵");
			
			//默认查询.
			//TopDocs topDocs = searcher.search(query, 100);
			
			//自定义排序查询
			//field:要排序的列;
			//type:该列在document中的类型;
			//true:表示降序;false:表示升序
			Sort sort=new Sort(new SortField("id", SortField.Type.INT, false));
			//Sort sort=new Sort(new SortField("id", SortField.Type.INT, false),new SortField("content", SortField.Type.STRING, true));
			//得到排序后的搜索结果
			TopFieldDocs topDocs = searcher.search(query, 100, sort);

			List<Message> msgs=new ArrayList<Message>();
			
			for(int i=0;i<topDocs.totalHits;i++){
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				msgs.add(msg);
			}
			
			for(Message msg: msgs){
				System.out.println("msg="+msg);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
