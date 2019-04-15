package com.syc.boot.domain;

import java.util.List;

/**
 *
 */
public class Contact {
    private Integer id;
    private String name;
    private List<City> citys;

    public Contact() {
    }

    public Contact(Integer id, String name, List<City> citys) {
        this.id = id;
        this.name = name;
        this.citys = citys;
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

    public List<City> getCitys() {
        return citys;
    }

    public void setCitys(List<City> citys) {
        this.citys = citys;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", citys=" + citys +
                '}';
    }
}
