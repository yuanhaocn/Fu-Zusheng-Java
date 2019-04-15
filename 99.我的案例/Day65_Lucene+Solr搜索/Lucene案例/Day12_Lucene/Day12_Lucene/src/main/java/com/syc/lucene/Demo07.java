package com.syc.lucene;

import org.apache.lucene.document.Document;
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

/**
 * 关键词语法高亮
 * 
 * @创建人:一一哥
 * @创建时间:2018年4月24日 上午9:49:58
 */
public class Demo07 {

	@Test
	public void highLightTest() throws Exception {
		IndexSearcher searcher = LuceneUtil.createIndexSearcher();
		QueryParser parser = new QueryParser("desc", new IKAnalyzer());
		Query query = parser.parse("手机");
		TopDocs docs = searcher.search(query, 100);

		// 简单的网页格式化器
		// <font color='red'>手机</font>
		String preTag = "<font color='red'>";
		String postTag = "</font>";
		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter(preTag, postTag);
		// 与query对象关联在一起,就起到了匹配关键词的作用.
		QueryScorer fragmentScorer = new QueryScorer(query);
		Highlighter lighter = new Highlighter(formatter, fragmentScorer);

		for (int i = 0; i < docs.totalHits; i++) {
			ScoreDoc scoreDoc = docs.scoreDocs[i];
			int docID = scoreDoc.doc;
			Document document = searcher.doc(docID);

			String id = document.get("id");
			String name = document.get("name");
			String desc = document.get("desc");

			//指定关键词可能在哪个字段中出现,并且给该字段中的关键词进行高亮.
			String lightName = lighter.getBestFragment(new IKAnalyzer(), "name", name);
			String lightDesc = lighter.getBestFragment(new IKAnalyzer(), "desc", desc);

			System.out.println("id=" + id);
			System.out.println("name=" + lightName);
			System.out.println("desc=" + lightDesc);
			
			//Product pro=new Product(Integer.parseInt(id), lightName, lightDesc);
			//List<Product> products;
			//pro---->json字符串.
			//{products:[{'id':1,'name':'<font color='red'>手机</font>','desc':'xxxx<font color='red'>手机</font>'},{},{}]}
		}
	}

}
