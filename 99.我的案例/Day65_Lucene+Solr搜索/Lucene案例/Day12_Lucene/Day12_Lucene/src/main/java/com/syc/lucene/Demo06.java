package com.syc.lucene;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 分词器的使用
 * 
 * @创建人:一一哥
 * @创建时间:2018年4月24日 上午9:49:58
 */
public class Demo06 {

	private static void getAnalyzer(Analyzer analyzer,String msg) throws IOException{
		System.out.println("当前分词器="+analyzer.getClass());
		TokenStream tokenStream = analyzer.tokenStream("desc", new StringReader(msg));
		//对TokenStream添加属性设置.
		CharTermAttribute termAttribute = tokenStream.addAttribute(CharTermAttribute.class);
		//重置之前的设置
		tokenStream.reset();
		while(tokenStream.incrementToken()){
			//是否有下一个字符
			System.out.println(termAttribute.toString());
		}
	}
	
	public static void main(String[] args) {
		try {
			//getAnalyzer(new StandardAnalyzer(),"今天没有下雨,挺凉快的");
			//分词器内部,会根据自带的停用词设置,过滤掉无用的停用词.
			//getAnalyzer(new StandardAnalyzer(),"When a couple gets married, it is natural for them to receive wishes from relatives and friends.");
			//getAnalyzer(new ChineseAnalyzer(),"今天没有下雨,挺凉快的");
			//getAnalyzer(new FrenchAnalyzer(),"今天没有下雨,挺凉快的");
			//getAnalyzer(new IKAnalyzer(),"今天下雨了,挺凉快的,心里面也不烦了");
			getAnalyzer(new IKAnalyzer(),"今年国家对房地产的政策是房住不炒,但是每个卵用,真是日了狗了");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
