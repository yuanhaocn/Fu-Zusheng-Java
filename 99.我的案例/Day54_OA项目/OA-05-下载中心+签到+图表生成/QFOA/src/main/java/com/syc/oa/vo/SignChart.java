package com.syc.oa.vo;

/**
 * SignCharts,
 * 给E-charts提供数据支持
 */
public class SignChart {
   
    private String day;//签到打卡日期

    private long num;//签到打卡人数

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }
}
