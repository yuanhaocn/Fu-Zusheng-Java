package com.syc.load;

import java.io.Closeable;
import java.io.IOException;

public class IOUtil {

	public static void close(Closeable io) {
		if (io != null) {
			try {
				io.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
