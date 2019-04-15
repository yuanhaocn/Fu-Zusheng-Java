package com.syc.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

/**
 * 创建索引库
 * 
 * @类名称:Demo01
 * @创建人:一一哥
 * @创建时间:2018年4月24日 上午9:49:58
 */
public class Demo01 {

	@Test
	public void createIndexTest() {
		try {
			//2.指定索引库的位置
			Directory directory = FSDirectory.open(new File("E:/lucene"));
			
			//3.默认的标准分词器(英文的)
			Analyzer analyzer=new StandardAnalyzer();
			IndexWriterConfig conf=new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
			
			//1.用来操作索引库的api.
			IndexWriter writer = new IndexWriter(directory, conf);
			
			//5.创建文档对象
			Document doc=new Document();
			
			//6.添加文档中的Field和Term
			Product product=new Product(2, "女孩子", "女孩子的心思.....");
			//Store.YES:是否把该属性值存储到索引库的词汇表中.
			doc.add(new TextField("id", product.getId().toString(), Store.YES));
			doc.add(new TextField("name", product.getName(), Store.YES));
			doc.add(new TextField("desc", product.getDesc(), Store.YES));
			
			//在索引库中添加Document对象
			//4.1个索引库(库)--->N个Document(表)--->N个Field(行)--->N个Term(列)
			writer.addDocument(doc);
			
			//7.释放资源
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
