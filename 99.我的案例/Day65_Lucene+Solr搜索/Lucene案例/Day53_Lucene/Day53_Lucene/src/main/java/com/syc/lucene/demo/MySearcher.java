package com.syc.lucene.demo;

import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TermRangeQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.WildcardQuery;
import org.apache.lucene.util.BytesRef;

import com.syc.lucene.domain.Message;
import com.syc.lucene.util.LuceneUtil;

/**
 * 封装常用的查询方法
 * 
 * @创建人:一一哥
 */
public class MySearcher {

	/**
	 * 普通的查询方法
	 */
	public void search(String field, String keyword) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();
			QueryParser parser = new QueryParser(field, LuceneUtil.getAnalyzer());
			Query query = parser.parse(keyword);
			// return searcher.search(query, 100);
			TopDocs topDocs = searcher.search(query, 100);

			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 精确查询
	 */
	public void searchByTerm(String field, String value) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			// 根据某个Term来进行精确查找!
			Query query = new TermQuery(new Term(field, value));
			TopDocs topDocs = searcher.search(query, 100);

			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按某个范围来查询
	 */
	public void searchByTermRange(String field, String lower, String upper) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			// 限定范围
			BytesRef lowerTerm = new BytesRef(lower);
			BytesRef upperTerm = new BytesRef(upper);
			// true:表示包含边界.
			Query query = new TermRangeQuery(field, lowerTerm, upperTerm, true, true);

			TopDocs topDocs = searcher.search(query, 100);

			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 前缀查询
	 */
	public void searchByPrefix(String field, String value) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			// 前缀查询
			Query query = new PrefixQuery(new Term(field, value));

			TopDocs topDocs = searcher.search(query, 100);

			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按通配符查询. ?:表示任意一个字符; *:表示任意多个字符.
	 */
	public void searchByWildcard(String field, String value) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			// 通配符查询
			Query query = new WildcardQuery(new Term(field, value));

			TopDocs topDocs = searcher.search(query, 100);

			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 多条件查询的情况
	 */
	public void searchByBoolean() {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			// 条件查询
			BooleanQuery query = new BooleanQuery();
			// MUST:相当于sql中的and关键字,必须满足这个条件title="手机".
			query.add(new TermQuery(new Term("id", "1")), Occur.MUST);
			// SHOULD:不一定要满足该条件
			query.add(new TermQuery(new Term("title", "phone")), Occur.SHOULD);

			TopDocs topDocs = searcher.search(query, 100);

			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 短语查询(真针对英文有效!)
	 */
	public void searchByPhrase(String field, String value) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			PhraseQuery query = new PhraseQuery();
			// 设置要跳过的单词的数量.
			query.setSlop(1);
			query.add(new Term(field, value));

			TopDocs topDocs = searcher.search(query, 100);

			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 模糊查询(真针对英文有效!)
	 */
	public void searchByFuzzy(String field, String value) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			FuzzyQuery query = new FuzzyQuery(new Term(field, value));

			TopDocs topDocs = searcher.search(query, 100);

			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				Document doc = searcher.doc(scoreDoc.doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 普通的分页查询.
	 * Lucene3.5之前提供了两种分页的方法:
	 * 1.将首次搜索获得的多页搜索结果收集起来并保存在ScoreDocs和IndexSearcher实例中,并在用户换页浏览时展现这几页的结果;
     * 2.每次用户换页浏览时都重新进行查询操作。
	 */
	public void searchByPage(String field, String keyword, int pageNum, int pageSize) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			QueryParser parser = new QueryParser(field, LuceneUtil.getAnalyzer());
			Query query = parser.parse(keyword);

			TopDocs topDocs = searcher.search(query, 100);
			// 对查询到的结果进行分页

			// 总条数100条,每页10条---->100/10=10;
			// 总条数101条,每页10条---->100/10 +1 =11;

			if (pageNum > 0) {
				// limit start,size
				int start = (pageNum - 1) * pageSize;
				int end = pageNum * pageSize;
				System.out.println("start=" + start + ",end=" + end);
				for (int i = start; i < end; i++) {
					ScoreDoc scoreDoc = topDocs.scoreDocs[i];
					Document doc = searcher.doc(scoreDoc.doc);
					Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
					System.out.println("msg=" + msg.toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 按这两个方法是可以做出分页的,只是效果及性能影响大小而已!
	 * Lucene 3.5 之后加入IndexSearcher.searchAfter方法,它在特定的ScoreDoc之后会返回结果。
	 * 你可以将上一页的最后一个document传递给searchAfter方法,以得到下一页的结果。
	 */
	// 获取前一页的查询结果
	public ScoreDoc getPreScoreDoc(int pageNum, int pageSize, Query query, IndexSearcher searcher) {
		try {
			if (pageNum == 1 || pageNum <= 0) {
				return null;
			} else {
				// 获取上一页的数量
				int num = pageSize * (pageNum - 1);
				TopDocs topDocs = searcher.search(query, num);
				return topDocs.scoreDocs[num - 1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 改进的分页查询
	 */
	public void searchByPage2(String field, String keyword, int pageNum, int pageSize) {
		try {
			IndexSearcher searcher = LuceneUtil.createIndexSearcher();

			QueryParser parser = new QueryParser(field, LuceneUtil.getAnalyzer());
			Query query = parser.parse(keyword);

			//获取上一页的最后一个Doc对象
			ScoreDoc scoreDoc = getPreScoreDoc(pageNum, pageSize, query, searcher);

			//将上一页的最后一个document传递给searchAfter方法,以得到下一页的结果。
			TopDocs topDocs = searcher.searchAfter(scoreDoc, query, pageSize);
			
			for (int i = 0; i < topDocs.scoreDocs.length; i++) {
				Document doc = searcher.doc(topDocs.scoreDocs[i].doc);
				Message msg = (Message) LuceneUtil.document2Bean(doc, Message.class);
				System.out.println("msg=" + msg.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
