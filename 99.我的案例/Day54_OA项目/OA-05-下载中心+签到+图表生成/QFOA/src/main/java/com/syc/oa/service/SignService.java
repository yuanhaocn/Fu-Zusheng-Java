package com.syc.oa.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.syc.oa.domain.TbSign;
import com.syc.oa.vo.PageBean;
import com.syc.oa.vo.SignChart;

/**
 * 签到管理的接口
 */
public interface SignService {
    
	/**
     * 添加签到打卡信息
     */
    public boolean addSign(Integer uid);

    /**
     * 查询签到打卡信息
     */
    public PageBean<TbSign> findSign(Map<String, Object> map) throws ParseException;

    /**
     * 判断用户是否已经签到打卡
     */
    public boolean isSign(Integer uid, String today);

    /**
     * 查询签到打卡的图表数据统计
     */
    public List<SignChart> findSignChart(String beginDay);
    
}
