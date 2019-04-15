package com.syc.oa.mapper;

import com.syc.oa.domain.TbSign;
import com.syc.oa.domain.TbSignExample;
import com.syc.oa.vo.SignChart;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSignMapper {
    long countByExample(TbSignExample example);

    int deleteByExample(TbSignExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSign record);

    int insertSelective(TbSign record);

    List<TbSign> selectByExample(TbSignExample example);

    TbSign selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSign record, @Param("example") TbSignExample example);

    int updateByExample(@Param("record") TbSign record, @Param("example") TbSignExample example);

    int updateByPrimaryKeySelective(TbSign record);

    int updateByPrimaryKey(TbSign record);
    
    /**
     * 自定义接口方法.
     * 查询tb_sign,为签到图表提供数据!
     */
    public List<SignChart> findSignChart(String beginDay);
}