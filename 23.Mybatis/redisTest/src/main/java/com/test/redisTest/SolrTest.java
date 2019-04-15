package com.test.redisTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrTest {
	
	@Test
	public void testCreate() throws Exception{
//		连接到solr的new_core核心文件
		String url="http://www.fzs.com:8080/solr/new_core";
		HttpSolrClient server = new HttpSolrClient(url);
//		创建文档
		SolrInputDocument doc = new SolrInputDocument();
//		这个field是在solr core中配置过的
		doc.addField("id", "9527");
		doc.addField("item_title", "程序员的自我修养");
		doc.addField("item_content", "java从入门到放弃");
		doc.addField("item_price", 3234);
		server.add(doc);
		server.commit();
		server.close();
		System.out.println("创建成功");
	}
	
	@Test
	public void testQuery() throws Exception {
		String url="http://www.fzs.com:8080/solr/new_core";
		HttpSolrClient server = new HttpSolrClient(url);
		SolrQuery query = new SolrQuery("*:*");
		query.setStart(0);
		query.setRows(454);
		QueryResponse res=server.query(query);
		SolrDocumentList results = res.getResults();
		System.out.println("查询到的总共记录是"+results.getNumFound());
		for (SolrDocument doc : results) {
			 System.out.println(doc);
		}
	}
	@Test
	public void flaxQuery() throws Exception {
		String url="http://www.fzs.com:8080/solr/new_core";
		HttpSolrClient server = new HttpSolrClient(url);
		SolrQuery solrQuery = new SolrQuery("item_title:程序员");
		
		solrQuery.setHighlight(true);
		solrQuery.addHighlightField("item_title");
		solrQuery.setHighlightSimplePre("<font color='red'>");
		solrQuery.setHighlightSimplePost("</font>");
		
		QueryResponse resp=server.query(solrQuery);
		SolrDocumentList results = resp.getResults();
		
		Map<String, Map<String, List<String>>> highlighting = resp.getHighlighting();
		for (SolrDocument solrDocument : results) {
			System.out.println(solrDocument);
			List<String> list = highlighting.get(solrDocument.get("id")).get("item_title");
			String itemTitle=null;
			if(list !=null && list.size()>0) {
				itemTitle=list.get(0);
			}else {
				itemTitle=(String) solrDocument.get("item_title");
			}
			System.out.println(itemTitle);
			System.out.println("*&^&^%%&&^^%$**_*&%%#$#*$@%");
		}
		server.close();
	}
	
	@Test
	public void queryIndexx() {
		HttpSolrServer solrServer = new HttpSolrServer("http://www.fzs.com:8080/solr/collection1");
		SolrQuery query = new SolrQuery();
		query.setQuery("手机");
		 
	}

}



















