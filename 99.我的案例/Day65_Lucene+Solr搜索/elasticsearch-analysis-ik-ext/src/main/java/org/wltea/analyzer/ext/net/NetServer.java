package org.wltea.analyzer.ext.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetServer implements Runnable {

	private final ServerSocket serverSocket;
	private final ExecutorService threadPool;

	/**
	 * 
	 * @param port
	 * @throws IOException
	 */
	public NetServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		threadPool = Executors.newCachedThreadPool();
	}

	@Override
	public void run() {
		try {
			while (true) {
				threadPool.execute(new ResponseHandler(serverSocket.accept()));
			}

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		threadPool.shutdown();
		while (!threadPool.isTerminated()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		synchronized (this) {
			notifyAll();
		}
	}

	public void stopServer() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
