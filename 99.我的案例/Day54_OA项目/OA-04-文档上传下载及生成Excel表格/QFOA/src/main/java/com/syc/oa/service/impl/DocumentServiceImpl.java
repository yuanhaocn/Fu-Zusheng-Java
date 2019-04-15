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
 * 下载中心的实现类
 */
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private TbDocMapper docMapper;

	@Autowired
	private TbUserMapper userMapper;

	/**
	 * 添加文档
	 */
	@Override
	public boolean saveDocument(Integer uid, TbDoc document) {
		try {
			// 多表关联查询
			TbUser user = userMapper.selectByPrimaryKey(uid);
			document.setUser(user);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date createDate = format.parse(format.format(new Date()));
			document.setCreateDate(createDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return docMapper.insertSelective(document) > 0;
	}

	/**
	 * 文档查询
	 */
	@Override
	public PageBean<TbDoc> selectDocument(Map<String, Object> map) {
		String title = (String) map.get("title");
		TbDocExample example = new TbDocExample();
		Criteria criteria = example.createCriteria();
		criteria.andTitleLike("%" + title + "%");
		List<TbDoc> docs = docMapper.selectByExampleWithBLOBs(example);

		// 关联查询
		for (TbDoc doc : docs) {
			Integer uid = doc.getUid();
			TbUser user = userMapper.selectByPrimaryKey(uid);
			doc.setUser(user);
		}

		// 进行分页
		PageBean<TbDoc> bean = new PageBean<>();
		bean.setRows(docs);
		bean.setTotal(docs.size());

		return bean;
	}

	/**
	 * 单个删除
	 */
	@Override
	public boolean removeById(Integer id) {
		return docMapper.deleteByPrimaryKey(id) > 0;
	}

	/**
	 * 批量删除
	 */
	@Override
	public boolean removeMore(Integer[] ids) {
		TbDocExample example = new TbDocExample();
		Criteria criteria = example.createCriteria();
		//for (int i = 0; i < ids.length; i++) {
			criteria.andIdIn(Arrays.asList(ids));
		//}

		return docMapper.deleteByExample(example) > 0;
	}

}
