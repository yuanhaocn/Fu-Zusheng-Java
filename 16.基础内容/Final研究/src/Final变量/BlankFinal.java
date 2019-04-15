package Final����;
/**�հ�final
 * Java 1.1 �������Ǵ������հ�final������������һЩ������ֶΡ����ܱ�������final����ȴδ�õ�һ����ʼֵ��
 * ��������������£��հ�final ��������ʵ��ʹ��ǰ�õ���ȷ�ĳ�ʼ�������ұ�������������֤��һ�涨���Թ᳹��
 * Ȼ��������final �ؼ��ֵĸ���Ӧ�ã��հ�final ������������ԡ�
 * �ٸ�������˵��λ�����ڲ���һ��final �ֶ����ڶ�ÿ�����󶼿���������ͬ��ͬʱ��Ȼ�����䡰���䡱�ı��ʡ�
 * �����г�һ�����ӣ�
 * ����ǿ��Ҫ�����Ƕ�final ���и�ֵ������Ҫô�ڶ����ֶ�ʱʹ��һ����� ʽ��Ҫô��ÿ���������С�
 * �����Ϳ���ȷ��final �ֶ���ʹ��ǰ�����ȷ�ĳ�ʼ����
 */
class BlankFinal {
	final int i = 0; // Initialized final
	final int j; // Blank final
	final Poppet p; // Blank final handle
	// Blank finals MUST be initialized
	// in the constructor:
	BlankFinal() {
		j = 1; // Initialize blank final
		p = new Poppet();
	}
	BlankFinal(int x) {
		j = x; // Initialize blank final

		p = new Poppet();
	}
	public static void main(String[] args) {
		BlankFinal bf = new BlankFinal();
	}
}

class Poppet { }