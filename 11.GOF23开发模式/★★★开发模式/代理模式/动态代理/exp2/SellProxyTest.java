package ��̬����.exp2;

import java.lang.reflect.Proxy;

public class SellProxyTest {
	public static void main(String[] args) {
		//�������������
		SellImpProxy sellImpProxy = new SellImpProxy();
		//���������������
		SellImp sellImp = new SellImp();
		sellImpProxy.setSellImp(sellImp);
		/*
		 *�����������ķ���:Sell.class.getClassLoader()
		 *��ȡ�ӿڵĽӿ�����:Sell.class.getInterfaces()
		 */
		Sell sell = (Sell)Proxy.newProxyInstance(Sell.class.getClassLoader(), Sell.class.getInterfaces(),sellImpProxy);
	System.out.println(sell);
	}
}
