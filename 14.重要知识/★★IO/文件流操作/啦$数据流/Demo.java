package ��$������;

import java.io.BufferedReader;
import java.io.FileReader;

class Demo{
	public static void main(String[] args){
		
		byte[] bytes = new byte[1024];
		int capacity=0;
		
		try (FileReader fr = new FileReader("C:\\Users\\FZS\\Pictures\\����1.txt");
			BufferedReader br = new BufferedReader(fr);	){
			//����һ��ȥ��
			String str = "";
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
			
		} catch (Exception e) {e.printStackTrace();}
	
	}
}