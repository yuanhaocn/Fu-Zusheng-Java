- **DML语法：针对表中的数据进行CRUD操作（重点）**

  ​

  **增(insert)：**

  语法结构：insert into 表名 (字段名1，字段名2，......) values (值1，值2，.......);

  ```
  INSERT INTO stu(id,stuname,birthday) VALUES(3,'kevin','1999-10-10');
  ```

  同时插入多条记录

  ```
  INSERT INTO stu(id,stuname,birthday) VALUES
  (4,'kevin2','1999-10-10'),
  (5,'kevin3','1999-10-10');

  ```

  如果全字段插入，则可以省略字段名

  ```
  ##如果全字段插入，则可以省略（字段名）
  INSERT INTO stu VALUES(7,'kevin5','1999-10-10');
  ```

  如果非全字段插入，则必须指定字段名，且值和字段名要相对应

  ```
  INSERT INTO stu(id,stuname) VALUES(8,'kevin6');
  ```

  ​

  **删(delete):**

  语法结构：delete from 表名 [ where 条件]

  删除表中所有记录：

  ```
  ##删除表中所有数据（不建议使用）
  DELETE FROM stu;
  ```

  按条件删除表中记录：

  ```
  ##按条件删除
  DELETE FROM stu WHERE id = 2;
  ```

  删除表中的数据同时删除表结构，比delete from 表名 效率高

  ```
  ##删除表中记录同时删除表结构
  TRUNCATE TABLE stu;
  ```

  ​

  **改(update)：**

  语法结构：update 表名 set 字段名1=值1，字段名2=值2,........ where 条件

  ```
  ##update 更新记录
  UPDATE stu SET stuname='tom',birthday='1990-10-10' WHERE id = 1;
  ```

  对表中所有记录进行更新（不推荐使用）

  ```
  UPDATE stu SET stuname='kevin';
  ```

  ​