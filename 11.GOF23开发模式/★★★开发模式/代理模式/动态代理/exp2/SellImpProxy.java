package ��̬����.exp2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SellImpProxy implements InvocationHandler {
	// �������������
	private SellImp sellImp;

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 1.������־����
		System.out.println("��ʼ��־����������");
		// 2.ִ�к���ҵ���߼�
		Object invoke = method.invoke(sellImp, args);

		// 2.������־����
		System.err.println("������־����������");
		return invoke;
	}

	public SellImp getSellImp() {
		return sellImp;
	}

	public void setSellImp(SellImp sellImp) {
		this.sellImp = sellImp;
	}

}
