package ��̬����.Static;

public class SellTest {
	public static void main(String[] args) {
		SellImp sellImp = new SellImp();
		//��־��¼
		SellImpSuper.logStart();
		sellImp.saleNewHouse();
		SellImpSuper.logEnd();
	}
}
