package com.syc.oa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * @类名称:NoticeController
 * @创建人:一一哥
 * @创建时间:2017年11月4日 下午6:07:45
 */
@Controller
public class NoticeController {

	@Autowired
	@Qualifier("noticeService")
	private NoticeService noticeService;

	/**
	 * 跳转到公告管理
	 */
	@RequestMapping("/notice/selectNotice")
	public String showAvice() {
		return "notice/notice";
	}

	/**
	 * 添加公告
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/notice/addNotice")
	public String addNotice(Integer flag, Integer uid, TbAdvice advice, HttpServletResponse response)
			throws IOException {
		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			// 跳转
			return "notice/showAddNotice";
		} else {
			// 进行真正的添加操作
			if (noticeService.addNotice(uid, advice)) {
				writer.print("success");
			} else {
				writer.print("error");
			}
		}

		return null;
	}

	/**
	 * 查询公告
	 */
	@RequestMapping("/adviceJson")
	@ResponseBody
	public PageBean<TbAdvice> adviceJson(@RequestParam(defaultValue = "", required = false) String title,
			@RequestParam(defaultValue = "", required = false) String content) {

		Map<String, Object> map = new HashMap<>();
		map.put("title", title);
		// map.put("content", content);

		return noticeService.selectAdvice(map);
	}

	/**
	 * 编辑公告
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/notice/updateNotice")
	public String updateNotice(Integer flag, Integer id, TbAdvice advice, Model model, HttpServletResponse response)
			throws IOException {

		PrintWriter writer = response.getWriter();
		if (flag == 1) {
			model.addAttribute("notice", noticeService.selectAdviceById(id));
			// 跳转
			return "notice/showUpdateNotice";
		} else {
			// 进行真正的添加操作
			if (noticeService.editNotice(advice)) {
				writer.print("success");
			} else {
				writer.print("error");
			}
		}
		return null;
	}

	/**
	 * 删除公告
	 * 
	 * @throws IOException
	 */
	@RequestMapping("/notice/removeNotice")
	public String removeNotice(Integer flag, Integer id, @RequestParam(value = "ids[]", required = false) Integer[] ids,
			HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();

		boolean result;

		if (flag == 1) {// 单个删除
			result = noticeService.removeById(id);
			return "redirect:/notice/selectNotice";
		} else {// 批量删除
			result = noticeService.removeMore(ids);
		}
		
		if (result) {
			writer.print("success");
		} else {
			writer.print("error");
		}
		
		return null;
	}
	
	/**
	 * 预览功能
	 */
	@RequestMapping("/notice/prenotice")
	@ResponseBody
	public TbAdvice preNotice(Integer id){
		
		return noticeService.selectAdviceById(id);
	}
	
	@RequestMapping("/notice/addEmail")
	public String sendMail(Integer flag,String email,String title,String content,HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		
		if(flag==1){
			return "notice/showAddEmail";
		}else{
			//发送邮件
			if(MailUtil.sendMail(email,title,content)){
				writer.print("success");
			}else{
				writer.print("error");
			}
		}
		return null;
	}
	
}
