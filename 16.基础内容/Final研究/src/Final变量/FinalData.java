package Final����;
/**
 * ������������Զ����Լ��İ취���߱�����ĳ�������ǡ���������������ҪӦ���������������棺
(1) �����ڳ���������Զ����ı�
(2) �������ڳ�ʼ����һ��ֵ�����ǲ�ϣ���������仯
���ڱ����ڵĳ����������������򣩿ɽ�����ֵ����װ������Ҫ�ļ�������Ҳ����˵��������ڱ�����
����ǰִ�У��Ӷ���ʡ����ʱ��һЩ��������Java �У���Щ��ʽ�ĳ����������ڻ�����������
��Primitives��������Ҫ��final �ؼ��ֽ��б��ڶ�������һ���������ж����ʱ�򣬱������һ��ֵ��
����static ����final �ֶΣ���ֻ�ܴ洢һ�����ݣ����Ҳ��øı䡣
����ͬ������ʹ��final�������ǻ����������ͣ����ĺ������΢�����е���Ժ��ˡ����ڻ���������
�ͣ�final �Ὣֵ���һ�������������ڶ�������final �Ὣ������һ����������������ʱ�����뽫���
��ʼ����һ������Ķ��󡣶�����Զ���ܽ�������ָ����һ������Ȼ�����������ǿ����޸ĵġ�Java
�Դ�δ�ṩ�κ��ֶΣ��ɽ�һ������ֱ�ӱ��һ�����������ǣ����ǿ��Լ���дһ���࣬ʹ���еĶ������
��������Ч��������һ����Ҳ���������飬��Ҳ���ڶ���
 */
public class FinalData {
	// Can be compile-time constants
	/*
	 * ����i1 ��I2 ���Ǿ���final ���ԵĻ����������ͣ������б����ڵ�ֵ��
	 * �������ǳ�������Ϊ�����ڵĳ���ʹ���⣬���κε��뷽ʽ��Ҳ��������κβ�ͬ
	 */
	final int i1 = 9;
	static final int I2 = 99;
	
	
	
	// Typical public constant:
	/*
	 * I3 ������������ೣ������ʱ�����͵�һ�ַ�ʽ��public��ʾ���ǿ��ڰ���ʹ�ã�
	 * Static ǿ������ֻ��һ������final ��������һ��������
	 * ע����ں��й̶���ʼ��ֵ���������ڳ�������fianl static �����������ͣ�
	 * ���ǵ����ָ��ݹ���Ҫȫ�����ô�д��ҲҪע��i5 �ڱ����ڼ���δ֪�ģ�������û�д�д
	 */
	public static final int I3 = 39;
	
	
	
	// Cannot be compile-time constants:
	/*
	 * ��������ĳ��������������final�����϶�����ֵ���ڱ���ʱ��֪����
	 * i4 ��i5 ����֤������һ�㡣�����������ڼ�ʹ��������ɵ����֡�
	 * ���ӵ���һ����Ҳ���ҽ�ʾ����final ֵ��Ϊstatic �ͷ�static ֮��Ĳ��졣
	 * ֻ�е�ֵ�������ڼ��ʼ����ǰ���£����ֲ���Ż��ʾ������
	 * ��Ϊ�����ڼ��ֵ����������Ϊ����ͬ�ġ����ֲ���ɴ��������п�����
	 * fd1: i4 = 15, i5 = 9
     * Creating new FinalData
     * fd1: i4 = 15, i5 = 9
     * fd2: i4 = 10, i5 = 9
     * ע�����fd1 ��fd2 ��˵��i4 ��ֵ��Ψһ�ģ���i5 ��ֵ�������ڴ�������һ��FinalData ����������ı䡣
     * ������Ϊ����������static������������ʱ��ʼ��������ÿ����һ������ʱ��ʼ����
     * ��v1 ��v4 �ı��������ǽ�ʾ��final ����ĺ��塣��������main()�п�������������������Ϊ����v2
     * ����final�����ԾͲ����ٸı�����ֵ��Ȼ��������ȷʵ�����ٽ�v2 �󶨵�һ���¶�����Ϊ����������final��
     * �����final ����һ�������ȷ�к��塣���ǻᷢ��ͬ���ĺ��������������飬����ֻ��������һ�����͵ľ�����ѡ�
     * ��������final �������ƺ����罫�����������ͱ��final ��ô���á�
	 */
	final int i4 = (int) (Math.random() * 20);
	static final int i5 = (int) (Math.random() * 20);
	
	
	
	
	Value v1 = new Value();
	final Value v2 = new Value();
	static final Value v3 = new Value();
	// ! final Value v4; // Pre-Java 1.1 Error:
	// no initializer
	// Arrays:
	final int[] a = { 1, 2, 3, 4, 5, 6 };

	public void print(String id) {
		System.out.println(id + ": " + "i4 = " + i4 + ", i5 = " + i5);
	}

	public static void main(String[] args) {
		FinalData fd1 = new FinalData();
		// ! fd1.i1++; // Error: can't change value
		fd1.v2.i++; // Object isn't constant!
		fd1.v1 = new Value(); // OK -- not final
		for (int i = 0; i < fd1.a.length; i++)
			fd1.a[i]++; // Object isn't constant!
		// ! fd1.v2 = new Value(); // Error: Can't
		// ! fd1.v3 = new Value(); // change handle
		// ! fd1.a = new int[3];
		fd1.print("fd1");
		System.out.println("Creating new FinalData");

		FinalData fd2 = new FinalData();
		fd1.print("fd1");
		fd2.print("fd2");
	}
}

class Value {
	int i = 1;
}