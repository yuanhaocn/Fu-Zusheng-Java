**DQL:对数据库表中的记录进行查询（select）操作**

**查（select）:**

语法结构： 

SELECT 列名1,列名2，.... 

FROM  表名 

【WHERE  条件 

BROUP BY 分组字段

HAVING 分组条件

ORDER BY 排序条件

limit 分页条件】

创建学生表并添加记录：

```
#创建表stu
CREATE TABLE stu (
	sid	CHAR(6),
	sname		VARCHAR(50),
	age		INT,
	gender	VARCHAR(50)
);
#添加数据
INSERT INTO stu VALUES('S_1001', 'liuYi', 35, 'male');
INSERT INTO stu VALUES('S_1002', 'chenEr', 15, 'female');
INSERT INTO stu VALUES('S_1003', 'zhangSan', 95, 'male');
INSERT INTO stu VALUES('S_1004', 'liSi', 65, 'female');
INSERT INTO stu VALUES('S_1005', 'wangWu', 55, 'male');
INSERT INTO stu VALUES('S_1006', 'zhaoLiu', 75, 'female');
INSERT INTO stu VALUES('S_1007', 'sunQi', 25, 'male');
INSERT INTO stu VALUES('S_1008', 'zhouBa', 45, 'female');
INSERT INTO stu VALUES('S_1009', 'wuJiu', 85, 'male');
INSERT INTO stu VALUES('S_1010', 'zhengShi', 5, 'female');
INSERT INTO stu VALUES('S_1011', 'xxx', NULL, NULL);
```

- 查询表中的所有记录数

```
##查询所有记录
SELECT sid,sname,age,gender FROM stu;
##使用*代替字段名
SELECT * FROM stu;
##查询特定字段
SELECT sid,sname FROM stu;
```

- 按照条件进行精确查询（重点）

```
##添加简单条件查询
##查询sname=liSi的记录
SELECT * FROM stu WHERE sname='liSi';
```

可以使用的条件关键字：

条件查询就是在查询时给出WHERE子句，在WHERE子句中可以使用如下运算符及关键字：

  =、!=、<>、<、<=、>、>=；

  BETWEEN…AND；

  IN(set)；

  IS NULL；  

  AND；

  OR；

  NOT；

```
## =、!=、<>、<、<=、>、>=
##查询年龄！=35的所有学生记录
SELECT * FROM stu WHERE age !=35;
SELECT * FROM stu WHERE age <> 35;
##查询年龄>35的所有学生记录
SELECT * FROM stu WHERE age>35;


##BETWEEN…AND
##查询年龄在30到50之间的所有学生记录
SELECT * FROM stu WHERE age BETWEEN 30 AND 50;
## AND 
SELECT * FROM stu WHERE age >=30 AND age <=50;


##or
##查询年龄是35或45的所有学生记录
SELECT * FROM stu WHERE age=35 OR age=45;


##in
##查询年龄是15，16，17，18，19，20之间的所有学生记录
SELECT * FROM stu WHERE  age IN(15,16,17,18,19,20);



## is null
##查询年龄为null的学生记录
SELECT * FROM stu WHERE age IS NULL;


##not 
##查询年龄不为空的学生记录
SELECT * FROM stu WHERE age IS NOT NULL;
##查询年龄不在30到50之间的所有学生记录
SELECT * FROM stu WHERE age NOT BETWEEN 30 AND 50;



```

模糊查询：like
其中_表示匹配一个字符，%表示匹配（0—n）个字符

```
##模糊查询（like）%和_
##查询sname中包含字符i的所有学生记录
SELECT * FROM stu WHERE sname LIKE '%i%';

##查询sname中以l开头的所有学生记录
SELECT * FROM stu WHERE sname LIKE 'l%';

##查询sname中第二个位置是i的所有学生记录
SELECT * FROM stu WHERE sname LIKE '_i%';

##相当于 select * from stu where sname ='i'
SELECT * FROM stu WHERE sname LIKE 'i';
```

字段控制查询：

distinct去重复查询,对相同的记录去重复

```
##查询性别的种类有几种
SELECT DISTINCT gender FROM stu

##对distinct后面出现的字段进行去重复，如果字段都相同，则认为相同的记录，则会达到去重复的效果
SELECT DISTINCT gender,sname FROM stu;
```

支持运算术运算（数值类型和日期类型）

