package C$Thread方法之阻塞;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 3)sleep休眠，休眠的时候不会释放锁，常用于“模拟倒计时”，“模拟网络延迟”等与时间有关的
 * 倒计时
 * 1，倒数10个数，一秒打印一个
 *
 */
public class TestSleep {
	public static void main(String[] args) throws InterruptedException  {
		Date date = new Date(System.currentTimeMillis()+10*1000);
		long end = date.getTime();
		while(true) {
			//输出
			System.out.println(new SimpleDateFormat("mm:ss").format(date));
			//构建下一秒的时间
			date=new Date(date.getTime()-1000);
			//等待一秒
			Thread.sleep(1000);
			if(end-10000>date.getTime()) {
				break;
			}
		}
		
	}
	//倒计时
	public static void test() throws InterruptedException {
		int num =10;
		while(true) {
			System.out.println(num--);
			Thread.sleep(1000);	//在暂停
			if(num<=0) {
				break;
			}
		}
	}
}
