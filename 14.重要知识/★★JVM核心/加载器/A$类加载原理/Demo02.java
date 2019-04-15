package A$类加载原理;

public class Demo02 {

	public static void main(String[] args) {
		//这些都没必要更改
		System.out.println(ClassLoader.getSystemClassLoader());//获得应用类加载器
		System.out.println(ClassLoader.getSystemClassLoader().getParent());//扩展类加载器
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());//引导类加载器，获取不到
	
		System.out.println(System.getProperty("java.class.path"));//目前我们这个程序的class.path--->结果说明这个项目的bin目录是这个程序的class.path
		
	}

}
