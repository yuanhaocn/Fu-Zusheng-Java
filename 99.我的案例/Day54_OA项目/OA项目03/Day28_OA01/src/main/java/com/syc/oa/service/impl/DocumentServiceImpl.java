package com.syc.oa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syc.oa.domain.TbDoc;
import com.syc.oa.domain.TbDocExample;
import com.syc.oa.domain.TbUser;
import com.syc.oa.mapper.TbDocMapper;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.DocumentService;
import com.syc.oa.vo.PageBean;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private TbDocMapper docMapper;

	@Autowired
	private TbUserMapper userMapper;

	@Override
	public boolean saveDocument(TbDoc document) {
		try {
			// 关联查询tb_user表
			TbUser user = userMapper.selectByPrimaryKey(document.getUid());
			document.setUser(user);

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date createdate = format.parse(format.format(new Date()));
			document.setCreatedate(createdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return docMapper.insertSelective(document) > 0;
	}

	@Override
	public PageBean<TbDoc> selectDocument(String title) {

		TbDocExample example = new TbDocExample();
		example.createCriteria().andTitleLike("%" + title + "%");
		List<TbDoc> docs = docMapper.selectByExampleWithBLOBs(example);

		for (TbDoc doc : docs) {
			doc.setUser(userMapper.selectByPrimaryKey(doc.getUid()));
		}

		PageBean<TbDoc> bean = new PageBean<>();
		bean.setRows(docs);
		bean.setTotal(docs.size());

		return bean;
	}

	@Override
	public void removeOne(Integer id) {
		docMapper.deleteByPrimaryKey(id);
	}

	@Override
	public boolean removeMore(Integer[] ids) {
		TbDocExample example = new TbDocExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		return docMapper.deleteByExample(example)>0;
	}

}
