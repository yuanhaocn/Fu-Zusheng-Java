package D$加密解密类加载器;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *正常是一个class文件被应用类加载器加载
 *现在给class文件加密，编程另一个class文件，再由另一个解密的类加载器	加载解密 
 * 
 * 加载文件系统中加密后的class字节码的类加载器
 * 解密
 */
public class DecriptClassLoader extends ClassLoader {

	private String rootDir;//指定的一个目录  ，相当于d:/myjava

	public DecriptClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}
@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//1.调用findLoadedClass()方法,查找已加载的类，看看是否已经被加载了
		Class<?> c = findLoadedClass(name);//类型不确定，所以可以不写
		 
		if(c!=null) {
			return c;//应该要查询有没有加载过这个类，如果已经加载了，直接返回加载好的类，如果没有，则加载类
		}else {
			try {
			//如果为空，则要他的父类去加载
			ClassLoader parent = this.getParent();
			c=parent.loadClass(name);
			}catch(Exception e){
			//嘿嘿，这个部分是这样的，因为双亲委托，所以先给父类加载，也就是应用类加载器，但是它加载不到，所以就抛异常了，（他以为下面没有自定义加载器了）
			//我们保持这种机制，但是catch中什么都不做，这样程序依旧可以往下走
			}
			
			if(c!=null) {
				return c;
			}else {
				//如果还是为空，则要读取给定的rootDir路径下面的文件，转换成一个字节数组
				//额外定义一个方法，把name传进去，得到一个字节数组，在做判断
				byte[] classData=getClassData(name);
				if(classData==null) {
					throw new ClassNotFoundException();//返回的字节数组为空，则没找到，，手动抛出异常
				}else {
					c=defineClass(name, classData, 0,classData.length); //数组有元素的话就定义这个类
				}
			}
		}
		return c;
	}
/*
 * classname:d:/myjava
 * 找到d:/myjva/com.bjsxt.test.User.class这样的路径
 */
	private byte[] getClassData(String classname) {
		String path=rootDir+"/"+classname.replace('.', '/')+".class";//拼出d:/myjva/com.bjsxt.test.User.class文件名
		//通过操作把文件转为字节数组
		//IOUtils.可以使用它将流中的数据转为字节数组
		InputStream is=null;
	//字节输出流，用来输出一个字节数组
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			 is = new FileInputStream(path);
			 //密文取反解密
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
