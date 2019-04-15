### CSS

#### 课前默写

```
1、写出HTML语法规范
2、写出HTML的表单标签
3、写出get和post请求的区别
4、写出你知道的非表单标签
```

#### 课程回顾

```
1、HTML语法规范
2、HTML的组成格式
3、HTML的常用标签
4、HTML的表单标签
5、HTML的特殊字符
```

#### 今日内容

```
1、CSS简介
2、CSS导入方式
3、CSS选择器
4、CSS属性
5、CSS盒子模型
6、CSS扩展属性
```

#### 教学目标

```
1、了解CSS简介
2、掌握CSS导入方式
3、掌握CSS选择器
4、掌握CSS属性
5、掌握CSS盒子模型
6、熟悉CSS扩展属性
```

#### 第一章 CSS简介

##### 1.1 什么是CSS

```
1. CSS :全称：Cascading Style Sheets  层叠样式表,定义如何显示HTML元素
2. 多个样式可以层层覆盖叠加，如果不同的css样式对同一html标签进行修饰，样式有冲突的
   应用优先级高的，不冲突的共同作用
```

##### 1.2 CSS能干什么

```
1. 修饰美化html网页。
2. 外部样式表可以提高代码复用性从而提高工作效率。
3. html内容与样式表现分离，便于后期维护。
```

##### 1.3 CSS书写规范

​        CSS 规则由两个主要的部分构成：选择器，以及一条或多条声明.

​               a. 选择器通常是您需要改变样式的 HTML 元素。

​               b. 每条声明由一个属性和一个值组成。

​     **基础语法：选择器｛属性：值;属性:值….. ｝**

