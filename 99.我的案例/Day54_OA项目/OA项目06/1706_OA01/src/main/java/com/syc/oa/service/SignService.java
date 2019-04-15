package com.syc.oa.service;

import java.util.List;

import com.syc.oa.domain.TbSign;
import com.syc.oa.vo.PageBean;
import com.syc.oa.vo.SignChart;

public interface SignService {

	boolean isSign(Integer uid,String today);
	
	PageBean<TbSign> selectSign(String startDate,String endDate);

	boolean addSign(Integer uid);

	//进行图表查询
	List<SignChart> selectChart(String beginDay);
}
