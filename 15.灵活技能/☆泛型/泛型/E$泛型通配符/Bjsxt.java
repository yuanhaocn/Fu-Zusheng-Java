package E$泛型通配符;

/**
 * 泛型的嵌套
 * 声明：嵌套使用泛型
 * A<B<C>> a = new A<B<C>>
 * 使用：从外到里，一层一层拆分，稍微复杂一些，与调用没有任何关系，只是确定了类型而已
 */
public class Bjsxt<T>{
	T stu;
	public static void main(String[] args) {
		//泛型的嵌套，左右对称	
		 Bjsxt<Student<String>> room = new  Bjsxt<Student<String>>();			//最外层时 Bjsxt<Student<String>>
		//使用的时候时从外到里，拆分是一层一层拆分，在hashMap()中经常使用			
		 room.stu = new Student<String>();			//赋值，免得报错	
		 Student<String> stu = room.stu;										//第二层Student<String>
		 String score = stu.score;												//最里层String	
		 System.out.println(score);
		 
//****************************我自己的理解******************************************************//	 
		 Bjsxt<Student<String>> floor = new  Bjsxt<Student<String>>();
		floor.stu = new Student<String>();//对里层进行赋值，免得空指针异常， 上一行相当于给floor.stu声明了一下，但未赋值
		//这一步就比17，18行好理解一点直接把泛型的部分都声明和赋值好，然后就可以直接调用
		 System.out.println(floor.stu.score);
	}
}
