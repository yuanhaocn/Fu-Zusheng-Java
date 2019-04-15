package com.syc.lucene.demo;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.junit.Test;

import com.syc.lucene.domain.Message;
import com.syc.lucene.util.LuceneUtil;

public class Demo04 {

	@Test
	public void addDocumentTest() {
		try {
			IndexWriter writer = LuceneUtil.createIndexWriter();
			//IndexWriter writer = LuceneUtil.createIndexWriterByIK();
			//Message msg = new Message(7, "手链", "弄一个核桃手链玩玩...");
			Message msg = new Message(8, "phone", "I want buy a IPHONEX");
			Document doc=LuceneUtil.bean2Document(msg);
			writer.addDocument(doc);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1(){
		MySearcher searcher=new MySearcher();
		searcher.search("id", "1");
		//searcher.search("title", "手机");
	}
	
	@Test
	public void test2(){
		MySearcher searcher=new MySearcher();
		//注意:精确查询时,查询结果要注意分词器的影响!
		//searcher.searchByTerm("title", "手机");
		searcher.searchByTerm("title", "手链");
		//searcher.searchByTerm("id", "1");
		//searcher.searchByTerm("title", "phone");
	}
	
	@Test
	public void test3(){
		MySearcher searcher=new MySearcher();
		searcher.searchByTermRange("id", "3", "6");
	}
	
	@Test
	public void test4(){
		MySearcher searcher=new MySearcher();
		searcher.searchByPrefix("title", "坦");
	}
	
	@Test
	public void test5(){
		MySearcher searcher=new MySearcher();
		searcher.searchByWildcard("content", "*为*");
		//searcher.searchByWildcard("content", "*坦*");
	}
	
	@Test
	public void test6(){
		MySearcher searcher=new MySearcher();
		searcher.searchByBoolean();
	}
	
	@Test
	public void test7(){
		MySearcher searcher=new MySearcher();
		searcher.searchByPhrase("title", "phone");
		searcher.searchByPhrase("content", "buy");
	}
	
	@Test
	public void test8(){
		MySearcher searcher=new MySearcher();
		searcher.searchByFuzzy("content", "want");
	}
	
	@Test
	public void test9(){
		MySearcher searcher=new MySearcher();
		searcher.searchByPage("title", "手机", 1, 1);
	}
	
	@Test
	public void test10(){
		MySearcher searcher=new MySearcher();
		searcher.searchByPage2("title", "手机", 2, 3);
	}
}
