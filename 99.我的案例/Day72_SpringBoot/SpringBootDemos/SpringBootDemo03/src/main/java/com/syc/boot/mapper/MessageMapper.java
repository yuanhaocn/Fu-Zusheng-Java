package com.syc.boot.mapper;

import com.syc.boot.domain.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mybatis在 springboot 项目中可以通过注解的方式使用 sql 语句.
 * 如果出现如下异常信息:
 * Description:
 * Field mapper in com.demo.service.impl.UserServiceImpl required a bean of type 'com.demo.mapper.UserMapper' that could not be found.
 * Action:
 * Consider defining a bean of type 'com.demo.mapper.UserMapper' in your configuration.
 * 解决方案:
 * 1.在Mapper接口类上添加注解@Mapper;
 * 2.在Application(启动类)上面添加@MapperScan(value = "com.syc.boot.mapper")
 */
@Mapper
public interface MessageMapper {

    //#{name}:参数占位符
    @Select("select * from tb_msg where name=#{name}")
    List<Message> findMsgByName(String name);

    @Select("select * from tb_msg where id = #{id}")
    Message getById(long id);

    @Select("select name from tb_msg where id = #{id}")
    String getNameById(long id);

    /**
     * 保存数据.
     */
    @Insert("insert into tb_msg(msg,name) values(#{msg},#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(Message msg);
}
