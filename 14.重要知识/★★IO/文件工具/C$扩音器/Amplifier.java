package C$������;
/**
 * ������
 * ������֮��Ĺ�ϵ
 	* 1������:�β�|�ֲ�����
 	* 2������:����
 	* 	       �ۺ�:���� �����벿�� ��һ�µ��������� ������
 	*      ���:���� �����벿�� һ�µ���������  �������
 	* 3���̳�:�������ϵ
 	* 4��ʵ��: �ӿ���ʵ�����ϵ
 */
public class Amplifier {
	private Voice voice;
	public void say(){System.out.println(voice.getVoice()*1000);}
	
	public static void main(String[] args) {
		Voice v =new Voice();
		v.say();
		Amplifier am =new Amplifier(v);
		am.say();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Amplifier() {}
	public Amplifier(Voice voice) {super();this.voice = voice;}	
	
}
