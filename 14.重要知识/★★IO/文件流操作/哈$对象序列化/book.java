package 哈$对象序列化;
/**
 * 把对象存到文件里面---》ObjectOutputStream
 * 可以把序列化之后的对象，存储在文件里面，保证数据的持久化
 * 持久化：把内存上的数据存储在硬盘上，完成数据从易丢失到保存的状态
 * 内存，断电即消失
 *
 *序列化技术和反序列化
 *不专属于java，指的是把逻辑的概念给线性化
 *对象存储在堆里面，对是一个二维空间，导致对象不是线性逻辑结构
 *IO是一个线性的结构，底层只能是一个数组一个数组的复制数据
 *因此把对象线性化的过程称为对象的序列化
 *反序列化是指把系列化之后的对象还原为二维的结构的过程
 *
 *java中的序列化技术--
 *
 *
 *不是所有的對象都可以序列化  java.io.NotSerializableException
 * 不是所有的屬性都需要序列化  transient
 */
import java.io.Serializable;

public class book implements Serializable{
	private Integer number;
	private String name;
	//是为了属性的活性，在序列化得时候不参与序列化过程，这时候如果通过ObjectInputStream读取被该关键字
	//修饰的属性会展示出属性的默认值，
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
