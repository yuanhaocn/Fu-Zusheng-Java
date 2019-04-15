package 静态代理.exp1;
/**
 * 静态代理 设计模式(反射的时候还有一个动态代理，实现的功能一样)
 * 1.真实角色
 * 2，代理角色：持有真实角色的引用
 * 3，二者要实现相同的接口（把二者联系在一起）
 * @author FZS
 *
 */
public class Client {

	public static void main(String[] args) {
		//首先创建真实角色
		You you = new You();
		//创建代理角色+加入真实角色的引用
		WeddingCompany company = new WeddingCompany(you);
		company.marry();
	}
}