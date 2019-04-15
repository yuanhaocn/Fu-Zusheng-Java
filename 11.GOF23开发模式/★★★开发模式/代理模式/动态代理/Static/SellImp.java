package 动态代理.Static;

public class SellImp implements Sell{

	@Override
	public void saleNewHouse() {
		System.out.println("我在卖新房。。。。");
	}

	@Override
	public void saleOldHouse() {
		System.out.println("我在卖二手房。。。。");
	}

	@Override
	public void leaseHouse() {
		System.out.println("我在出租房屋。。。。");
	}

}
