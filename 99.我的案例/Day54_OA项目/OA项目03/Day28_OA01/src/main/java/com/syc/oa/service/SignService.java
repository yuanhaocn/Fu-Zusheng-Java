package com.syc.oa.service;

import java.util.List;

import com.syc.oa.domain.TbSign;
import com.syc.oa.vo.PageBean;
import com.syc.oa.vo.SignChart;

public interface SignService {

	public boolean isSign(Integer uid, String today);

	public PageBean<TbSign> selectSign(String startDate, String endDate);

	public boolean addSign(Integer uid);

	public List<SignChart> selectChartData(String beginDay);
}
