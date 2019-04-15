package com.syc.commons.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 给前端表格封装的JavaBean
 */
public class DataTableResult implements Serializable{

    private Boolean success;

    private String error;

    /**
     * 商品总数量
     */
    private Integer recordsTotal;

    /**
     * 符合条件的商品总数量
     */
    private Integer recordsFiltered;

    /**
     * 分页结果中封装的商品信息数据
     */
    private List<?> data;

    //private Integer draw;//没什么用?

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    //public Integer getDraw() {
    //    return draw;
    //}

    //public void setDraw(Integer draw) {
    //this.draw = draw;
    //}

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
