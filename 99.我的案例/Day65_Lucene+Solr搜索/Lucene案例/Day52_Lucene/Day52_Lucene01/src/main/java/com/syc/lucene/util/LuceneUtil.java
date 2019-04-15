package com.syc.lucene.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * Lucene工具类
 * 
 * @创建人:一一哥
 */
public class LuceneUtil {

	private static Directory directory;
	private static Version version;
	private static Analyzer analyzer;

	private LuceneUtil() {
	}

	static {
		try {
			directory = FSDirectory.open(new File("E:/lucene"));
			version = Version.LUCENE_4_10_3;
			analyzer = new StandardAnalyzer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取IndexWriter对象
	 */
	public static IndexWriter createIndexWriter() throws IOException {
		IndexWriterConfig config = new IndexWriterConfig(getVersion(), getAnalyzer());
		return new IndexWriter(getDirectory(), config);
	}

	/**
	 * 获取IndexSearcher对象
	 */
	public static IndexSearcher createIndexSearcher() throws IOException {
		DirectoryReader reader = DirectoryReader.open(getDirectory());
		return new IndexSearcher(reader);
	}

	/**
	 * 将JavaBean里的信息,封装进Document对象中.
	 */
	public static Document bean2Document(Object obj) throws Exception {
		Document doc = new Document();
		Class<? extends Object> clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String fieldName = field.getName();
			// fieldName=content
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			// doc.add(new TextField(fieldName, msg.getContent(),
			// Store.YES));
			Method method = clazz.getDeclaredMethod(methodName);
			method.setAccessible(true);
			Object invoke = method.invoke(obj);
			if (invoke != null) {
				String value = invoke.toString();
				// 将JavaBean中的信息,封装进Document对象中
				doc.add(new TextField(fieldName, value, Store.YES));
			}

		}
		return doc;
	}

	/**
	 * 将Document对象转换为JavaBean
	 */
	public static Object document2Bean(Document document, Class<? extends Object> clazz) throws Exception {
		Object obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String name = field.getName();
			String value = document.get(name);
			// 给obj赋值
			BeanUtils.setProperty(obj, name, value);
		}
		return obj;
	}

	public static Directory getDirectory() {
		return directory;
	}

	public static Version getVersion() {
		return version;
	}

	public static Analyzer getAnalyzer() {
		return analyzer;
	}

}
