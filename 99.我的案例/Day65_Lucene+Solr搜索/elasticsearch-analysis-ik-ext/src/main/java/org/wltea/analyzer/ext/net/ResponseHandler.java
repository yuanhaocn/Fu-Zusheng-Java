package org.wltea.analyzer.ext.net;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 响应
 * 
 * @author wy
 * @version v 0.1 2014-5-7 上午12:14:53 wy Exp $
 */
public class ResponseHandler implements Runnable {

	private Socket socket;
	private BufferedReader in;
	private DataOutputStream out;

	public ResponseHandler(Socket s) throws IOException {
		socket = s;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
	}

	@Override
	public void run() {
		try {
			String line = in.readLine();
			if (line != null) {
				out.write((line + "\n").getBytes("US-ASCII"));
			}
			out.flush();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
