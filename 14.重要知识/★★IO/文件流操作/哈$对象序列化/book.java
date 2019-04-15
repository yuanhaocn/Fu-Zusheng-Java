package ��$�������л�;
/**
 * �Ѷ���浽�ļ�����---��ObjectOutputStream
 * ���԰����л�֮��Ķ��󣬴洢���ļ����棬��֤���ݵĳ־û�
 * �־û������ڴ��ϵ����ݴ洢��Ӳ���ϣ�������ݴ��׶�ʧ�������״̬
 * �ڴ棬�ϵ缴��ʧ
 *
 *���л������ͷ����л�
 *��ר����java��ָ���ǰ��߼��ĸ�������Ի�
 *����洢�ڶ����棬����һ����ά�ռ䣬���¶����������߼��ṹ
 *IO��һ�����ԵĽṹ���ײ�ֻ����һ������һ������ĸ�������
 *��˰Ѷ������Ի��Ĺ��̳�Ϊ��������л�
 *�����л���ָ��ϵ�л�֮��Ķ���ԭΪ��ά�Ľṹ�Ĺ���
 *
 *java�е����л�����--
 *
 *
 *�������еČ��󶼿������л�  java.io.NotSerializableException
 * �������еČ��Զ���Ҫ���л�  transient
 */
import java.io.Serializable;

public class book implements Serializable{
	private Integer number;
	private String name;
	//��Ϊ�����ԵĻ��ԣ������л���ʱ�򲻲������л����̣���ʱ�����ͨ��ObjectInputStream��ȡ���ùؼ���
	//���ε����Ի�չʾ�����Ե�Ĭ��ֵ��
	private transient Double price;
	private String author;
	
	public book() {
		super();
	}
	public book(Integer number, String name, Double price, String author) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.author = author;
	}
	public Integer getNumber() {return number;}
	public void setNumber(Integer number) {this.number = number;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Double getPrice() {return price;}
	public void setPrice(Double price) {this.price = price;}
	public String getAuthor() {return author;}
	public void setAuthor(String author) {this.author = author;}
	@Override
	public String toString() {
		return "book [number=" + number + ", name=" + name + ", price=" + price + ", author=" + author + "]";
	}
	
}