​     示例：![](http://www.w3school.com.cn/i/ct_css_selector.gif)

​          **提示：请使用花括号来包围声明。**

```
 2.注意事项：
        a.如果值为若干单词，则要给值加引号；
        b.多个声明之间使用分号;分开；
        c.css对大小不敏感，如果涉及到与html文档一起使用时，class与id名称对大小写敏感
```

#### 第二章 CSS导入方式

##### 2.1 内嵌方式(内联方式)

```
 把CSS样式嵌入到html标签当中，类似属性的用法，示例如下：
       <div style="color:blue;font-size:50px">This is my HTML page. </div>
```

##### 2.2 内部方式

```
在head标签中使用style标签引入css,示例如下:
       <style type=“text/css”> //告诉浏览器使用css解析器去解析
            div{color:red;font-size:50px}
       </style>
```

##### 2.3 外部方式

```
  将css样式抽成一个单独文件，谁用谁就引用，示例如下：
       单独文件div.css:  内容示例：div{color:green;font-size:50px}
       引用语句写在head标签内部，
<link rel="stylesheet" type="text/css" href=“div.css"></link>
      rel:代表当前页面与href所指定文档的关系
      type:文件类型，告诉浏览器使用css解析器去解析
      href:css文件地址
```

##### 2.4 @import方式

```
  <style type="text/css">
       @import url("div.css")
  </style>
 该内容放在head标签中
 
 备注:link和@import区别：
           1.link所有浏览器都支持，@import某些版本低的IE不支持
           2.@import是等待html加载完成才加载
           3.@import不支持js动态修改
```

#### 第三章 CSS选择器

 主要用于选择需要添加样式的html元素

##### 3.1 基本选择器

######         3.1.1 元素选择器

​                  在head中使用style标签引入在其中声明元素选择器:html标签{属性:属性值}，

 具体示例如下: 

```
  <style type="text/css">
         span{color: red;font-size: 100px}
  </style>    对span标签进行样式修改
```

######       3.1.2 id选择器

​                给需要修改样式的html元素添加id属性标识，在head中使用style标签引入在其中声明id选择器: #id值{属性:属性值}

```
具体示例如下:
    创建id选择器：
        <div id="s1">hello,everyone!</div>
	    <div id="s2">hello,everyone!</div>
         <div id="s3">hello,everyone!</div>
	     根据id选择器进行html文件修饰 
        <style type="text/css">
		      #s1{color: red;font-size: 100px}
		      #s2{color: green;font-size: 100px}
		      #s3{color: blue;font-size: 100px}
	    </style>
```

######        3.1.3 class选择器

​                      给需要修改样式的html元素添加class属性标识，在head中使用style标签引入在其中声明class选择器:  .class名{属性:属性值}，具体示例如下:

```
创建class选择器：
	       <div class="s1">hello,everyone!</div>
		   <div class="s2">hello,everyone!</div>
		   <div class="s3">hello,everyone!</div>
根据id选择器进行html文件修饰 
<style type="text/css">
		  .s1{color: purple;font-size: 100px}
		  .s2{color: pink;font-size: 100px}
		  .s3{color: yellow;font-size: 100px}
</style>
```

​    **备注:以上基本选择器的优先级从高到低:id ,class ,元素**

##### 3.2 属性选择器

根据元素的属性及属性值来选择元素。在head中使用style标签引入在其中声明, 

```
格式为:htm标签[属性=‘属性值']{css属性:css属性值;}
    或者html标签[属性]{css属性:css属性值;}， 
具体示例如下:
body内容：
     <form name="login" action="#" method="get">
		<font size="3">用户名：<font> 
         <input type=“text" name="username" value="zhangsan"></input> </br>
      密码： <input type="password" name="password" value="123456"></input> </br>
            <input   type="submit" value="登录"></input>
	</form>

 head中书写：
<style type="text/css">
        input[type='text'] {
            background-color: pink
        }
        input[type='password'] {
            background-color: yellow
        }
        font[size] {
            color: green
        }
        a[href] {
            color: blue;
        }
</style>
```

##### 3.3 伪元素选择器

 主要是针对a标签

```
语法：
              静止状态 a:link{css属性}
              悬浮状态 a:hover{css属性}
              触发状态 a:active{css属性}
              完成状态  a:visited{css属性}
具体示例如下：
   <a href="https://hao.360.cn/">点我吧</a>
        <style type="text/css">
			<!--静止状态 -->
			a:link {color: red;}
			<!--悬浮状态 -->’
			a:hover {color: green;}
			<!--触发状态 -->
			a:active {color: yellow;}
			<!--完成状态 -->
			a:visited {color: blue;}
		</style>
```

##### 3.4 层级选择器

 父级选择器，子级选择器….,具体示例如下：

```html
  <div id="div1">
			<div class="div11">
				<span>span1-1</span>
			</div>
			<div class="div12">
				<span>span1-2</span>
			</div>
	    </div>
		<div class="div2">
			<div id="div22">
				<span>span2-1</span>
			</div>
			<div id="div23">
				<span>span2-2</span>
			</div>
		</div>

		<style type="text/css">
			#div1 .div11{color:red;}
			#div1 .div12{color:purple;}
			.div2 #div22{color:green;}
			.div2 #div23{color:blue;}
		</style>
```

#### 第四章 CSS属性

##### 4.1 文字属性

```
1>.font-size:设置字体大小
2>.font-family:设置文字的字体,常见的值为 :黑体，宋体，楷体等
3>.font-style:规定斜体字,常见的值：
								normal - 文本正常显示
					            italic - 文本斜体显示
					            oblique - 文本倾斜显示
4>font-weight 属性设置文本的粗细。关键字 100 ~ 900 为字体指定了 9 级加粗度。
                                100 对应最细的字体变形，900 对应最粗的字体变形。
                                数字 400 等价于 normal，而 700 等价于 bold。
	  备注：
	  斜体（italic）是对每个字母的结构有一些小改动，来反映变化的外观。
	  倾斜（oblique）文本则是正常竖直文本的一个倾斜版本。
通常情况下，italic 和 oblique 文本在 web 浏览器中看上去完全一样
```

##### 4.2 文本属性

```
1>.color:设置文本颜色
2>.text-indent:缩进元素中文本的首行,取值类型如下：
	         1》text-indent:5em;表示此段落第一行缩进5个字符的宽度
	         2》text-indent:20%:表示此段落第一行缩进父容器宽度的百分之二十
3>.text-decoration:
             none:会关闭原本应用到一个元素上的所有装饰
	   underline: 添加下划线
             overline:在文本的顶端画一个上划线
	    line-through:在文本中间画一个贯穿线
	    blink:让文本闪烁
4>.text-align:一个元素中的文本行互相之间的对齐方式,值有left(左对齐)、right(右对齐) 和 center(居中)
5>.word-spacing: 字符之间的间隔
6>.letter-spacing: 单词或者字母之间的间隔
7>.line-height:25px-32px
```

##### 4.3 背景属性

```
1>.background-color：设置背景颜色，默认透明
2>.background-image:url("图片路径"):设置背景图片
3>.background-repeat:repeat-y:只在垂直方向都平铺
                             repeat-x:只在水平方向都平铺
                             repeat:在水平垂直方向都平铺
                             no-repeat:任何方向都不平铺
4>. background-position: 改变图像在背景中的位置。top、bottom、left、right 和 center 
```

##### 4.4 列表属性

```
list-style-type:decimal;改变列表的标志类型
list-style-image: url("images/dog.gif");用图像表示标志
list-style-position: inside;确定标志出现在列表项内容之外还是内容内部 
```

##### 4.5 尺寸属性

```
width:设置元素的宽度
height:设置元素的高度
```

##### 4.6 显示属性

```
显示属性display :none:不显示
block:块级显示
inline:行级显示
```

##### 4.7 轮廓属性

```
绘制于元素周围的一条线，位于边框边缘的外围，可起到突出元素的作用。常用属性：
         outline-style:solid(实线)/dotted(虚线)/dashed(虚线，虚线的每段较长)/double(框为空心);设置轮廓的样式
	     outline-color:red;设置轮廓的颜色
	     outline-width:10px设置轮廓的宽度
```

##### 4.8 浮动属性float

浮动的框可以向左或向右移动，直到它的外边缘碰到包含框或另一个浮动框的边框为止。由于浮动框不在文档的普通流中，所以文档的普通流中的块框表现得就像浮动框不存在一样。

请看下图，当把框 1 向右浮动时，它脱离文档流并且向右移动，直到它的右边缘碰到包含框的右边缘：

![](http://www.w3school.com.cn/i/ct_css_positioning_floating_right_example.gif)

再请看下图，当框 1 向左浮动时，它脱离文档流并且向左移动，直到它的左边缘碰到包含框的左边缘。因为它不再处于文档流中，所以它不占据空间，实际上覆盖住了框 2，使框 2 从视图中消失。

如果把所有三个框都向左移动，那么框 1 向左浮动直到碰到包含框，另外两个框向左浮动直到碰到前一个浮动框。

![](http://www.w3school.com.cn/i/ct_css_positioning_floating_left_example.gif)

如下图所示，如果包含框太窄，无法容纳水平排列的三个浮动元素，那么其它浮动块向下移动，直到有足够的空间。如果浮动元素的高度不同，那么当它们向下移动时可能被其它浮动元素“卡住”：

![](http://www.w3school.com.cn/i/ct_css_positioning_floating_left_example_2.gif)

**clear 属性**

规定元素的哪一侧不允许其他浮动元素。

**可能的值**

| 值       | 描述                     |
| ------- | ---------------------- |
| left    | 在左侧不允许浮动元素。            |
| right   | 在右侧不允许浮动元素。            |
| both    | 在左右两侧均不允许浮动元素。         |
| none    | 默认值。允许浮动元素出现在两侧。       |
| inherit | 规定应该从父元素继承 clear 属性的值。 |

##### 4.9 定位属性

###### 4.9.1 相对定位(relative)

元素框偏移某个距离。元素仍保持其未定位前的形状，它原本所占的空间仍保留

示例代码：

```html
<html>
	<head>
		<style type="text/css">
			h2.pos_left {
				position: relative;
				left: -20px
			}
			
			h2.pos_right {
				position: relative;
				left: 20px
			}
		</style>
	</head>
	<body>
		<h2>这是位于正常位置的标题</h2>
		<h2 class="pos_left">这个标题相对于其正常位置向左移动</h2>
		<h2 class="pos_right">这个标题相对于其正常位置向右移动</h2>
		<p>相对定位会按照元素的原始位置对该元素进行移动。</p>
		<p>样式 "left:-20px" 从元素的原始左侧位置减去 20 像素。</p>
		<p>样式 "left:20px" 向元素的原始左侧位置增加 20 像素。</p>
	</body>
</html>
```

###### 4.9.2 绝对定位(absolute)

​        元素框从文档流完全删除，并相对于其包含块定位。包含块可能是文档中的另一个元素或者是初始包含块。元素原先在正常文档流中所占的空间会关闭，就好像元素原来不存在一样。元素定位后生成一个块级框，而不论原来它在正常流中生成何种类型的框.

```html
<html>
	<head>
		<meta charset="utf-8" />
		<style type="text/css">
			h2.pos_abs {
				position: absolute;
				left: 100px;
				top: 150px
			}
		</style>
	</head>
	<body>
		<h2 class="pos_abs">这是带有绝对定位的标题</h2>
		<p>通过绝对定位，元素可以放置到页面上的任何位置。下面的标题距离页面左侧 100px，距离页面顶部 150px。</p>
	</body>
</html>
```

###### 4.9.3 固定定位(fixed)

​         元素框的表现类似于将 position 设置为 absolute，不过其包含块是视窗本身。

示例如下(网站左下角和右下角广告)：

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			#left {
				width: 200px;
				height: 200px;
				background-color: red;
				position: fixed;
				left: 0;
				bottom: 0;
			}
			
			#right {
				width: 200px;
				height: 200px;
				background-color: green;
				position: fixed;
				right: 0;
				bottom: 0;
			}
			#middle{
				width: 200px;
				height: 200px;
				background-color: blue;
				position: fixed;
				left: 0;
				bottom: 50%;
			}
			
		</style>
	</head>
	<body>
		<div id="left">
		</div>
		<div id="right">
		</div>
		<div id="middle">
		</div>
	</body>
</html>
```

#### 第五章 CSS盒子模型

![盒子模型](图片/盒子模型.png)

##### 5.1 边框相关属性  

```
border-style:边框样式，值有以下情况：
				solid:实线
				double:空心线
				dashed:圆点组成的边框
				dotted:虚线组成的边框
border-color:边框颜色
border-width:边框宽度
```

#####  5.2 外边距相关属性

```
margin:外间距,边框和边框外层的元素的距离
margin:四个方向的距离(top right bottom left)
margin-top:
margin-bottom:
margin-left:
margin-right:
```

##### 5.3 内边距相关属性

```
padding:内间距,元素内容和边框之间的距离((top right bottom left)) 
padding-left:
padding-right:
padding-top:
padding-bottom:
```

#### 第六章 CSS3扩展属性

##### 6.1 border-radius创建圆角

​          示例：	border-radius: 25px;

![圆角属性](图片/圆角属性.png)

##### 6.2 box-shadow:用于向方框添加阴影  

​        示例：box-shadow: 10px 10px 5px #888888;

![阴影部分](图片/阴影部分.png)

##### 6.3 background-size: 属性规定背景图片的尺寸

```html
	<body style="text-align: center;
		background:url(img/1.png);
		background-size: 200px 300px;
		background-repeat: no-repeat;">
	</body>
```

##### 6.4 background-image:为指定元素使用多个背景图像

![多背景属性](图片/多背景属性.png)

##### 6.5 text-shadow: 可向文本应用阴影。 

​      示例：text-shadow: 5px 5px 5px #ffff00;

![字体阴影](图片/字体阴影.png)

#### 第七章 HTML结合CSS完成淘宝分类页

#####  7.1 案例效果图

##### ![html+css](图片/html+css.png)



##### 7.2 案例源代码

```html
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style>
		#ul01 li{
				list-style: none;
				float: left;
				text-align: center;
				line-height: 50px;	
			}
				#ul02 li{
				list-style: none;
				float: left;
				line-height: 20px;
			}
			#ul03 li{
				list-style: none;
				float: left;
				margin:0 auto;
				line-height: 50px;
				text-align: center;
			}
			#ul04 li{
				list-style: none;
				float: left;
				margin:0 auto;
				line-height: 30px;
				text-align: center;
				font-size: small;
			}
		</style>
	</head>
			<!--模拟淘宝的一个指定页面：
			http://uland.taobao.com/sem/tbsearch?keyword=%cc%d4%b1%a6%c9%cc%b3%c7&refpid=mm_26632360_8858797_29866178&clk1=2a24506120a4353dbcb3ccd052a308ed&upsid=2a24506120a4353dbcb3ccd052a308ed
		-->
	<body style="margin: 0;">
		<!--顶部标题栏-->
		<div style="background-color: #F5F5F5;width: 100%; height:50px;border-bottom: 1px solid #EEE;">
			<div style="margin:-20px;height:50px;background-color: #F5F5F5;">
				<ul id="ul01"  style="margin-left: 25px;" >
				<li><a style="color: red;">亲，请登录&nbsp;</a></li>
				<li><a>免费注册</a></li>
				<li><a>&nbsp;&nbsp;手机逛淘宝</a></li>
			    </ul>
			    <div style="float: right;" >	
				<ul id="ul01" style="margin:0px;height:50px;background-color: #F5F5F5;" >
				<li><a style="color: red;">淘宝网首页&nbsp;</a></li>
				<li><a>我的淘宝&nbsp;</a></li>
				<li><a>购物车&nbsp;</a></li>
				<li><a>收藏夹&nbsp;</a></li>
				<li><a>商品分类&nbsp;</a></li>
				<li><a>卖家中心&nbsp;</a></li>
				<li><a>联系客服&nbsp;</a></li>
				<li><a>网站导航&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></li>
			</ul>
			</div>
			</div>
		</div>
		<!--搜索栏-->
		<div style="width: 100%;margin-left: 40px;margin-top: 20px;">
				<table border="0" style="width: 95%;">
					<tr>
				<td rowspan="4"><img  src="http://img.alicdn.com/tps/TB1YZkPLpXXXXbzXXXXXXXXXXXX-213-57.png"width="213px"/></td>
					<td height="10px"></td>
			</tr>
			<tr>
				<td ><form action="#" ,mmethod="get">
				    			<input type="text" name="searchContent" style="margin: 5px 0px 3px 15px;width: 800px;margin-left: 40px;"/>
				    			<input type="button" value="搜索"/>
				    		</form></td>
			</tr>
			<tr>
				<td><ul id="ul02" style="margin:0;">
						<li><a>客厅灯&nbsp;</a></li>
						<li><a>冲锋衣&nbsp;</a></li>
						<li><a>床垫&nbsp;</a></li>
						<li><a>沙发垫&nbsp;</a></li>
						<li><a>男内裤&nbsp;</a></li>
						<li><a>电脑桌&nbsp;</a></li>
						<li><a>鞋柜&nbsp;</a></li>
						<li><a>窗帘&nbsp;</a></li>
						<li><a>椅子&nbsp;</a></li>
						<li><a>男内裤&nbsp;</a></li>
						<li><a>电脑桌&nbsp;</a></li>
						<li><a>鞋柜&nbsp;</a></li>
						<li><a>窗帘&nbsp;</a></li>
						<li><a>椅子&nbsp;</a></li></td>
			</tr>
			<tr>
				<td height="5px"></td>
			</tr>	
				</table>
		</div>
		<!--搜搜记录提示栏-->
		<div>
			<div style="background-color: #F5F5F5;width: 95%; height:50px;border-bottom: 1px solid #EEE;
				margin: 0 auto;">
				<ul id="ul03" style="margin-left: -25px;" >
					    <li>您是不是想找：</li>
						<li><a>客厅灯&nbsp;|&nbsp;</a></li>
						<li><a>冲锋衣&nbsp;|&nbsp;</a></li>
						<li><a>床垫&nbsp;|&nbsp;</a></li>
						<li><a>沙发垫&nbsp;|&nbsp;</a></li>
						<li><a>男内裤&nbsp;|&nbsp;</a></li>
						<li><a>电脑桌&nbsp;|&nbsp;</a></li>
						<li><a>鞋柜&nbsp;|&nbsp;</a></li>
						<li><a>窗帘&nbsp;|&nbsp;</a></li>
						<li><a>椅子&nbsp;|&nbsp;</a></li>
						<li><a>男内裤&nbsp;|&nbsp;</a></li>
						<li><a>电脑桌&nbsp;|&nbsp;</a></li>
						<li><a>鞋柜&nbsp;|&nbsp;</a></li>
						<li><a>窗帘&nbsp;|&nbsp;</a></li>
						<li><a>椅子&nbsp;|&nbsp;</a></li>
				</ul>
				</div>
		</div>
		<!--条件筛选栏-->
		<div>
		<div style="width: 95%; height:50px;border: 1px solid #EEE;margin: 0 auto;margin-top: 10px;">
		    
		    <!--左边价格筛选-->
		    <div style="line-height: 50px;margin-left: 15px;display: inline;">
		    	价格：<input  type="text" name="minprice"/>&nbsp;—&nbsp;<input  type="text" name="maxprice"/>
		    </div>
		    <!--右边其他提示-->
			 <div style="line-height: 50px;display: inline;float: right;margin-right: 15px;" >
		    	 <input type="checkbox" value="包邮"  name="choice"/>包邮
		    	 <input type="checkbox" value="正品保障" name="choice"/>正品保障
		    	 <input type="checkbox" value="7天退换" name="choice"/>7天退换
		    	 <input type="checkbox" value="消费者保障" name="choice" />消费者保障
		    </div>
		</div>
		</div>
		<!--商品列表展示-->
		<div>
			<table width="96%" style="margin: auto;">
				<tr>
					<td width="20%" align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/1.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/2.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/3.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/4.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/5.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%" align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/6.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/7.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/8.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/9.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/10.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
				</tr>
				<tr>
					<td width="20%" align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/11.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/12.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/13.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/14.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
					<td  width="20%"align="center">
						<div style="border: 2px solid #EEE; padding: 5px;">
							<img src="bookcover/16.png" width="220px" height="280px"border="1" />
							<br>
							<div style="color: orange;">￥40.0 包邮</div>
							<div>世界上最好的商品</div>
							<div style="color: darkgray;font-size: small;">浪色服饰专营店</div>
							<div style="color: darkgray;font-size: small;text-align: right;">如实描述4.8</div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<!--底部栏-->
		<div style="margin-top: 100px; width:100%;height: 60px;margin-bottom: 30px;">
	         <div  style="width:96%;height: 30px;position: relative;left: 300px;top: 0px;">
				<ul id="ul04" >
				        <li><a>阿里巴巴集团&nbsp;|&nbsp;</a></li>
						<li><a>阿里巴巴网络：&nbsp;</a></li>
						<li><a>国际站&nbsp;</a></li>
						<li><a>中文站&nbsp;</a></li>
						<li><a>全球速卖通&nbsp;|&nbsp;</a></li>
						<li><a>淘宝网&nbsp;|&nbsp;</a></li>
						<li><a>天猫&nbsp;|&nbsp;</a></li>
						<li><a>一淘&nbsp;|&nbsp;</a></li>
						<li><a>阿里妈妈&nbsp;|&nbsp;</a></li>
						<li><a>阿里云&nbsp;|&nbsp;</a></li>
						<li><a>中国雅虎&nbsp;|&nbsp;</a></li>
						<li><a>支付宝&nbsp;|&nbsp;</a></li>
						<li><a>聚划算&nbsp;|&nbsp;</a></li>
						<li><a>更多</a></li>
				</ul>
			 </div>
			 <div style=" width:96%;height: 5px;margin: 0 auto;" align="center">
			 		 <hr  />
			 </div>
		 
		 	 <div  style="width:96%;height: 30px;margin-top: -15px;position: relative;left: 300px; right: 300px;">
		 	 	<ul id="ul04">
		 	            <li><a>关于淘宝&nbsp;</a></li>
						<li><a>合作伙伴&nbsp;</a></li>
						<li><a>营销中心&nbsp;</a></li>
						<li><a>联系客服&nbsp;</a></li>
						<li><a>开放平台&nbsp;</a></li>
						<li><a>诚征英才&nbsp;</a></li>
						<li><a>练习我们&nbsp;</a></li>
						<li><a>网站地图&nbsp;</a></li>
						<li><a>法律声明&nbsp;</a></li>
						<li><a>@copy;2016&nbsp;</a></li>
						<li><a>Taobao.com&nbsp;</a></li>
						<li><a>版权所有&nbsp;</a></li>
				</ul>
		 	</div>
		</div>
	</body>
