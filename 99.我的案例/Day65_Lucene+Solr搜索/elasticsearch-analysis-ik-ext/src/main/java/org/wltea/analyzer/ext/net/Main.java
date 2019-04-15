package org.wltea.analyzer.ext.net;

import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			NetServer netServer = new NetServer(9999);
			new Thread(netServer).start();
			Runtime.getRuntime().addShutdownHook(new ShutdownServer(netServer));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(10000l);
		} catch (InterruptedException e) {
		}
	}

	static class ShutdownServer extends Thread {

		NetServer netServer;

		public ShutdownServer(NetServer netServer) {
			this.netServer = netServer;
		}

		@Override
		public void run() {
			netServer.stopServer();
		}

	}

}
