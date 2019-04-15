package org.wltea.analyzer.ext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashSet;
import java.util.Set;

import org.elasticsearch.common.logging.ESLogger;
import org.elasticsearch.common.logging.Loggers;
import org.wltea.analyzer.dic.Dictionary;

/**
 * 扫描词库变更服务
 * 
 * @author 王奕
 * 
 */
public class ExtDicScan {

	private final static ESLogger logger = Loggers.getLogger("ik-analyzer");

	private final static String words_file = "words.dic";

	private final static String stop_file = "stop.dic";

	private final static Set<String> last_load_stop_words = new HashSet<String>();

	private File dynamic;

	/**
	 * 
	 * @param dicRoot
	 */
	public ExtDicScan(File dicRoot) {
		File file = new File(dicRoot, "ik/dynamic");
		if (!file.exists()) {
			try {
				file.mkdirs();
			} catch (Exception e) {
				logger.error("ik-analyzer create ik dynamic folder error", e);
			}
		}
		this.dynamic = file;
		last_load_stop_words.addAll(getDics(stop_file));
		Set<String> dics = getDics(words_file);
		// 加载新增的
		Dictionary.getSingleton().addWords(dics);
		// 新加的词可能包含已经停用的，需要重新加载
		Dictionary.getSingleton().disableWords(last_load_stop_words);

	}

	public void addListener() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				doScan();
			}
		}, "dynamic_listener");
		thread.setDaemon(true);
		thread.start();
		logger.warn("ik-analyzer listener " + dynamic.getPath() + " ");
	}

	private void doScan() {
		WatchService watchService = null;
		try {
			watchService = FileSystems.getDefault().newWatchService();
			Paths.get(dynamic.toURI()).register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		} catch (IOException e) {
			logger.error("ik-analyzer create dynamic watchService error", e);
			return;
		}
		while (true) {
			try {
				WatchKey key = watchService.take();
				for (WatchEvent<?> event : key.pollEvents()) {
					String name = String.valueOf(event.context());
					if (words_file.equalsIgnoreCase(name)) {
						logger.warn("ik-analyzer modify " + name + " file...");
						Set<String> dics = getDics(name);
						logger.info("ik-analyzer success load words count:" + dics.size());
						// 加载新增的
						Dictionary.getSingleton().addWords(dics);
						// 新加的词可能包含已经停用的，需要重新加载
						Dictionary.getSingleton().disableWords(last_load_stop_words);

					} else if (stop_file.equalsIgnoreCase(name)) {
						logger.warn("ik-analyzer modify " + name + " file...");
						Set<String> dics = getDics(name);
						logger.info("ik-analyzer success load stop words count:" + dics.size());
						// 加载新增的
						Dictionary.getSingleton().disableWords(dics);
						last_load_stop_words.clear();
						last_load_stop_words.addAll(dics);
					}
				}
				if (!key.reset()) {
					break;
				}
			} catch (InterruptedException e) {
				logger.warn("ik-analyzer dynamic ext watch interrupted error", e);
			} catch (Exception e) {
				logger.warn("ik-analyzer dynamic ext error", e);
			}
		}
	}

	/**
	 * 加载词典
	 * 
	 * @param name
	 * @return
	 */
	private Set<String> getDics(String name) {
		File file = new File(dynamic, name);
		Set<String> dics = new HashSet<String>();
		if (!file.exists()) {
			return dics;
		}
		logger.warn("ik-analyzer load dynamic dic " + file.getPath() + "");
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			logger.error("ik-analyzer file " + name + " not exists", e);
		}
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"), 512);
			String theWord = null;
			do {
				theWord = br.readLine();
				if (theWord != null && !"".equals(theWord.trim())) {
					logger.info("load " + name + " word:" + theWord.trim());
					dics.add(theWord.toLowerCase().trim());
				}
			} while (theWord != null);

		} catch (IOException e) {
			logger.error("ik-analyzer read " + name + " error", e);

		} finally {
			try {
				if (is != null) {
					is.close();
					is = null;
				}
			} catch (IOException e) {

			}
		}
		return dics;
	}
}