</html>
```

#### 作业题

```
1、请实现京东页面的主页
```

#### 面试题

```
1、CSS 中类 (classes) 和 ID 的区别
对于CSS而言，id和class都是选择器，唯一不同的地方在于权重不同。

对于html而言，id和class都是dom元素的属性值。不同的地方在于id属性的值是唯一的，而class属性值可以重复。

id还一个老特性是锚点功能，当浏览器地址栏有一个#xxx，页面会自动滚动到id=xxx的元素上面。

2、请问 “resetting” 和 “normalizing” CSS 之间的区别？你会如何选择，为什么？
Normalize.css 是一个可定制的 CSS 文件，使浏览器呈现的所有元素，更一致和符合现代标准；是在现代浏览器环境下对于CSS reset的替代。 它正是针对只需要统一的元素样式。该项目依赖于研究浏览器默认元素风格之间的差异，精确定位需要重置的样式。

normalizing： 
保护有用的浏览器默认样式而不是完全去掉它们 
一般化的样式：为大部分HTML元素提供 
修复浏览器自身的bug并保证各浏览器的一致性 
优化CSS可用性：用一些小技巧 
解释代码：用注释和详细的文档来

Normalize.css 保护了有价值的默认值： 
Reset通过为几乎所有的元素施加默认样式，强行使得元素有相同的视觉效果。相比之下，Normalize.css保持了许多默认的浏览器样式。这就意味着你不用再为所有公共的排版元素重新设置样式。当一个元素在不同的浏览器中有不同的默认值时，Normalize.css会力求让这些样式保持一致并尽可能与现代标准相符合。

