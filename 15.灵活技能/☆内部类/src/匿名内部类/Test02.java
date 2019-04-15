package 匿名内部类;

public class Test02 {
	public static void main(String[] args) {
		new InnerHelp(){
			
			@Override
			public void show() {
				System.out.println("this is a china joy...");
			}
		}.show();
		
		new InnerHelp(){

			@Override
			public void show() {
				System.out.println("this is a china joy...");
			}
		}.show();
	}
}
