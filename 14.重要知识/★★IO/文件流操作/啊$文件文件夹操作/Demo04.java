package ��$�ļ��ļ��в���;

import java.io.File;
import java.io.FilenameFilter;
/**
 * 5������Ŀ¼
 *mkdir() ����Ŀ¼������ȷ����Ŀ¼���ڣ���������ڣ�����ʧ��
 *mkdirs() ����Ŀ¼�������Ŀ¼��������һͬ����
 *list() �ļ�|Ŀ¼ ���ַ�����ʽ
 *listFiles()
 *static listRoots() ��·��
 * @author FZS
 *
 */
public class Demo04 {

	public static void main(String[] args) {
		String path ="C:\\Users\\FZS\\Pictures\\test";
		File src = new File(path);
		if(src.isDirectory()) {
			System.out.println("=====��Ŀ¼|���ļ���====");
			String[] subNames = src.list();		//�ַ�����������ļ���������ļ���
			for(String temp:subNames) {		//��ǿforѭ��
				System.out.println(temp);
			}
			System.out.println("====��Ŀ¼|���ļ���File����====");
			File[] subFiles = src.listFiles();
			for(File temp:subFiles) {
				System.out.println(temp.getAbsolutePath());
			}
			System.out.println("====���ļ�|.java����=======");		//�����һ���ļ��У��Ͱ������java�ļ������
//*******************************�ص㣡��********************************************//
			//�������ģʽ	������)													//
			subFiles = src.listFiles(new FilenameFilter() {							//<---------------------------------------------------------|
																					//														    |
				@Override															//															|
				/*Dir����src															//															|
				 *��д���˹���														//															|
				 */																	//															|
				public boolean accept(File dir, String name) {						//															|
					System.out.println(dir.getName());								//															|		
					return new File(dir,name).isFile() && name.endsWith(".java");	//��һ���ʾ���ļ�����java�ļ�								|
				}																	//															|
																					//															|	
			});																		//<---------------------------------------------------------|
			for(File temp:subFiles) {												//
				System.out.println(temp.getAbsolutePath());							//
			}																		//
//**********************************************************************************//			
		}
		
	}
	public static void test1() {
		String path ="C:\\Users\\FZS\\Pictures\\test";
		File src = new File(path);	//���File����ʹ�ļ���Ҳ�������ļ���
		src.mkdirs();	
	}
}