3、请解释浮动 (Floats) 及其工作原理。
float被归类于CSS 定位属性（Positioning） 
描述：规定框是否应该浮动。 
定义和用法：float 属性定义元素在哪个方向浮动。以往这个属性总应用于图像，使文本围绕在图像周围，不过在 CSS 中，任何元素都可以浮动。浮动元素会生成一个块级框，而不论它本身是何种元素。 
由于浮动框不在文档的普通流中，所以文档的普通流中的块框表现得就像浮动框不存在一样。

4、描述z-index和叠加上下文是如何形成的。
z-index 属性设置元素的堆叠顺序。拥有更高堆叠顺序的元素总是会处于堆叠顺序较低的元素的前面。 
注释：元素可拥有负的 z-index 属性值。 
注释：Z-index 仅能在定位元素上奏效（例如 position:absolute;）！

而凡是拥有层叠上下文的元素，将离用户最近，也就是越靠在Z轴前面。默认情况下只有根元素HTML会产生一个层叠上下文，并且元素一旦使用了一些属性也将会产生一个层叠上下文，如我们常用的定位属性。如两个层叠上下文相遇时，总是后一个层叠前一个，除非使用z-index来改变。

详情见： 
http://www.cnblogs.com/pssp/p/5948356.html

5、列举不同的清除浮动的技巧，并指出它们各自适用的使用场景。
1、对父级设置适合CSS高度 
2、clear:both清除浮动，但是需要新增一个空的div 
3、父级div定义 overflow:hidden 
4、父级div也一起浮动 
5、父级div定义 display:table

