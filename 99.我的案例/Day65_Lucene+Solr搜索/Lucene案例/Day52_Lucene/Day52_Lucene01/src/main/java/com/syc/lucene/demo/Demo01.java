package com.syc.lucene.demo;

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

import com.syc.lucene.domain.Message;

/**
 * 创建Lucene索引库
 * 
 * @创建人:一一哥
 */
public class Demo01 {

	@Test
	public void createIndexTest(){
		try {
			//2.创建索引库所在文件夹.
			Directory directory = FSDirectory.open(new File("E:/lucene"));
			
			//分词器对象.
			Analyzer analyzer=new StandardAnalyzer();
			//3.对索引库做初始化设置
			IndexWriterConfig config=new IndexWriterConfig(Version.LUCENE_4_10_3, analyzer);
			//directory:索引库的位置;
			//config:对索引的基本配置对象.
			//1.创建IndexWriter对象.
			IndexWriter writer=new IndexWriter(directory, config);
			
			//5.创建出Document文档对象
			Document doc=new Document();
			//FIXME:真正的开发过程中,此处的JavaBean中的数据,应该来自于数据库查询的数据!
			Message msg=new Message(1, "军事", "美国要轰炸日本了");
			//TextField中3个参数的含义:1.每个索引的key的名称;2.索引的值;3.是否把该属性值存入到词汇表中.
			doc.add(new TextField("id", msg.getId().toString(), Store.YES));
			doc.add(new TextField("title", msg.getTitle(), Store.YES));
			doc.add(new TextField("content", msg.getContent(), Store.YES));
			
			//索引库(数据库):---->Document(表):--->Field(行):--->Term(列).
			//4.将Document对象添加到Lucene的索引库中.
			writer.addDocument(doc);
			
			//7.释放资源
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
