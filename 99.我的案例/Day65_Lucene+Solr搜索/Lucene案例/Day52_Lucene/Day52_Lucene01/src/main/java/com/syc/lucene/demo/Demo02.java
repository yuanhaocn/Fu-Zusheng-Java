package com.syc.lucene.demo;

import java.io.File;
import java.io.IOException;

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

import com.syc.lucene.domain.Message;

/**
 * 从索引库中进行搜索
 * 
 * @创建人:一一哥
 */
public class Demo02 {

	@Test
	public void searchTest() {
		try {
			// 3.创建Directory对象,关联索引库
			Directory directory = FSDirectory.open(new File("E:/lucene"));

			// 2.创建IndexReader对象,负责加载索引库.
			IndexReader reader = DirectoryReader.open(directory);

			// 1.创建IndexSearcher对象.
			IndexSearcher searcher = new IndexSearcher(reader);

			// 5.创建用来真正进行搜索的query对象.
			// 第一个参数是要搜索的字段的名称.
			//注意:默认情况下,搜索是按照单个字段来搜的,可以根据多个字段来搜索.
			QueryParser parser = new QueryParser("content", new StandardAnalyzer());
			// 设置搜索关键字
			Query query = parser.parse("轰炸");

			// 4.利用IndexSearcher对象进行搜索
			// 第2个参数:表示取搜索结果中的前n个.
			TopDocs docs = searcher.search(query, 100);

			// 6.遍历结果,封装到集合或者JavaBean中.
			// docs.totalHits;
			for (int i = 0; i < docs.scoreDocs.length; i++) {
				// 搜索的每一个Document对象.
				ScoreDoc scoreDoc = docs.scoreDocs[i];
				// 得到每一个Document对象的编号
				int docID = scoreDoc.doc;

				// 根据文档编号,得到对应的Document文档.
				Document doc = searcher.doc(docID);

				// 从文档中,根据field的名称,查询对应的内容
				String id = doc.get("id");
				String title = doc.get("title");
				String content = doc.get("content");
				Message msg=new Message(Integer.parseInt(id), title, content);
				System.out.println("msg="+msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
