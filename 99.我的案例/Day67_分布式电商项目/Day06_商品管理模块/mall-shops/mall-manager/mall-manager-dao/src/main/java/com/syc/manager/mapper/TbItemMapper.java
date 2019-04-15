package com.syc.manager.mapper;

import com.syc.manager.pojo.TbItem;
import com.syc.manager.pojo.TbItemExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TbItemMapper {
    long countByExample(TbItemExample example);

    int deleteByExample(TbItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbItem record);

    int insertSelective(TbItem record);

    List<TbItem> selectByExample(TbItemExample example);

    TbItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByExample(@Param("record") TbItem record, @Param("example") TbItemExample example);

    int updateByPrimaryKeySelective(TbItem record);

    int updateByPrimaryKey(TbItem record);

    /**
     * 按条件查询商品列表
     * search:查询条件;
     * orderColumn:待排序的列;
     * orderOperator:排序的关键字,asc或desc
     */
    List<TbItem> selectItemByCondition(@Param("cid") int cid, @Param("search") String search, @Param("orderColumn") String orderColumn, @Param("orderOperator") String orderOperator);

    /**
     * 多条件查询商品列表
     * search:查询条件;
     * orderColumn:待排序的列;
     * orderOperator:排序的关键字,asc或desc
     */
    List<TbItem> selectItemByMultiCondition(@Param("cid") int cid,@Param("search") String search,@Param("minDate") String minDate,
                                            @Param("maxDate") String maxDate,@Param("orderCol") String orderCol,
                                            @Param("orderDir") String orderDir);
}