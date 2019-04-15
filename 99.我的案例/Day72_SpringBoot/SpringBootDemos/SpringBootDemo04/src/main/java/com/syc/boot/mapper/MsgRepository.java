package com.syc.boot.mapper;

import com.syc.boot.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA 的Repository接口,内置了一些查询等sql方法
 */
public interface MsgRepository extends JpaRepository<Message,Integer> {
}
