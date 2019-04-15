package com.syc.lucene.demo;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 分词器介绍
 * 
 * @创建人:一一哥
 */
public class Demo01 {

	//利用当前分词器进行分词,并打印出分词内容
	private static void analyzerUse(Analyzer analyzer, String msg) {
		try {
			System.out.println("当前分词器:" + analyzer.getClass());
			TokenStream stream = analyzer.tokenStream("content", new StringReader(msg));
			//CharTermAttribute:里面包含了每一个分词的内容
			CharTermAttribute attribute = stream.addAttribute(CharTermAttribute.class);
			stream.reset();
			while(stream.incrementToken()){//判断是否还有下一个分词.
				System.out.println(attribute.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//英文中:that,to,with,the,of,is,are....都属于"停用词".默认的标准分词器会自动过滤掉这些停用词.
		//analyzerUse(new StandardAnalyzer(), "We all know that rumor goes very fast from person to person. With the development of Internet");
		//analyzerUse(new StandardAnalyzer(), "今年的雪怎么都跑到了南方来了呢,哈哈.日了狗了");
		//analyzerUse(new FrenchAnalyzer(), "今年的雪怎么都跑到了南方来了呢,哈哈.日了狗了");
		//analyzerUse(new RussianAnalyzer(), "今年的雪怎么都跑到了南方来了呢,哈哈.日了狗了");
		//analyzerUse(new ChineseAnalyzer(), "今年的雪怎么都跑到了南方来了呢,哈哈.日了狗了");
		//analyzerUse(new CJKAnalyzer(), "今年的雪怎么都跑到了南方来了呢,哈哈.日了狗了");
		//加载中文分词器.
		analyzerUse(new IKAnalyzer(), "今年的雪怎么都跑到了南方来了呢,哈哈.日了狗了");
	}
}
