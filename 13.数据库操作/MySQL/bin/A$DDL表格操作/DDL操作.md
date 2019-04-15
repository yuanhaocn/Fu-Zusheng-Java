## 四.SQL语言（重点）

**1.背景**

人与人之间可以通过汉语，英语等语言进行交流

人与数据库间通SQL语言进行交流

**2.概念**

SQL:结构化查询语言（Structure Query Language）

SQL被美国国家标准局（ANSI）确定为关系型数据库语言的美国标准，后来被国际化标准组织（ISO）采纳为关系数据库语言的国际标准。

各数据库厂商都支持ISO的SQL标准，**普通话**

各数据库厂商在标准的基础上做了自己的扩展，**方言**

SQL 是一种标准化的语言，它允许你在数据库上执行操作，如创建项目，查询内容，更新内容，并删除条目等操作。

CRUD操作：  Create增加, Read（查询）, Update（更新）, Delete（删除）

**3.sql的分类**

- DDL（Data Definition Language）：数据定义语言，用来定义数据库对象：库、表、列等。

- DML（Data Manipulation Language）：数据操作语言，用来定义数据库记录（数据）。

- DCL（Data Control Language）：数据控制语言，用来定义访问权限和安全级别。

- DQL（Data Query Language）：数据查询语言，用来查询记录（数据）。

  > 注意sql语句以;结尾

**DDL语法（对数据库对像）：**

```
##DDL 数据库对像定义语言
##1.创建数据库javaee
CREATE DATABASE javaee;

##2.创建数据库同时指定字符集
CREATE DATABASE javaee2 CHARACTER SET gbk;

##3.创建数据库同时指定字符集并指定关联格式
CREATE DATABASE javaee3 CHARACTER SET gbk COLLATE gbk_chinese_ci;

##4.查询数据库管理系统中有多少个数据库
SHOW DATABASES;

##5.查询数据库定义信息
SHOW CREATE DATABASE javaee;

##6.改变数据库的字符集
ALTER DATABASE javaee2 CHARACTER SET utf8;

##7.删除数据库
DROP DATABASE javaee2;

##8.切换数据库
USE javaee;

##9.查看当前正在使用的数据库
SELECT DATABASE();

```

**DDL语法（对表对像）**

- 创建表（create）：

CREATE TABLE语句用于创建新表。

语法： 

CREATE TABLE 表名(

​                                  字段1 字段类型(长度) 约束,

​                                  字段2 字段类型(长度) 约束,

​                                  ...

​                                  字段n 字段类型(长度) 约束

​                        	 );

```
CREATE TABLE stu (

id INT(5) COMMENT '主键',

NAME VARCHAR(50) COMMENT '学生姓名',

birthday DATETIME COMMENT '生日'

);
```

对字段（列）中值的约束：

```
CREATE TABLE stu2 (

id INT(5) PRIMARY KEY, ##主键（唯一且非空）

NAME VARCHAR(50) UNIQUE NOT NULL,##唯一且非空

brithday DATETIME NOT NULL ##非空

);

```

常用数据类型：

​                         int：整型

​                         double：浮点型，例如double(5,2)表示最多5位，其中必须有2位小数，即最大值为999.99；

​                         char：固定长度字符串类型；    char(10)    'aaa       '  占10位

​                         varchar：可变长度字符串类型； varchar(10)  'aaa'  占3位

​                         text：字符串类型;

​                         blob：大数据类型（字节类型）；

​                         date：日期类型，格式为：yyyy-MM-dd；

​                         time：时间类型，格式为：hh:mm:ss

​                         timestamp：时间戳类型 yyyy-MM-dd hh:mm:ss  会自动赋值

​                         datetime:日期时间类型 yyyy-MM-dd hh:mm:ss

常用约束：

​			主键约束：primary key

​			唯一约束：unique [key]

 			非空约束：not null

​			默认约束：default 

​			外键约束：foreign key

​			自动增长：auto_increment

- 删除表（drop）

语法结构：drop table 表名

```
DROP TABLE stu2;
```

- 对表的其他操作

```
##.查看数据库中的表信息
SHOW TABLES;

##.查看数据库中表的详细信息
DESC stu;
```

- 对表的结构的复杂操作

当表结构创建好以后，又需要改变表的一些结构

添加新的一列（alter）：alter table 表名 add  字段名 字段类型

```
##给已创建表的添加新的字段
ALTER TABLE stu ADD image BLOB;
```

改变列的定义：alter table 表名 modify 字段名（长度）字段类型

```
##给已创建表，改变字段的长度
ALTER TABLE stu MODIFY NAME VARCHAR(200);
```

删除表中已有字段

```
##删除表中的已有字段
ALTER TABLE stu DROP image;
```

改变已创建表的表名

```
##改变表名 rename table 旧表名 to 新表名
RENAME TABLE stu TO stu2;
```

查看创建表的语法

```
SHOW CREATE TABLE stu2;
```

修改已创建表的字符集

```
##修改表的字符集
ALTER TABLE stu2 CHARACTER SET gbk;
```

修改已创建表的字段名（列名）

```
##ALTER TABLE 表名 CHANGE 旧字段名 新字段名
ALTER TABLE stu2 CHANGE NAME stuname VARCHAR(50);
```

