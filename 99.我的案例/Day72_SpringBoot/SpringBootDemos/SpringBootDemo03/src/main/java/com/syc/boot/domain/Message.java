package com.syc.boot.domain;

import java.io.Serializable;

/**
 *
 */
public class Message implements Serializable {

    private Integer id;
    private String msg;
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
}
