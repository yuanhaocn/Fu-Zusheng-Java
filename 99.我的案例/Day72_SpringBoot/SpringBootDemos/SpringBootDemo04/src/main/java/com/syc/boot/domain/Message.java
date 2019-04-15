package com.syc.boot.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * jpa中的映射关系类
 */
@Entity
@Table(name = "tb_msg")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String msg;

    @Column
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Message)) return false;
        Message msg = (Message) o;
        if (!id.equals(msg.id)) return false;
        if (!name.equals(msg.name)) return false;
        if (!msg.equals(msg.msg)) return false;
        if (this == o) {
            return true;
        }
        return false;
    }
}
