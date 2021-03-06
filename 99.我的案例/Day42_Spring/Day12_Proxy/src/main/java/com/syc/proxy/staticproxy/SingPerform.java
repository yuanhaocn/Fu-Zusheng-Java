package com.syc.proxy.staticproxy;

/**
 * 目标对象+代理对象.
 * 在该案例中,抽取出歌星与经纪人共同的任务:开演唱会!
 * 所以我们在该案例中抽取出一个接口,这个接口是两者之间交流的通道.
 * 静态代理的特点:
 * 两个类实现了同一个接口!
 * 优点:静态代理可以在不用修改目标对象功能的前提下,可以很灵活的扩展目标对象的功能!
 * 缺点:因为目标对象和代理对象都必须实现同一个接口,所以此时如果该接口一旦发生改变,两者都必须同时做出修改!
 * 动态代理可以解决该问题!
 */
public interface SingPerform {

	//演唱会
	public void sing();
	
}
