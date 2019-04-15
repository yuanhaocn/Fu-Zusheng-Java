package 动态代理.exp2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SellImpProxy implements InvocationHandler {
	// 构建被代理对象
	private SellImp sellImp;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 1.开启日志监听
		System.out.println("开始日志监听。。。");
		// 2.执行核心业务逻辑
		Object invoke = method.invoke(sellImp, args);

		// 2.结束日志监听
		System.err.println("结束日志监听。。。");
		return invoke;
	}

	public SellImp getSellImp() {
		return sellImp;
	}

	public void setSellImp(SellImp sellImp) {
		this.sellImp = sellImp;
	}

}
