package com.group.yztcedu.fblife.main.carbarn.entity;

/**
 * Created by Administrator on 2016/8/10.
 */
public class Vehicle {
    private String name;
    private String sortedKey;
    private String brand;

    public Vehicle(String name,String brand){
        this.name=name;
        this.brand=brand;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSortedKey() {
        return sortedKey;
    }

    public void setSortedKey(String sortedKey) {
        this.sortedKey = sortedKey;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
