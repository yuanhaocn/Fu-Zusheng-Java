package com.yan.dao.mapper.role;

import com.yan.dao.model.role.RoleMenuRel;
import com.yan.dao.model.role.RoleMenuRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMenuRelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    long countByExample(RoleMenuRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    int deleteByExample(RoleMenuRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    int deleteByPrimaryKey(String relId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    int insert(RoleMenuRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    int insertSelective(RoleMenuRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    List<RoleMenuRel> selectByExample(RoleMenuRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    RoleMenuRel selectByPrimaryKey(String relId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    int updateByExampleSelective(@Param("record") RoleMenuRel record, @Param("example") RoleMenuRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    int updateByExample(@Param("record") RoleMenuRel record, @Param("example") RoleMenuRelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    int updateByPrimaryKeySelective(RoleMenuRel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ROLE_MENU_REL
     *
     * @mbg.generated Tue Sep 19 11:16:58 CST 2017
     */
    int updateByPrimaryKey(RoleMenuRel record);
}