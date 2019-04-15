package 静态代理.exp1;
//2，代理角色--->代理class忙前忙后需要持有真实角色的引用

public class WeddingCompany implements Marry{
	private You you;
	public WeddingCompany() {
	}

	
	public WeddingCompany(You you) {
		super();
		this.you = you;
	}


	private void befor() {
		System.out.println("布置婚房。。。");
	}
	private void after() {
		System.out.println("闹洞房。。。");
	}
	@Override
	public void marry() {
		befor();//<<---代理给你忙前
		you.marry();
		after();//《---代理给你忙后
	}
}
