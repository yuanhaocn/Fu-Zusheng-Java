package com.syc.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syc.oa.domain.TbSign;
import com.syc.oa.domain.TbSignExample;
import com.syc.oa.vo.SignChart;

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
    
    List<SignChart> selectChart(String createTime);
}