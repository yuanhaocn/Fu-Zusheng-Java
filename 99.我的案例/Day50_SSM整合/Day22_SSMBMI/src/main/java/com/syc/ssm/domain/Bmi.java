package com.syc.ssm.domain;

public class Bmi {
	
    private Integer id;
    private String recordtime;
    private String height;
    private String weight;
    private String bmi;
    private String bmisign;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(String recordtime) {
        this.recordtime = recordtime == null ? null : recordtime.trim();
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi == null ? null : bmi.trim();
    }

    public String getBmisign() {
        return bmisign;
    }

    public void setBmisign(String bmisign) {
        this.bmisign = bmisign == null ? null : bmisign.trim();
    }
}