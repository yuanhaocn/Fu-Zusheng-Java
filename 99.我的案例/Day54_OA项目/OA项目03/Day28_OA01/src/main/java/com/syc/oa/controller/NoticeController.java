package com.syc.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.syc.oa.domain.TbAdvice;
import com.syc.oa.service.NoticeService;
import com.syc.oa.utils.MailUtil;
import com.syc.oa.vo.PageBean;

/**
 * 公告管理模块
 */
@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/notice/selectNotice")
	public String ShowNotice() {
		return "notice/notice";
	}

	// 公告查询
	@ResponseBody
	@RequestMapping("/noticeJson")
	public PageBean<TbAdvice> selectNotice(@RequestParam(defaultValue = "", required = false) String title,
			@RequestParam(defaultValue = "", required = false) String content) {
		return noticeService.selectNotice(title);
	}

	// 添加公告
	@RequestMapping("/notice/addNotice")
	public String addNotice(Integer flag, TbAdvice advice, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			return "notice/showAddNotice";
		} else {
			if (noticeService.addNotice(advice)) {
				writer.print("success");
			} else {
				writer.print("error");
			}
		}
		return null;
	}

	// 修改公告
	@RequestMapping("/notice/updateNotice")
	public String updateNotice(Integer flag, Model model, Integer id, TbAdvice advice, HttpServletResponse response)
			throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			model.addAttribute("notice", noticeService.selectById(id));
			return "notice/showUpdateNotice";
		} else {
			if (noticeService.updateNotice(advice)) {
				writer.print("success");
			} else {
				writer.print("error");
			}
		}
		return null;
	}

	// 删除公告
	@RequestMapping("/notice/removeNotice")
	public String removeNotice(Integer flag, Integer id,
			@RequestParam(value = "ids[]", required = false) Integer[] ids) {
		if (flag == 1) {// 单个删除
			noticeService.removeOne(id);
			return "dept/dept";
		} else {// 批量删除
			noticeService.removeMore(ids);
			return "dept/dept";
		}
	}

	// 预览功能
	@ResponseBody
	@RequestMapping("/notice/prenotice")
	public TbAdvice preNotice(Integer id) {
		return noticeService.selectById(id);
	}

	// 发送邮件
	@RequestMapping("/notice/addEmail")
	public String sendMail(Integer flag, String email, String title, String content,HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			return "notice/showAddEmail";
		} else {
			if(MailUtil.sendMail(email, title, content)){
				writer.print("success");
			}else{
				writer.print("error");
			}
		}
		return null;
	}
}
