package C$�ļ������Զ����������;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *�Զ�������������� 
 *	ʹ�ã�����һ�������ַ��ͨ����ַ���һ������������ȡ�ֽ���ת����������м���
 *
 */
public class NetClassLoader extends ClassLoader {
	private String rootUrl;//ָ����һ��url���൱��www.sxt.cn/myjava

	public NetClassLoader(String rootDir) {
		this.rootUrl = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//1.����findLoadedClass()����,�����Ѽ��ص��࣬�����Ƿ��Ѿ���������
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
 */
	private byte[] getClassData(String classname) {
		String path=rootUrl+"/"+classname.replace('.', '/')+".class";//ƴ��d:/myjva/com.bjsxt.test.User.class�ļ���
		//ͨ���������ļ�תΪ�ֽ�����
		//IOUtils.����ʹ���������е�����תΪ�ֽ�����
		InputStream is=null;
	//�ֽ���������������һ���ֽ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			
			URL url = new URL(path);
			 is = url.openStream();
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
