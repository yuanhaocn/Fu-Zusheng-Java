package com.syc.ssm.mapper;

import com.syc.ssm.domain.Bmi;
import com.syc.ssm.domain.BmiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BmiMapper {
    long countByExample(BmiExample example);

    int deleteByExample(BmiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bmi record);

    int insertSelective(Bmi record);

    List<Bmi> selectByExample(BmiExample example);

    Bmi selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Bmi record, @Param("example") BmiExample example);

    int updateByExample(@Param("record") Bmi record, @Param("example") BmiExample example);

    int updateByPrimaryKeySelective(Bmi record);

    int updateByPrimaryKey(Bmi record);
}