6、请描述伪元素 (pseudo-elements) 及其用途。
伪元素例如： 
:first-line / :first-letter / :befort / :after 
详情参见链接： 
http://www.w3school.com.cn/css/css_pseudo_elements.asp

7、请解释 inline 和 inline-block 的区别？
display:block 
block元素会独占一行，多个block元素会各自新起一行。默认情况下，block元素宽度自动填满其父元素宽度。 
block元素可以设置width,height属性。块级元素即使设置了宽度,仍然是独占一行。 
block元素可以设置margin和padding属性。
display:inline 
inline元素不会独占一行，多个相邻的行内元素会排列在同一行里，直到一行排列不下，才会新换一行，其宽度随元素的内容而变化。 
inline元素设置width,height属性无效。 
inline元素的margin和padding属性，水平方向的padding-left, padding-right, margin-left, margin-right都产生边距效果；但竖直方向的padding-top, padding-bottom, margin-top, margin-bottom不会产生边距效果。
display:inline-block 
简单来说就是将对象呈现为inline对象，但是对象的内容作为block对象呈现。之后的内联对象会被排列在同一行内。比如我们可以给一个link（a元素）inline-block属性值，使其既具有block的宽度高度特性又具有inline的同行特性。
8、你用过媒体查询，或针对移动端的布局/CSS 吗？
@media 
详见：http://www.runoob.com/cssref/css3-pr-mediaquery.html

