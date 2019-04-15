package com.syc.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJCloudTest {

	/**
	 * 创建索引库
	 */
	@Test
	public void createIndexTest() {
		// 针对单机版的Solr服务
		// HttpSolrServer;

		// 集群版的Solr服务
		String zkHost = "10.11.51.2:8983,10.11.51.2:8984,10.11.51.2:8985";
		CloudSolrServer server = new CloudSolrServer(zkHost);
		// 设置默认的集合名称
		server.setDefaultCollection("techproducts");
		// 连接集群
		server.connect();

		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", 1);
		doc.addField("mname", "汽车");
		doc.addField("mdesc", "宝马汽车还是挺好的");

		try {
			server.add(doc);
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
		String zkHost = "10.11.51.2:8983,10.11.51.2:8984,10.11.51.2:8985";
		CloudSolrServer server = new CloudSolrServer(zkHost);
		server.setDefaultCollection("techproducts");
		server.connect();

		SolrQuery query = new SolrQuery();
		query.setQuery("汽车");
		try {
			QueryResponse response = server.query(query);
			SolrDocumentList list = response.getResults();
			for (SolrDocument doc : list) {
				System.out.println("name=" + doc.get("mname"));
			}

			server.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
