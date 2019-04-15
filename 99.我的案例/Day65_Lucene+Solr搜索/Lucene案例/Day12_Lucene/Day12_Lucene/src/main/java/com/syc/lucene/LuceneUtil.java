package com.syc.lucene;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

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
			//analyzer = new IKAnalyzer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static IndexWriter createIndexWriter() {
		try {
			IndexWriterConfig conf = new IndexWriterConfig(getVersion(), getAnalyzer());
			return new IndexWriter(getDirectory(), conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static IndexSearcher createIndexSearcher() {
		try {
			IndexReader reader = DirectoryReader.open(getDirectory());
			return new IndexSearcher(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Bean--->Document
	 */
	public static Document bean2Document(Object bean) {
		try {
			Document document = new Document();
			Class<? extends Object> clazz = bean.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				// id,name,desc
				String fieldName = field.getName();

				String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
				// Method method = clazz.getDeclaredMethod("getDesc");
				Method method = clazz.getDeclaredMethod(methodName);
				method.setAccessible(true);
				Object invoke = method.invoke(bean);
				if (invoke != null) {
					// doc.add(new TextField("name", product.getName(),
					// Store.YES));
					String value = invoke.toString();
					document.add(new TextField(fieldName, value, Store.YES));
				}
			}
			return document;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Document---->Bean
	 */
	public static Object document2Bean(Document document, Class<? extends Object> clazz) {
		try {
			Object bean = clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String name = field.getName();
				String value = document.get(name);
				BeanUtils.setProperty(bean, name, value);
			}

			return bean;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
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
