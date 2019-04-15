#1、 查询Student表中的所有记录的Sname、Ssex和Class列。
SELECT sname,ssex,class FROM student;

#2、 查询教师所有的单位即不重复的Depart列。
SELECT DISTINCT depart FROM teacher;

#3、 查询Student表的所有记录。
SELECT * FROM student;

#4、 查询Score表中成绩在60到80之间的所有记录。
SELECT * FROM score WHERE degree BETWEEN 60 AND 80;


#5、 查询Score表中成绩为85，86或88的记录。
SELECT * FROM score WHERE degree IN (85,86,88);

#6、 查询Student表中“95031”班或性别为“女”的同学记录。
SELECT * FROM student WHERE class='95031' OR ssex='女';

#7、 以Class降序查询Student表的所有记录。
SELECT * FROM student ORDER BY class DESC;

#8、 以Cno升序、Degree降序查询Score表的所有记录。
SELECT * FROM score ORDER BY cno ASC,degree DESC;

#9、 查询“95031”班的学生人数。
SELECT COUNT(*) FROM student WHERE class='95031';


#10、查询Score表中的最高分的学生学号和课程号。
SELECT MAX(degree),cno FROM score;


#11、查询‘3-105’号课程的平均分。
SELECT AVG(degree) FROM score WHERE cno = '3-105';

#12、查询Score表中至少有5名学生选修的并以3开头的课程的平均分数。
SELECT cno,AVG(degree) FROM score WHERE cno LIKE '3%' GROUP BY cno HAVING COUNT(cno)>=5;

#13、查询学生,其最低分大于70，最高分小于90的Sno列。
SELECT sno FROM score GROUP BY sno HAVING MIN(degree)>70 AND MAX(degree)<90; 

#14、查询所有学生的Sname、Cno和Degree列。
SELECT sname,cno,degree FROM score,student WHERE score.`SNO` = student.`SNO`;

#15、查询所有学生的Sno、Cname和Degree列。
SELECT sno,cname,degree FROM score,course WHERE score.`CNO` = course.`CNO`;

#16、查询所有学生的Sname、Cname和Degree列。
SELECT sname,cname,degree FROM 
student,score,course WHERE 
student.`SNO` = score.`SNO` AND 
score.`CNO` = course.`CNO`;

#17、查询“95033”班所选课程的平均分。

SELECT AVG(degree) FROM score WHERE sno IN(
SELECT sno FROM student WHERE class='95033');

#18、假设使用如下命令建立了一个grade表：
CREATE TABLE grade(low INT(3),upp INT(3),rank CHAR(1));
INSERT INTO grade VALUES(90,100,'A');
INSERT INTO grade VALUES(80,89,'B');
INSERT INTO grade VALUES(70,79,'C');
INSERT INTO grade VALUES(60,69,'D');
INSERT INTO grade VALUES(0,59,'E');
COMMIT;
#现查询所有同学的Sno、Cno和rank列。
SELECT sno,cno,degree,rank FROM 
score,grade WHERE 
degree BETWEEN 
grade.`low` AND grade.`upp`; 


#19、查询选修“3-105”课程的成绩高于“109”号同学成绩的所有同学的记录(记录限于3-105)。

SELECT * FROM student,score WHERE score.`DEGREE`>
(SELECT degree FROM score WHERE cno = '3-105' AND sno = '109') 
AND score.`CNO`='3-105';


#20、查询score中选学一门以上课程的同学中分数为非最高分成绩的记录(每门课中非最高)。
SELECT * FROM score WHERE cno IN(
SELECT cno FROM score GROUP BY cno HAVING COUNT(cno)>1 AND degree<MAX(degree)
);


#21、查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录(所有记录不限于3-105,以示与19题相区别)。
SELECT * FROM score WHERE score.`DEGREE`>
(SELECT degree FROM score WHERE cno = '3-105' AND sno = '109') ;

#22、查询和学号为108的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
SELECT sno,sname,Sbirthday FROM student WHERE 
YEAR(Sbirthday) = (SELECT YEAR(Sbirthday) FROM student WHERE sno='108');

#23、查询“张旭“教师任课的学生成绩。

SELECT score.* FROM score LEFT JOIN course ON score.`CNO` = course.`CNO`
LEFT JOIN teacher ON course.`TNO` = teacher.`TNO` WHERE teacher.`TNAME` = '张旭' ;


#24、查询选修某课程的同学人数多于5人的教师姓名。
SELECT tname FROM course,teacher WHERE 
course.`TNO` = teacher.`TNO` AND 
course.`CNO` IN(
SELECT cno FROM score GROUP BY cno HAVING COUNT(cno)>5);

