package ��Ա�ڲ���;

import ��Ա�ڲ���.Outer.Inner;

/**
 * ��������
 * 
 * @author FZS
 *
 */
public class Test {
	public static void main(String[] args) {
		Outer outer = new Outer();				//1�������ⲿ�����
		Outer.Inner inner = outer.new Inner();	//2��ʹ���ⲿ����󹹽��ڲ������
		inner.show();							//3.����
		
//**********************************************************
		//*�����������
		Inner inner2 = outer.new Inner();
		//Outer.Inner inner = new Outer().new Inner();
//**********************************************************
		
	}
}
