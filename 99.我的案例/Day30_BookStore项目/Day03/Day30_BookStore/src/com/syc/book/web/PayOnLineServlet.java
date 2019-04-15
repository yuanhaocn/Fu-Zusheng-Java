
package com.syc.book.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.utils.PaymentUtil;

/**
 * 处理在线支付的Servlet
 * 
 * @类名称:PayOnLineServlet
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午10:44:53
 */
public class PayOnLineServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String orderId = request.getParameter("orderId");
		String money = request.getParameter("money");
		String bank = request.getParameter("bank");

		// 在支付前把数据组织成第三方需要的格式
		String p0_Cmd = "Buy";
		//商家的账号
		String p1_MerId = "10001126856";
		String p2_Order = orderId;
		String p3_Amt = money;
		String p4_Cur = "CNY";
		//商家的名称
		String p5_Pid = "bugaosuni";
		String p6_Pcat = "eat";
		String p7_Pdesc = "good";
		// 支付完成后第三方请求的资源路径---->回调地址.
		String p8_Url = request.getContextPath() + "/callBackServlet";
		String p9_SAF = "1";
		String pa_MP = "idon'tknow";
		String pd_FrpId = bank;
		String pr_NeedResponse = "1";
		//把以上信息进行字符串拼接,拼接之后还要把字符串进行加密
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse,
				"69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");// 密钥

		// String
		// url="https://www.yeepay.com/app-merchant-proxy/node?p0_Cmd"+p0_Cmd+"&p1_MerId="+p1_MerId

		request.setAttribute("p0_Cmd", p0_Cmd);
		request.setAttribute("p1_MerId", p1_MerId);
		request.setAttribute("p2_Order", p2_Order);
		request.setAttribute("p3_Amt", p3_Amt);
		request.setAttribute("p4_Cur", p4_Cur);
		request.setAttribute("p5_Pid", p5_Pid);
		request.setAttribute("p6_Pcat", p6_Pcat);
		request.setAttribute("p7_Pdesc", p7_Pdesc);
		request.setAttribute("p8_Url", p8_Url);
		request.setAttribute("p9_SAF", p9_SAF);
		request.setAttribute("pa_MP", pa_MP);
		request.setAttribute("pd_FrpId", pd_FrpId);
		request.setAttribute("hmac", hmac);
		request.setAttribute("pr_NeedResponse", pr_NeedResponse);

		// 跳转到支付确认页面
		request.getRequestDispatcher("/confirm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}