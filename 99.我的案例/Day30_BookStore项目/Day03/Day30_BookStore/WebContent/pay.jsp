<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>电子书城--在线支付</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	</head>

	<body>
		<form action="${pageContext.request.contextPath }/payOnLineServlet" method="post">
			订单号:<input TYPE="text" NAME="orderId" value="${orderId}"> 
			支付金额：<input TYPE="text" NAME="money" value="0.01">元
			<!-- 支付金额：<input TYPE="text" NAME="money" value="${money}">元 -->
			<div class="divBank">
				<div class="divText">选择网上银行</div>
				<div style="margin-left: 20px;">
					<div style="margin-bottom: 20px;">
						<input id="ICBC-NET-B2C" type="radio" name="bank" value="ICBC-NET-B2C" checked="checked" />
						<img name="ICBC-NET-B2C" align="middle" src="bank_img/icbc.bmp" /> 
						<input id="CMBCHINA-NET-B2C" type="radio" name="bank" value="CMBCHINA-NET-B2C" />
						<img name="CMBCHINA-NET-B2C" align="middle" src="bank_img/cmb.bmp"/> 
						<input id="ABC-NET-B2C" type="radio" name="bank" value="ABC-NET-B2C" /> 
						<img name="ABC-NET-B2C" align="middle" src="bank_img/abc.bmp"/> 
						<input id="CCB-NET-B2C" type="radio" name="bank" value="CCB-NET-B2C" />
						<img name="CCB-NET-B2C" align="middle" src="bank_img/ccb.bmp" />
					</div>
					<div style="margin-bottom: 20px;">
						<input id="BCCB-NET-B2C" type="radio" name="bank" value="BCCB-NET-B2C" /> 
						<img name="BCCB-NET-B2C" align="middle" src="bank_img/bj.bmp" /> 
						<input id="BOCO-NET-B2C" type="radio" name="bank" value="BOCO-NET-B2C" />
						<img name="BOCO-NET-B2C" align="middle" src="bank_img/bcc.bmp" />
						<input id="CIB-NET-B2C" type="radio" name="bank" value="CIB-NET-B2C" /> 
						<img name="CIB-NET-B2C" align="middle" src="bank_img/cib.bmp" /> 
						<input id="NJCB-NET-B2C" type="radio" name="bank" value="NJCB-NET-B2C" />
						<img name="NJCB-NET-B2C" align="middle" src="bank_img/nanjing.bmp" />
					</div>
					<div style="margin-bottom: 20px;">
						<input id="CMBC-NET-B2C" type="radio" name="bank" value="CMBC-NET-B2C" /> 
						<img name="CMBC-NET-B2C" align="middle" src="bank_img/cmbc.bmp" /> 
						<input id="CEB-NET-B2C" type="radio" name="bank" value="CEB-NET-B2C" /> 
						<img name="CEB-NET-B2C" align="middle" src="bank_img/guangda.bmp" /> 
						<input id="BOC-NET-B2C" type="radio" name="bank" value="BOC-NET-B2C" /> 
						<img name="BOC-NET-B2C" align="middle" src="bank_img/bc.bmp" /> 
						<input id="PINGANBANK-NET" type="radio" name="bank" value="PINGANBANK-NET" />
						<img name="PINGANBANK-NET" align="middle" src="bank_img/pingan.bmp" />
					</div>
					<div style="margin-bottom: 20px;">
						<input id="CBHB-NET-B2C" type="radio" name="bank" value="CBHB-NET-B2C" /> 
						<img name="CBHB-NET-B2C" align="middle" src="bank_img/bh.bmp" /> 
						<input id="HKBEA-NET-B2C" type="radio" name="bank" value="HKBEA-NET-B2C" />
						<img name="HKBEA-NET-B2C" align="middle" src="bank_img/dy.bmp" />
						<input id="NBCB-NET-B2C" type="radio" name="bank" value="NBCB-NET-B2C" />
						<img name="NBCB-NET-B2C" align="middle" src="bank_img/ningbo.bmp" /> 
						<input id="ECITIC-NET-B2C" type="radio" name="bank" value="ECITIC-NET-B2C" />
						<img name="ECITIC-NET-B2C" align="middle" src="bank_img/zx.bmp" />
					</div>
					<div style="margin-bottom: 20px;">
						<input id="SDB-NET-B2C" type="radio" name="bank" value="SDB-NET-B2C" />
						<img name="SDB-NET-B2C" align="middle" src="bank_img/sfz.bmp" /> 
						<input id="GDB-NET-B2C" type="radio" name="bank" value="GDB-NET-B2C" /> 
						<img name="GDB-NET-B2C" align="middle" src="bank_img/gf.bmp" /> 
						<input id="SHB-NET-B2C" type="radio" name="bank" value="SHB-NET-B2C" />
						<img name="SHB-NET-B2C" align="middle" src="bank_img/sh.bmp" /> 
						<input id="SPDB-NET-B2C" type="radio" name="bank" value="SPDB-NET-B2C" />
						<img name="SPDB-NET-B2C" align="middle" src="bank_img/shpd.bmp" />
					</div>
					<div style="margin-bottom: 20px;">
						<input id="POST-NET-B2C" type="radio" name="bank" value="POST-NET-B2C" /> 
						<img name="POST-NET-B2C" align="middle" src="bank_img/post.bmp" /> 
						<input id="BJRCB-NET-B2C" type="radio" name="bank" value="BJRCB-NET-B2C" />
						<img name="BJRCB-NET-B2C" align="middle" src="bank_img/beijingnongshang.bmp" />
						<input id="HXB-NET-B2C" type="radio" name="bank" value="HXB-NET-B2C" /> 
						<img name="HXB-NET-B2C" align="middle" src="bank_img/hx.bmp" />
						<input id="CZ-NET-B2C" type="radio" name="bank" value="CZ-NET-B2C" /> 
						<img name="CZ-NET-B2C" align="middle" src="bank_img/zheshang.bmp" />
					</div>
				</div>
				<div style="margin: 40px;">
					<INPUT TYPE="submit" value="确定支付">
				</div>
			</div>
		</form>
	</body>
</html>
