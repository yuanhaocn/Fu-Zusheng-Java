package com.syc.manager.mapper;

import com.syc.manager.pojo.TbUser;
import com.syc.manager.pojo.TbUserExample;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface TbUserMapper {
    long countByExample(TbUserExample example);

    int deleteByExample(TbUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbUser record);

    int insertSelective(TbUser record);

    List<TbUser> selectByExample(TbUserExample example);

    TbUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByExample(@Param("record") TbUser record, @Param("example") TbUserExample example);

    int updateByPrimaryKeySelective(TbUser record);

    int updateByPrimaryKey(TbUser record);

    /**
     * 额外添加的获取某个用户角色的方法
     */
    Set<String> getRoles(@Param("username") String username);

    /**
     * 额外添加的获取某个用户权限的方法
     */
    Set<String> getPermissions(@Param("username") String username);
}