```
##查询年龄+10大于45的所有学生记录
SELECT * FROM stu WHERE age+10>45;

##把sid='S_1003'的学生年龄加10岁
UPDATE stu SET age=age+10 WHERE sid ='S_1003';
```

给列和表添加别名（使用as关键字）

```
##给列添加别名
SELECT sid 主键,sname 学生姓名,age 学生年龄,gender 学生性别 FROM stu;

SELECT sid '主键',sname '学生姓名',age '学生年龄',gender '学生性别' FROM stu;

##其中as可以省略不写
SELECT sid AS 主键,sname AS 学生姓名,age AS 学生年龄,gender AS 学生性别 FROM stu;

##给表添加别名
SELECT * FROM stu s;

SELECT * FROM stu AS s;

SELECT s.* FROM stu AS s;

SELECT s.sname,s.age FROM stu AS s;

```

排序（使用order by关键字，asc升序|desc降序）

```
##查询性别为male所有学生记录，且要按age从低到高升序排序(asc升序|desc降序)
SELECT * FROM stu WHERE gender = 'male' ORDER BY age DESC;
##多条件排序
##查询所有学生信息，且按age升序排序且sid降序
SELECT * FROM stu ORDER BY age ASC,sid DESC;

```

聚合函数（统计函数）

l  MAX()：计算指定列的最大值，如果指定列是字符串类型，那么使用字符串排序运算；

l  MIN()：计算指定列的最小值，如果指定列是字符串类型，那么使用字符串排序运算；

l  SUM()：计算指定列的数值和，如果指定列类型不是数值类型，那么计算结果为0；

l  AVG()：计算指定列的平均值，如果指定列类型不是数值类型，那么计算结果为0；

l  COUNT()：统计指定列不为NULL的记录行数；

```
##max()
##查询记当中最大年龄
SELECT sid,sname,MAX(age) FROM stu;

##avg()
##查询班级中学生年龄的平均值
SELECT AVG(age) FROM stu;
SELECT SUM(age)/COUNT(*) FROM stu;

##sum()
##求班级中学生年龄总和
SELECT SUM(age) FROM stu;

##count()
##查看学生的总人数
SELECT COUNT(*) FROM stu;


```

##### 3.7 分组查询

当需要分组查询时需要使用GROUP BY子句，例如查询每个部门的工资和，这说明要使用部分来分组。

注：凡和聚合函数同时出现的列名，则一定要写在group by 之后

###### 3.7.1 分组查询

l  查询每个部门的部门编号和每个部门的工资和：

```sql
SELECT deptno, SUM(sal)

FROM emp

GROUP BY deptno;
```

l  查询每个部门的部门编号以及每个部门的人数：

```sql
SELECT deptno,COUNT(*)

FROM emp

GROUP BY deptno;
```

l  查询每个部门的部门编号以及每个部门工资大于1500的人数：

```sql
SELECT deptno,COUNT(*)

FROM emp

WHERE sal>1500

GROUP BY deptno;
```

###### 3.7.2 HAVING子句

l  查询工资总和大于9000的部门编号以及工资和：

```sql
SELECT deptno, SUM(sal)

FROM emp

GROUP BY deptno

HAVING SUM(sal) > 9000;
```

​      注：having与where的区别:

   	1.having是在分组后对数据进行过滤,where是在分组前对数据进行过滤             

​	2.having后面可以使用分组函数(统计函数)

​         where后面不可以使用分组函数。

​	WHERE是对分组前记录的条件，如果某行记录没有满足WHERE子句的条件，那么这行记录不会参加分组；而		HAVING是对分组后数据的约束。

##### 3.8 LIMIT

LIMIT用来限定查询结果的起始行，以及总行数。

###### 3.8.1 查询5行记录，起始行从0开始

```sql
SELECT * FROM emp LIMIT 0, 5;
```

注意，起始行从0开始，即第一行开始！

###### 3.8.2 查询10行记录，起始行从3开始

```sql
SELECT* FROM emp LIMIT 3, 10;
```

###### 3.8.3 分页查询

如果一页记录为10条，希望查看第3页记录应该怎么查呢？

l  第一页记录起始行为0，一共查询10行；

l  第二页记录起始行为10，一共查询10行；

l  第三页记录起始行为20，一共查询10行；

​        查询语句书写顺序：select – from- where- groupby- having- order by-limit

​        查询语句执行顺序：from - where -group by -having - select - order by-limit        