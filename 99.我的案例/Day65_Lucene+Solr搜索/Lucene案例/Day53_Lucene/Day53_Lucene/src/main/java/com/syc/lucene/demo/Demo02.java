package com.syc.lucene.demo;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.syc.lucene.domain.Message;
import com.syc.lucene.util.LuceneUtil;

/**
 * 对检索关键字进行高亮显示
 * 
 * @创建人:一一哥
 */
public class Demo02 {

	@Test
	public void addDocumentTest() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			Message msg = new Message(2, "手机iphoneX", "iphoneX马上要大降价了");
			Document doc=LuceneUtil.bean2Document(msg);
			writer.addDocument(doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 检索时进行高亮显示
	 */
	@Test
	public void highLightTest(){
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();
			QueryParser parser=new QueryParser("content", new IKAnalyzer());
			Query query = parser.parse("iphoneX");
			TopDocs topDocs = searcher.search(query, 100);
			
			String preTag="<font color='red'>";
			String postTag="</font>";
			SimpleHTMLFormatter formatter=new SimpleHTMLFormatter(preTag, postTag);
			//QueryScorer与Query对象会关联在一起.
			QueryScorer scorer=new QueryScorer(query);
			//创建高亮对象
			Highlighter lighter=new Highlighter(formatter, scorer);
			
			for(int i=0;i<topDocs.scoreDocs.length;i++){
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				
				//给title字段里的相应内容添加高亮
				String title = lighter.getBestFragment(new IKAnalyzer(), "title", doc.get("title"));
				String content = lighter.getBestFragment(new IKAnalyzer(), "content", doc.get("content"));
				
				System.out.println("title="+title);
				System.out.println("content="+content);
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