9、如果设计中使用了非标准的字体，你该如何去实现？

@font-face 
详见：http://www.w3school.com.cn/css3/css3_font.asp

10、请解释 relative、fixed、absolute 和 static 元素的区别
static（静态定位）：默认值。没有定位，元素出现在正常的流中（忽略 top, bottom, left, right 或者 z-index 声明）。
relative（相对定位）：生成相对定位的元素，通过top,bottom,left,right的设置相对于其正常（原先本身）位置进行定位。可通过z-index进行层次分级。 
定位为relative的元素脱离正常的文本流中，但其在文本流中的位置依然存在。 
relative定位的层总是相对于其最近的父元素，无论其父元素是何种定位方式
absolute（绝对定位）：生成绝对定位的元素，相对于 static 定位以外的第一个父元素进行定位。元素的位置通过 “left”, “top”, “right” 以及 “bottom” 属性进行规定。可通过z-index进行层次分级。 
定位为absolute的层脱离正常文本流，但与relative的区别是其在正常流中的位置不再存在。 
对于absolute定位的层总是相对于其最近的定义为absolute或relative的父层，而这个父层并不一定是其直接父层。
fixed（固定定位）：生成绝对定位的元素，相对于浏览器窗口进行定位。元素的位置通过 “left”, “top”, “right” 以及 “bottom” 属性进行规定。可通过z-index进行层次分级。
注：使用static 定位或无position定位的元素z-index属性是无效的。

