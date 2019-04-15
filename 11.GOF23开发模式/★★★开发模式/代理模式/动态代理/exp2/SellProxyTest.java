package 动态代理.exp2;

import java.lang.reflect.Proxy;

public class SellProxyTest {
	public static void main(String[] args) {
		//构建代理类对象
		SellImpProxy sellImpProxy = new SellImpProxy();
		//构建被代理类对象
		SellImp sellImp = new SellImp();
		sellImpProxy.setSellImp(sellImp);
		/*
		 *获得类加载器的方法:Sell.class.getClassLoader()
		 *获取接口的接口数组:Sell.class.getInterfaces()
		 */
		Sell sell = (Sell)Proxy.newProxyInstance(Sell.class.getClassLoader(), Sell.class.getInterfaces(),sellImpProxy);
	System.out.println(sell);
	}
}
