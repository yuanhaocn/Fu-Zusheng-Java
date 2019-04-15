package com.syc.commons.pojo;

import java.io.Serializable;

/**
 *  为商品分类提供的树形节点
 */
public class ZTreeNode implements Serializable {

    /**
     * 父节点id
     */
    private Integer pId;

    /**
     * 节点id
     */
    private Integer id;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 是否是父节点.
     * 注意:该属性中是isParent,对应的get和set方法分别是
     * getIsParent()和setIsParent()方法,必须是这样的方法,否则前端页面的树形控件展示不正确!
     */
    private Boolean isParent;

    /**
     * 是否展开
     */
    private Boolean open;

    /**
     * 状态值
     */
    private Integer status;

    /**
     * 排序
     */
    private Integer sortOrder;

    /**
     * 节点数量?
     */
    private Integer num;

    /**
     * 用不着
     */
    private String remark;

    /**
     * 图标
     */
    private String icon;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

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
        this.name = name;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean parent) {
        isParent = parent;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
