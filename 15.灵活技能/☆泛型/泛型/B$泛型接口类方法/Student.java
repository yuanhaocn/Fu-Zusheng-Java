package B$���ͽӿ��෽��;
/**
�����ࣺ������ʱʹ�÷��ͣ��ֽ������﷨��
   class ����<��ĸ�б�>{
   		���η� ��ĸ ���ԣ�
   		���η� ���������β��б�{
   	}
   		���η� �������� �������β��б�{
   	}
   }
    
 * ���ͳ�����ĸ��
 	* -T Type ��ʾ����
 	* -K V�ֱ��ʾ��ֵ���е�Key,Value
 	* -E ����Element
 	* -? ��ʾ��ȷ��������
 *  --��������ʱ��ĸ����ʹ���ھ�̬���ԣ���̬������
 *  ʹ��ʱָ���������� 
 		*   a:����ʱ��������ͼ�飻
 		*   b:��ȡ�����ǲ���Ҫǿ������ת��
 *  --����ʹ��ʱ����ָ���������ͣ�����ʹ�û������͡�
 */
public class Student<T1,T2> {		//���ٸ���ĸû������	
	private T1 javaScore;
	private T2 oracleScore;
	
	public T1 getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(T1 javaScore) {
		this.javaScore = javaScore;
	}
	public T2 getOracleScore() {
		return oracleScore;
	}
	public void setOracleScore(T2 oracleScore) {
		this.oracleScore = oracleScore;
	}
	
	@Override
	public String toString() {
		return "Student [javaScore=" + javaScore + ", oracleScore=" + oracleScore + "]";
	}
	public static void main(String[]  args) {
		//������ʹ��ʱָ������
		Student<String,Integer> stu = new Student<String,Integer>();
		//1����ȫ�����ͼ��
		stu.setJavaScore("����");
		//2��ʡ�ģ�����ת��
	//	Integer it = stu.getOracleScore();
		int it = stu.getOracleScore(); //ʹ��int Ҳ�У��Զ�����
		
	}
}