11、请罗列出你所知道的 display 属性的全部值
常见的包括： 
none、block、inline、inline-block、list-item、run-in、table、inline-table、table-row-group、table-header-group、table-footer-group、table-row、table-column-group、table-column、table-cell、table-caption、inherit

12、请解释你对盒模型的理解，以及如何在 CSS 中告诉浏览器使用不同的盒模型来渲染你的布局。
盒子模型分为两类：W3C标准盒子模型和IE盒子模型。这两者的关键差别就在于： 
W3C盒子模型——属性高（height）和属性宽（width）这两个值不包含 填充（padding）和边框（border） 
IE盒子模型——属性高（height）和属性宽（width）这两个值包含 填充（padding）和边框（border） 
我们在编写页面代码的时候应该尽量使用标准的W3C盒子模型（需要在页面中声明DOCTYPE类型）。

css中可使用hack或者wrapper。【CSS hack是通过在CSS样式中加入一些特殊的符号，让不同的浏览器识别不同的符号（什么样的浏览器识别什么样的符号是有标准的，CSS hack就是让你记住这个标准），以达到应用不同的CSS样式的目的】

13、请解释 * { box-sizing: border-box; } 的作用, 并且说明使用它有什么好处？
大致就是说，在盒模型中，元素的高和宽包括了边框和内边距，详见： 
http://www.w3school.com.cn/cssref/pr_box-sizing.asp

14、你熟悉 SVG 样式的书写吗？
SVG为可缩放矢量图形，详见： 
http://www.w3school.com.cn/svg/index.asp

