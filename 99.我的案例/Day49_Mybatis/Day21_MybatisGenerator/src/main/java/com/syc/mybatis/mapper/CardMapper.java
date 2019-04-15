package com.syc.mybatis.mapper;

import com.syc.mybatis.domain.Card;
import com.syc.mybatis.domain.CardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CardMapper {
    long countByExample(CardExample example);

    int deleteByExample(CardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Card record);

    int insertSelective(Card record);

    List<Card> selectByExample(CardExample example);

    Card selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Card record, @Param("example") CardExample example);

    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
}