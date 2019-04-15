package com.syc.book.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syc.book.exception.OrderException;
import com.syc.book.service.IOrderService;
import com.syc.book.service.impl.OrderServiceImpl;
import com.syc.book.utils.PaymentUtil;

/**
 * 处理易宝支付返回的通知信息
 * 
 * @类名称:CallBackServlet
 * @创建人:SYC
 * @创建时间:2017年8月8日 上午11:03:50
 */
public class CallBackServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 接收支付完成后第三方返回的数据
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");// 支付结果码，1表示支付成功
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");// 订单编号
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");// 1:重定向，2：点对点
		String hmac = request.getParameter("hmac");

		// 验证回传信息.
		boolean result = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid,
				r6_Order, r7_Uid, r8_MP, r9_BType, "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");// 密钥

		PrintWriter out = response.getWriter();

		if (!result) {
			out.write("订单信息可能被篡改了,请注意支付是否安全!");
		} else {
			if ("1".equals(r1_Code)) {
				// 说明支付成功
				if ("2".equals(r9_BType)) {
					out.print("success");// 给第三方返回"success"
				}
				try {
					// 修改订单的支付状态
					IOrderService orderService = new OrderServiceImpl();
					// 修改订单状态
					orderService.modifyOrderState(r6_Order);
				} catch (OrderException e) {
					out.println(e.getMessage());
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}