15、CSS 中字母 ‘C’ 的意思是叠层 (Cascading)。请问在确定样式的过程中优先级是如何决定的 (请举例)？如何有效使用此系统？
样式的优先级 
多重样式（Multiple Styles）：如果外部样式、内部样式和内联样式同时应用于同一个元素，就是使多重样式的情况。 
一般情况下，优先级如下： 
（外部样式）External style sheet <（内部样式）Internal style sheet <（内联样式）Inline style 
有个例外的情况，就是如果外部样式放在内部样式的后面，则外部样式将覆盖内部样式。

选择器的优先权： 
1. 内联样式表的权值最高 1000； 
2. ID 选择器的权值为 100 
3. Class 类选择器的权值为 10 
4. HTML 标签选择器的权值为 1

CSS 优先级法则： 
1. 选择器都有一个权值，权值越大越优先； 
2. 当权值相等时，后出现的样式表设置要优于先出现的样式表设置； 
3. 创作者的规则高于浏览者：即网页编写者设置的CSS 样式的优先权高于浏览器所设置的样式； 
4. 继承的CSS 样式不如后来指定的CSS 样式； 
5. 在同一组属性设置中标有“!important”规则的优先级最大；

16、为什么响应式设计 (responsive design) 和自适应设计 (adaptive design) 不同？
自适应是为了解决如何在不同大小的设备上呈现同样的网页（网页的主题和内容不改变） 
响应式的概念覆盖了自适应，而且涵盖的内容更多。 
自适应暴露的一个问题，如果屏幕太小，即使网页能够根据屏幕大小进行适配，但是会感觉在小屏幕上查看内容太过拥挤。响应式正是针对这个问题衍生出的概念。它可以自动识别屏幕宽度、并做出相应调整的网页设计、布局和展示的内容可能会有所改变。

17、在书写高效 CSS 时会有哪些问题需要考虑？
（1）避免使用全局样式 
既然是全局的定义，那么他会吧所有标签都处理一遍，增加了浏览器解析的时间。有些标签其实没有必要处理。 
允许一个元素去继承它的祖先，或者使用一个class去应用复杂的元素。 
（2）将规则写的越精确越好 
偏向使用class ，id，少使用tag 
另外定义class时使用一些有代表意义的单词，比如在模块化开发的过程中，一般用mod-xxx，很利于维护，代码也很漂亮， 
（3）移除一些无用的限定 
下面的这些限定是多余的 
1.id选择器被class 或者tag选择器限定，也就是不要在id前面添加任何限定符，包括class tag 或者其他的选择符。 
2.class被tag选择器进行限定（如果一个class只被用于一个tag，这也是很好的实践） 
（4）避免使用后代选择器，特别是包含了一些无用的祖先元素 
eg：body ul li a{…} 制定了一个无用的body限定，因为所有的元素都是在body中。 
（5）使用class选择器取代后代选择器，CSS 的层级选择器不要超过3个 
eg：如果你需要两个不同的样式（一个无序列表，一个有序列表） 
不要使用下面的样式 
ul li {color:blue} ol li {color:red} 
应该这样的使用 .unordered-list-item {color: blue;} .ordered-list-item {color: red;} 
如果你一定要用后代选择器，建议你使用子选择器 
（6）display与visibility的差异 
他们用于设置或检索是否显示对象。display隐藏对象不保留物理空间，visibility为隐藏对象保留占据的物理空间。当浏览器渲染被占据的物理空间时，会有所消耗资源。所以不赞成用visibility:hidden; 
（7）border:none;与border:0;的区别 
有些同学肯定没注意过这两个代码的区别，在HTML显示肯定是一样的，但是从基本上来说他们不一样 用border:0虽然现实上和none没什么区别，但是它会保留color、style 这两个属性。所以不赞成用border:0; 
（8）不宜过小的背景图片平铺 
（9）代码缩写

18、使用 CSS 预处理器的优缺点有哪些？
缺点：简单来说CSS预处理器语言较CSS玩法变得更高级了，但同时降低了自己对最终代码的控制力。更致命的是提高了门槛，首先是上手门槛，其次是维护门槛，再来是团队整体水平和规范的门槛。这也造成了初学学习成本的昂贵。另外，预编译CSS步骤的加入，让我们开发工作流中多了一个环节，调试也变得更麻烦了。 
优点：用一种专门的编程语言，为CSS增加了一些编程的特性，将CSS作为目标生成文件，然后开发者就只要使用这种语言进行编码工作。通俗的说，CSS预处理器用一种专门的编程语言，进行Web页面样式设计，然后再编译成正常的CSS文件，以供项目使用。CSS预处理器为CSS增加一些编程的特性，无需考虑浏览器的兼容性问题，例如你可以在CSS中使用变量、简单的逻辑程序、函数等等在编程语言中的一些基本特性，可以让你的CSS更加简洁、适应性更强、可读性更佳，更易于代码的维护等诸多好处。
```