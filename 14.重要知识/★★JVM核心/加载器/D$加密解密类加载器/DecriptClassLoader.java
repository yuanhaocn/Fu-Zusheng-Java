package D$���ܽ����������;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *������һ��class�ļ���Ӧ�������������
 *���ڸ�class�ļ����ܣ������һ��class�ļ���������һ�����ܵ��������	���ؽ��� 
 * 
 * �����ļ�ϵͳ�м��ܺ��class�ֽ�����������
 * ����
 */
public class DecriptClassLoader extends ClassLoader {

	private String rootDir;//ָ����һ��Ŀ¼  ���൱��d:/myjava

	public DecriptClassLoader(String rootDir) {
		this.rootDir = rootDir;
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
		String path=rootDir+"/"+classname.replace('.', '/')+".class";//ƴ��d:/myjva/com.bjsxt.test.User.class�ļ���
		//ͨ���������ļ�תΪ�ֽ�����
		//IOUtils.����ʹ���������е�����תΪ�ֽ�����
		InputStream is=null;
	//�ֽ���������������һ���ֽ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			 is = new FileInputStream(path);
			 //����ȡ������
			 int temp=-1;
			 while((temp=is.read())!=-1) {
				 baos.write(temp^0xff);
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
	}	
}
}
