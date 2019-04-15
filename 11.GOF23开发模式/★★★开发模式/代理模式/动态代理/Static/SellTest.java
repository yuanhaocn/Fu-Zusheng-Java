package 动态代理.Static;

public class SellTest {
	public static void main(String[] args) {
		SellImp sellImp = new SellImp();
		//日志记录
		SellImpSuper.logStart();
		sellImp.saleNewHouse();
		SellImpSuper.logEnd();
	}
}
