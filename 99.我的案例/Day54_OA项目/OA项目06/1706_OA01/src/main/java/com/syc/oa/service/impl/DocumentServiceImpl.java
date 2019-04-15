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
import com.syc.oa.domain.TbDocExample.Criteria;
import com.syc.oa.mapper.TbDocMapper;
import com.syc.oa.mapper.TbUserMapper;
import com.syc.oa.service.DocumentService;
import com.syc.oa.vo.PageBean;

/**
 * 文档管理的实现类
 * @类名称:DocumentServiceImpl
 * @创建人:一一哥
 * @创建时间:2018年3月6日 上午9:25:26
 */
@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private TbDocMapper docMapper;
	
	@Autowired
	private TbUserMapper userMapper;
	
	@Override
	public PageBean<TbDoc> selectDocument(String title) {
		TbDocExample example=new TbDocExample();
		Criteria criteria = example.createCriteria();
		criteria.andTitleLike("%"+title+"%");
		List<TbDoc> docs = docMapper.selectByExampleWithBLOBs(example);
		
		for(TbDoc doc : docs){
			doc.setUser(userMapper.selectByPrimaryKey(doc.getUid()));
		}
		
		PageBean<TbDoc> bean=new PageBean<>();
		bean.setRows(docs);
		bean.setTotal(docs.size());
		
		return bean;
	}

	@Override
	public void removeOne(Integer id) {
		docMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void removeMore(Integer[] ids) {
		TbDocExample example=new TbDocExample();
		example.createCriteria().andIdIn(Arrays.asList(ids));
		docMapper.deleteByExample(example);
	}

	@Override
	public boolean saveDocument(TbDoc document) {
		try {
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			document.setCreatedate(format.parse(format.format(new Date())));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return docMapper.insertSelective(document)>0;
	}

}
