package 动态代理.exp1;

//目标对象
public class UserDao implements IUserDao{
 @Override
 public void save() {
   System.out.println("模拟： 保存用户！");
 }
 @Override
 public void find() {
   System.out.println("查询");
 }
}
