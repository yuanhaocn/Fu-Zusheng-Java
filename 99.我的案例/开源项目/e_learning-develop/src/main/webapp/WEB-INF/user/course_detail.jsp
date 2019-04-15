<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>课程详情</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"/>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<!---- start-smoth-scrolling---->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

 <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
<!---End-smoth-scrolling---->
</head>

<body class="bcg">
	<div class="t">
		<div class="t_n">
			<div class="r_nr"><a href="#">我的学习</a>&nbsp;<a href="#">消息<em id="msg_num">2</em></a>&nbsp;<a href="#">购物车<em id="buy_num">1</em></a>&nbsp;<a href="#">登录/注册</a></div>
		</div>
	</div>
	<div class="header" style="height: 80px">
		<div class="container">
			<div class="header-top">
				<div class="logo">
					ANG English
				</div>
				<div class="top-menu">
					<span class="menu"><img src="images/nav.png" alt=""/> </span>
					<ul>
						<li><a href="index.html" class="active">主页</a></li>
						<li><a href="course.html">课程</a></li>
						<li><a href="word.html">单词</a></li>
						<li><a href="about.html">关于</a></li>
						<li><a href="service.html">服务</a></li>
						<li><a href="contact.html">联系</a></li>
					</ul>
				</div>
				<div class="search">
					<div class="b-search">
						<form>
							<input type="text" value="课程搜索" onfocus="this.value = ''" onblur="if (this.value == '') {this.value = 'Search here';}">
							<input type="submit" value="">
						</form>
					</div>
				</div>
				<!--script-nav-->
				 <script>
						 $("span.menu").click(function(){
						 $(".top-menu ul").slideToggle("slow" , function(){
						 });
						 });
						 </script>
					<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--services-->
	<div class="content">
		<div class="incredible">
				<div class="container">
					<div >
						<ul class="breadcrumb" contenteditable="true">
							<li>​<a href="index.html">主页</a></li>
							<li><a href="course.html">课程</a></li>
							<li><a href="course_intro.html">生活英语</a></li>
							<li><a class="active" href="this">课程详情</a></li>
						</ul>
					</div>
					<div class="course_detail">
						<div class="container-fluid">
							<div class="course_intro">
								<div class="intro_left">
									<div class="course_img"><a href="#"><img  src="images/free1.jpg" /></a></div>									
								</div>
								<div class="intro_right">				
										<div class="title">
											<h3>宝宝启蒙英语</h3>
										</div>
										<div class="intro_info">
											<ul>
												<li class="first_li">
													<i class="fa fa-user"></i>&nbsp;参加人数：
												</li>
												<li id="join_num">
													1200
												</li>
												<li>
													讲师：
												</li>
												<li id="teacher">
													God Tang
												</li>
											</ul>
											
										</div>
										<div class="course_score">
											<ul>
												<li>评分：</li>
												<li class="fa fa-star"></li>
												<li class="fa fa-star"></li>
												<li class="fa fa-star"></li>
												<li class="fa fa-star-o"></li>
												<li class="fa fa-star-o"></li>
											</ul>
										</div>
										<div class="clearfix"></div>		
								</div>
								<div class="clearfix"></div>	
							</div>
							<div class="pro_info">
								<div>
									<div class="progress">
										<div class="progress-bar progress-bar-success" style="width: 70%"></div>
									</div>
									<div class="keep_learn">
										<button class="btn btn-success" onclick="">继续学习</button>
									</div>
									<div class="clearfix"></div>
								</div>
								<div><p>目前已完成<span>12</span>个课时，加油！</p></div>
							</div>
							<div class="clearfix"></div>
							<div class="cg_detail">
								<div class="intro_dis">
									<div class="tabbable" id="tabs-942631"><!-- Only required for left/right tabs -->
										<ul class="nav nav-tabs">
											<li class="active"><a  data-toggle="tab" href="#panel-904948">目录</a></li>
											<li class=""><a  data-toggle="tab" href="#panel-392684">讨论区</a></li>
										</ul>
										<!--左边的目录和讨论区公用块-->
										<div class="tab-content">
											<div class="tab-pane active cg_chapter" contenteditable="true" id="panel-904948">
												<ul>
													<li>
														<ul><h4>章节<em class="chapter">1</em></h4>
															<li>课时<span>1</span>&nbsp;<i class="fa fa-circle-o"></i>
																<a href="course_play.html">Hi!I'm Judy!</a>
															</li>
															<li>课时<span>2</span>&nbsp;<i class="fa fa-circle-o"></i>
																<a href="course_play.html">Hello,Everyone!</a>
															</li>
														</ul>
													</li>
													<li>
														<ul><h4>章节<em class="chapter">2</em></h4>
															<li>课时<span>3</span>&nbsp;<i class="fa fa-circle-o"></i>
																<a href="course_play.html">I have a nice mother</a>
															</li>
															<li>课时<span>4</span>&nbsp;<i class="fa fa-circle-o"></i>
																<a href="course_play.html">Do you like play with dolls?</a>
															</li>
															<li>课时<span>5</span>&nbsp;<i class="fa fa-circle-o"></i>
																<a href="course_play.html">Hi!I'm Judy!</a>
															</li>
														</ul>
													</li>
													<li>
														<ul><h4>章节<em class="chapter">3</em></h4>
															<li>课时<span>6</span>&nbsp;<i class="fa fa-circle-o"></i>
																<a href="course_play.html">Hi!I'm Judy!</a>
															</li>
															<li>课时<span>7</span>&nbsp;<i class="fa fa-circle-o"></i>
																<a href="course_play.html">Hi!I'm Judy!</a>
															</li>
														</ul>
													</li>

												</ul>
											</div>

											<div class="tab-pane" contenteditable="true" id="panel-392684">
												<div>
													<div class=" all_discuss">
														<div class="solo_discuss">
															<dl>
																<dt>
																	<img class="img-circle" src="images/icon.jpg"/><p>章鱼小丸子</p><p>17:33</p>
																</dt>
																<dd>老师讲解的很详细！</dd>
															</dl>
															<hr>
														</div>
														<div class="solo_discuss">
															<dl>
																<dt>
																	<img class="img-circle" src="images/free1.jpg"/><p>黄老板</p><p>17:12</p>
																</dt>
																<dd>棒棒棒！</dd>
															</dl>
															<hr>
														</div>
														<div class="solo_discuss">
															<dl>
																<dt>
																	<img class="img-circle" src="images/free2.jpg"/><p>向老师</p><p>16:23</p>
																</dt>
																<dd>听GodTang讲的课就是停不下来！</dd>
															</dl>
															<hr>
														</div>
														<div class="solo_discuss">
															<dl>
																<dt>
																	<img class="img-circle" src="images/free3.jpg"/><p>秀秀</p><p>15:10</p>
																</dt>
																<dd>老师讲解的很详细！</dd>
															</dl>
															<hr>
														</div>			
														<div class="solo_discuss">
															<dl>
																<dt>
																	<img class="img-circle" src="images/free3.jpg"/><p>秀秀</p><p>15:10</p>
																</dt>
																<dd>老师讲解的很详细！</dd>
															</dl>
															<hr>
														</div>									
													</div>

													
												</div>											
											</div>
										</div>
										<!--右边评分栏目-->
										<div class="makescore">
											<div>
													<p>评价：</p>
													<div class="rating">
														<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
													</div>
											</div>
											<div class="p_discuss">
												<textarea value="">快来评价一下课程吧！</textarea>
												<button class="btn btn-success" onclick="">提交评论</button>
											</div>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>

							</div>
						</div>
					</div>
			</div>
		</div>
	</div>
	<!--footer-->
	<div class="footer-section">
		<div class="container">
			<div class="footer-top">
				<p>Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://www.cssmoban.com/">ANG 英语在线学习平台</a></p>
			</div>
			<script type="text/javascript">
						$(document).ready(function() {
							/*
							var defaults = {
					  			containerID: 'toTop', // fading element id
								containerHoverID: 'toTopHover', // fading element hover id
								scrollSpeed: 1200,
								easingType: 'linear' 
					 		};
							*/
							
							$().UItoTop({ easingType: 'easeOutQuart' });
							
						});
					</script>
			<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
		</div>
	</div>
</body>

</html>