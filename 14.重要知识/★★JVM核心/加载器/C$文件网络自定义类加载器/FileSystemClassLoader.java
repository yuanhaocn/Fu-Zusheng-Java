package C$文件网络自定义类加载器;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 
 *  *自定义类加载器的流程
 *··继承：java.lang.ClassLoader
 *··首先检查请求的类型是否已经被这个类装载器装载到命名空间中了，如果已经装载，直接返回
 *··委派类加载请求给父类加载器，如果父类加载器能完成，则返回父类加载器加载到的Class实例
 *··调用本类加载器的findClass()方法，试图获得对应的字节码，如果获取的到，则调用defineClass()导入类型给方法区，如果获取不到对应的字节码
 *	或者其他原因失败，返回异常给loadClass(),loadClass()转跑一场，终止加载过程
 *
 *
 *注意：被两个类加载器加载的同一个类，JVM不认为是相同的类
 *
 *比如：在服务器上建立了不同的项目两个项目都有Demo01.class，每个项目都有自己的类加载器，所以他们会认为是不同的类
 *
 * 	文件类加载器
 * 	网络类加载器
 * 	加密解密类加载器（取反操作，DES对称加密解密）
 * ************************************************************************************************************************
 * 
 * 组合！组合！组合！各个类加载器的分层
 *自定义文件系统类加载器 
 *通过FileSystemClassLoader加载器希望传经来一个指定的目录，目录下面的class文件，然后能把这个class文件顺利的加载
 *比如传进来一个目录d:/myjava  再给一个com.bjsxt.test.User类的全类名
 *然后在d:/myjava目录下去找对应的d:/myjva/com.bjsxt.test.User.class 文件，找到之后通过IO流加载到内存里面
 *进入内存之后是以字节数组的形式存在，然后再调用ClassLoader的相关方法
 *
 */
public class FileSystemClassLoader extends ClassLoader {
	private String rootDir;//指定的一个目录  ，相当于d:/myjava

	public FileSystemClassLoader(String rootDir) {
		this.rootDir = rootDir;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		//1.调用findLoadedClass()方法,查找已加载的类，看看是否已经被加载了，因为已经被加载 了的类不会被重复加载
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
 *就是一个简单的IO流，用来把指定路径的.class文件读到数组里面再返回来
 */
	private byte[] getClassData(String classname) {
		String path=rootDir+"/"+classname.replace('.', '/')+".class";//拼出d:/myjva/com.bjsxt.test.User.class文件名
		//通过操作把文件转为字节数组
		//IOUtils.可以使用它将流中的数据转为字节数组
		FileInputStream is=null;
	//字节输出流，用来输出一个字节数组
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
