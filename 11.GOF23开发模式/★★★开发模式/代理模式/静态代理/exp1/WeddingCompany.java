package ��̬����.exp1;
//2�������ɫ--->����classæǰæ����Ҫ������ʵ��ɫ������

public class WeddingCompany implements Marry{
	private You you;
	public WeddingCompany() {
	}

	
	public WeddingCompany(You you) {
		super();
		this.you = you;
	}


	private void befor() {
		System.out.println("���û鷿������");
	}
	private void after() {
		System.out.println("�ֶ���������");
	}
	@Override
	public void marry() {
		befor();//<<---�������æǰ
		you.marry();
		after();//��---�������æ��
	}
}
