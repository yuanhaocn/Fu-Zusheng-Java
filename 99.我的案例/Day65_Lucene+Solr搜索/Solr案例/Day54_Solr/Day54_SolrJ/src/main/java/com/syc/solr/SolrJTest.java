package com.syc.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJTest {

	/**
	 * 创建索引库
	 */
	@Test
	public void createIndexTest() {
		//注意:如果solr_home中,只有一个core,路径的最后可以不用写core的名称!
		//但是如果有多个core,则必须明确指明要操作的core的名称!
		String baseURL = "http://10.11.51.249:8080/solr/clusterCore";
		// 指定了Solr服务器地址
		HttpSolrServer server = new HttpSolrServer(baseURL);

		// 创建Document对象
		SolrInputDocument document = new SolrInputDocument();
		// 给文档中添加field
		// org.apache.solr.client.solrj.impl.
		//HttpSolrServer$RemoteSolrException:
		// Document is missing mandatory uniqueKey field: id.
		// document文档中必须有一个field的name为id!
		document.addField("id", 1);
		document.addField("pname", "笔记本");
		document.addField("pdesc", "苹果pro大贱卖了,才90一台!");

		try {
			// 创建索引库
			server.add(document);
			// 提交服务器
			server.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 索引查询
	 */
	@Test
	public void queryIndexTest() {
		String baseURL = "http://10.11.51.249:8080/solr/clusterCore";
		HttpSolrServer server = new HttpSolrServer(baseURL);
		SolrQuery query = new SolrQuery();
		// 设置查询关键字
		query.setQuery("笔记本");
		// 设置默认要查询的字段
		query.set("df", "pname");
		//根据哪一列进行排序
		//query.setSort("price", ORDER.desc);
		//设置分页的默认起始值
		//query.setStart(0);
		//设置每页的数量
		//query.setRows(10);
		//高亮设置
		//query.setHighlight(true);
		//query.setHighlightSimplePre("<font color='red'>");
		//query.setHighlightSimplePost("</font>");
		try {
			// 获取查询结果
			QueryResponse response = server.query(query);
			// 获取查询到的数组集合
			SolrDocumentList docs = response.getResults();
			for (SolrDocument doc : docs) {
				String id = (String) doc.get("id");
				String name = (String) doc.get("pname");
				String desc = (String) doc.get("pdesc");
				System.out.println("id=" + id);
				System.out.println("name=" + name);
				System.out.println("desc=" + desc);
			}
			
			server.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除索引
	 */
	@Test
	public void deleteIndexTest() {
		String baseURL = "http://10.11.51.249:8080/solr/clusterCore";
		HttpSolrServer server = new HttpSolrServer(baseURL);
		try {
			//按照id字段的编号来删除对应的索引文件
			server.deleteById("1");

			server.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