#25、查询95033班和95031班全体学生的记录。
SELECT * FROM student WHERE class IN (95033,95031);


#26、查询存在有85分以上成绩的课程Cno.
SELECT DISTINCT cno FROM score WHERE degree>85;

#27、查询出“计算机系“教师所教课程的成绩表。
SELECT * FROM score WHERE cno IN
(SELECT cno FROM course WHERE tno  
IN (SELECT tno FROM teacher WHERE DEPART = '计算机系'));

#28、查询“计算机系”与“电子工程系“不同职称的教师的Tname和Prof。
SELECT tname,prof FROM teacher WHERE DEPART IN ('计算机系','电子工程系');

#29、查询选修编号为“3-105“课程且成绩至少高于选修编号为“3-245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。
# 至少高于表示比其中最少的要高
SELECT cno,sno,degree FROM score WHERE cno = '3-105' AND 
degree>(SELECT MIN(degree) FROM score WHERE cno = '3-245')
ORDER BY degree DESC;

#30、查询选修编号为“3-105”且成绩高于选修编号为“3-245”课程的同学的Cno、Sno和Degree.
#表示比其中最高要高
SELECT cno,sno,degree FROM score WHERE cno = '3-105' AND 
degree>(SELECT MAX(degree) FROM score WHERE cno = '3-245');

#31、查询所有教师和同学的name、sex和birthday.
SELECT sname,ssex,sbirthday FROM student UNION ALL 
SELECT tname,tsex,tbirthday FROM teacher;

#32、查询所有“女”教师和“女”同学的name、sex和birthday.
SELECT sname,ssex,SBIRTHDAY FROM student WHERE ssex='女'
UNION ALL
SELECT tname,tsex,TBIRTHDAY FROM teacher WHERE tsex='女';

#33、查询成绩比该课程平均成绩低的同学的成绩表。
#SELECT cno,AVG(degree) FROM score s2 GROUP BY cno;

SELECT s1.*,s2.degr FROM score s1 INNER JOIN 
(SELECT cno,AVG(degree) AS degr FROM score  GROUP BY cno) AS s2
ON s1.`CNO` = s2.cno
WHERE s1.`DEGREE`<s2.degr;



#34、查询所有任课教师的Tname和Depart.
SELECT tname,DEPART FROM teacher WHERE tno IN (SELECT tno FROM course);

#35 查询所有未讲课的教师的Tname和Depart. 
SELECT tname,DEPART FROM teacher WHERE tno NOT IN(SELECT tno FROM course);


#36、查询至少有2名男生的班号。
SELECT class FROM student WHERE ssex = '男' GROUP BY class HAVING COUNT(ssex)>=2;

#37、查询Student表中不姓“王”的同学记录。
SELECT * FROM student WHERE sname NOT LIKE '王%';

#38、查询Student表中每个学生的姓名和年龄。
#datediff返回两个日期间天数
SELECT sname,DATEDIFF(SYSDATE(),SBIRTHDAY)/365 FROM student;

#39、查询Student表中最大和最小的Sbirthday日期值。
SELECT MAX(SBIRTHDAY),MIN(SBIRTHDAY) FROM student;

#40、以班号和年龄从大到小的顺序查询Student表中的全部记录。
SELECT * FROM student ORDER BY class DESC,SBIRTHDAY DESC;

#41、查询“男”教师及其所上的课程。
SELECT tname, cname FROM course,teacher  WHERE course.`TNO` = teacher.`TNO` AND tsex='男';


#42、查询最高分同学的Sno、Cno和Degree列。
SELECT sno,cno,degree FROM score WHERE degree = (SELECT MAX(degree) FROM score);

#43、查询和“李军”同性别的所有同学的Sname.
SELECT sname FROM student WHERE ssex IN (SELECT ssex FROM student WHERE sname = '李军');

#44、查询和“李军”同性别并同班的同学Sname.
SELECT sname FROM student WHERE  ssex IN (SELECT ssex FROM student WHERE sname = '李军')
AND class=(SELECT class FROM student WHERE sname='李军');


#45、查询所有选修“计算机导论”课程的“男”同学的成绩表
SELECT score.* FROM score INNER JOIN student 
ON score.`SNO` = student.`SNO`
INNER JOIN course 
ON course.`CNO` = score.`CNO`
WHERE course.`CNAME` = '计算机导论' AND student.`SSEX` = '男';
