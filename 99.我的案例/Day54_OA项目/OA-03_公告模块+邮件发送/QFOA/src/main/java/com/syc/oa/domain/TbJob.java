package com.syc.oa.domain;

public class TbJob {
    private Integer id;

    private String name;

    private String remanrk;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemanrk() {
        return remanrk;
    }

    public void setRemanrk(String remanrk) {
        this.remanrk = remanrk == null ? null : remanrk.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}