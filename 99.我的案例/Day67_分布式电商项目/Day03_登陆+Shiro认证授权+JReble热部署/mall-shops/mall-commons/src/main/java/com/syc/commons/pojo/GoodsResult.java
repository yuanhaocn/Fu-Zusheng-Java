package com.syc.commons.pojo;

import java.util.List;

public class GoodsResult {

    private long total;

    private List<?> data;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GoodsResult{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
