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
import com.syc.oa.util.MailUtil;
import com.syc.oa.vo.PageBean;

/**
 * 公告管理模块
 * 
 * @类名称:NoticeController
 * @创建人:一一哥
 * @创建时间:2018年3月5日 上午9:22:59
 */
@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/notice/selectNotice")
	public String showNotice() {

		return "notice/notice";
	}

	// 公告查询
	@RequestMapping("/adviceJson")
	@ResponseBody
	public PageBean<TbAdvice> selectNotice(@RequestParam(defaultValue = "", required = false) String title,
			@RequestParam(defaultValue = "", required = false) String content) {

		return noticeService.selectNotice(title);
	}

	/**
	 * 添加公告
	 * 
	 * @throws IOException
	 */
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

	/**
	 * 编辑公告
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/notice/updateNotice")
	public String updateNotice(Integer flag, Integer id, Model model, TbAdvice advice, HttpServletResponse response)
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

	/**
	 * 删除公告
	 */
	@RequestMapping("/notice/removeNotice")
	public String deleteNotice(Integer flag, Integer id, @RequestParam(value = "ids[]", required = false) Integer[] ids,HttpServletResponse response)
			throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			noticeService.removeOne(id);
			return "notice/notice";
		} else {
			if(noticeService.removeMore(ids)){
				writer.print("success");
			}else{
				writer.print("error");
			}
		}
		return null;
	}
	
	/**
	 * 预览功能
	 */
	@ResponseBody
	@RequestMapping("/notice/prenotice")
	public TbAdvice previewNotice(Integer id){
		return noticeService.selectById(id);
	}
	
	/**
	 * 发送邮件
	 * @throws IOException 
	 */
	@RequestMapping("/notice/addEmail")
	public String sendMail(Integer flag,String email,String title,String content,HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		if(flag==1){
			return "notice/showAddEmail";
		}else{
			//TODO:实现真正的邮件发送
			if(MailUtil.sendMail(email, title, content)){
				writer.print("success");
			}else{
				writer.print("error");
			}
		}
		return null;
	}

}
