package com.syc.oa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.oa.domain.TbDoc;
import com.syc.oa.domain.TbDocExample;
import com.syc.oa.domain.TbDocExample.Criteria;
import com.syc.oa.domain.TbUser;
import com.syc.oa.mapper.TbDocMapper;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.DocumentService;
import com.syc.oa.vo.PageBean;

/**
 * 下载中心模块的Service实现类----文档查询及添加
 * 
 * @类名称:DocumentServiceImpl
 * @创建人:SYC
 * @创建时间:2017年11月3日 上午9:50:08
 */

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private TbUserMapper userMapper;

	@Autowired
	private TbDocMapper docMapper;

	/**
	 * 保存文档
	 */
	@Override
	public boolean saveDocument(Integer uid, TbDoc document) {
		try {
			TbUser user = userMapper.selectByPrimaryKey(uid);
			document.setUser(user);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
			document.setCreateDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return docMapper.insertSelective(document) > 0;
	}

	/**
	 * 文档查询实现方法
	 */
	@Override
	public PageBean<TbDoc> findDocument(Map<String, Object> map) {
		String title = (String) map.get("title");
		TbDocExample example = new TbDocExample();
		example.createCriteria().andTitleLike("%" + title + "%");

		// List<TbDoc> docs = docMapper.selectByExample(example);
		// 要使用该方法,否则remark字段会查不到,因为是大文本类型!
		List<TbDoc> docs = docMapper.selectByExampleWithBLOBs(example);

		// 关联查询设置
		for (TbDoc doc : docs) {
			Integer uid = doc.getUid();
			TbUser user = userMapper.selectByPrimaryKey(uid);
			doc.setUser(user);

			doc.getUser().setDocuments(null);
			doc.getUser().setSigns(null);
		}

		// 分页设置
		PageBean<TbDoc> bean = new PageBean<>();
		bean.setRows(docs);
		bean.setTotal(docs.size());

		return bean;
	}

	/**
	 * 删除单个文档的实现
	 */
	@Override
	public boolean removeOne(Integer id) {

		return docMapper.deleteByPrimaryKey(id) > 0;
	}

	/**
	 * 批量删除文档的实现
	 */
	@Override
	public boolean removeMore(Integer[] ids) {
		TbDocExample example = new TbDocExample();
		Criteria criteria = example.createCriteria();
		for (int i = 0; i < ids.length; i++) {
			criteria.andIdIn(Arrays.asList(ids));
		}

		return docMapper.deleteByExample(example) > 0;
	}

}
