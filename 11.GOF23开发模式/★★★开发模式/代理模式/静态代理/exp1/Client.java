package ��̬����.exp1;
/**
 * ��̬���� ���ģʽ(�����ʱ����һ����̬����ʵ�ֵĹ���һ��)
 * 1.��ʵ��ɫ
 * 2�������ɫ��������ʵ��ɫ������
 * 3������Ҫʵ����ͬ�Ľӿڣ��Ѷ�����ϵ��һ��
 * @author FZS
 *
 */
public class Client {

	public static void main(String[] args) {
		//���ȴ�����ʵ��ɫ
		You you = new You();
		//���������ɫ+������ʵ��ɫ������
		WeddingCompany company = new WeddingCompany(you);
		company.marry();
	}
}