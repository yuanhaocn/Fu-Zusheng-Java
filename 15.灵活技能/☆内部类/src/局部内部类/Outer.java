package �ֲ��ڲ���;

/**
 * �ֲ��ڲ��� λ�ڷ����ڲ����壬�;ֲ�����ƽ��
 * 
 * @author FZS
 *
 */
public class Outer {
	private String name = "����.ͼ��";

	// ����
	//����ֵ��������ת�Ͷ�������
	public InnerHelp getInnerObject() {
		// ����ֲ��ڲ���
		class Inner implements InnerHelp {
			// �ڲ����Լ�������
			private int age = 12;
			// �ڲ����Լ��ķ���
			public void show() {
				System.out.println(name + "����" + age + "���ˡ�����");
			}
		}
		// ����Inner����
		return new Inner();
	}

}
