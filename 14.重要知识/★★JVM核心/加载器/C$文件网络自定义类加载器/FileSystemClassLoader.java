package C$�ļ������Զ����������;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 *  *�Զ����������������
 *�����̳У�java.lang.ClassLoader
 *�������ȼ������������Ƿ��Ѿ��������װ����װ�ص������ռ����ˣ�����Ѿ�װ�أ�ֱ�ӷ���
 *����ί���������������������������������������ɣ��򷵻ظ�����������ص���Classʵ��
 *�������ñ����������findClass()��������ͼ��ö�Ӧ���ֽ��룬�����ȡ�ĵ��������defineClass()�������͸��������������ȡ������Ӧ���ֽ���
 *	��������ԭ��ʧ�ܣ������쳣��loadClass(),loadClass()ת��һ������ֹ���ع���
 *
 *
 *ע�⣺����������������ص�ͬһ���࣬JVM����Ϊ����ͬ����
 *
 *���磺�ڷ������Ͻ����˲�ͬ����Ŀ������Ŀ����Demo01.class��ÿ����Ŀ�����Լ�������������������ǻ���Ϊ�ǲ�ͬ����
 *
 * 	�ļ��������
 * 	�����������
 * 	���ܽ������������ȡ��������DES�ԳƼ��ܽ��ܣ�
 * ************************************************************************************************************************
 * 
 * ��ϣ���ϣ���ϣ�������������ķֲ�
 *�Զ����ļ�ϵͳ������� 
 *ͨ��FileSystemClassLoader������ϣ��������һ��ָ����Ŀ¼��Ŀ¼�����class�ļ���Ȼ���ܰ����class�ļ�˳���ļ���
 *���紫����һ��Ŀ¼d:/myjava  �ٸ�һ��com.bjsxt.test.User���ȫ����
 *Ȼ����d:/myjavaĿ¼��ȥ�Ҷ�Ӧ��d:/myjva/com.bjsxt.test.User.class �ļ����ҵ�֮��ͨ��IO�����ص��ڴ�����
 *�����ڴ�֮�������ֽ��������ʽ���ڣ�Ȼ���ٵ���ClassLoader����ط���
 *
 */
public class FileSystemClassLoader extends ClassLoader {
	private String rootDir;//ָ����һ��Ŀ¼  ���൱��d:/myjava

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//1.����findLoadedClass()����,�����Ѽ��ص��࣬�����Ƿ��Ѿ��������ˣ���Ϊ�Ѿ������� �˵��಻�ᱻ�ظ�����
		Class<?> c = findLoadedClass(name);//���Ͳ�ȷ�������Կ��Բ�д
		 
		if(c!=null) {
			return c;//Ӧ��Ҫ��ѯ��û�м��ع�����࣬����Ѿ������ˣ�ֱ�ӷ��ؼ��غõ��࣬���û�У��������
		}else {
			try {
			//���Ϊ�գ���Ҫ���ĸ���ȥ����
			ClassLoader parent = this.getParent();
			c=parent.loadClass(name);
			}catch(Exception e){
			//�ٺ٣���������������ģ���Ϊ˫��ί�У������ȸ�������أ�Ҳ����Ӧ��������������������ز��������Ծ����쳣�ˣ�������Ϊ����û���Զ���������ˣ�
			//���Ǳ������ֻ��ƣ�����catch��ʲô�������������������ɿ���������
			}
			
			if(c!=null) {
				return c;
			}else {
				//�������Ϊ�գ���Ҫ��ȡ������rootDir·��������ļ���ת����һ���ֽ�����
				//���ⶨ��һ����������name����ȥ���õ�һ���ֽ����飬�����ж�
				byte[] classData=getClassData(name);
				if(classData==null) {
					throw new ClassNotFoundException();//���ص��ֽ�����Ϊ�գ���û�ҵ������ֶ��׳��쳣
				}else {
					c=defineClass(name, classData, 0,classData.length); //������Ԫ�صĻ��Ͷ��������
				}
			}
		}
		return c;
	}
/*
 * classname:d:/myjava
 * �ҵ�d:/myjva/com.bjsxt.test.User.class������·��
 *����һ���򵥵�IO����������ָ��·����.class�ļ��������������ٷ�����
 */
	private byte[] getClassData(String classname) {
		String path=rootDir+"/"+classname.replace('.', '/')+".class";//ƴ��d:/myjva/com.bjsxt.test.User.class�ļ���
		//ͨ���������ļ�תΪ�ֽ�����
		//IOUtils.����ʹ���������е�����תΪ�ֽ�����
		FileInputStream is=null;
	//�ֽ���������������һ���ֽ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			 is = new FileInputStream(path);
			byte[] buffer = new byte[1024];
			int temp =0;
			
			while((temp=is.read(buffer))!=-1) {
				baos.write(buffer, 0, temp);
			}
			
			return baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
		if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	
		}	}
	
}
