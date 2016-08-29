package com.group.yztcedu.fblife.main.forum.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/8/6.
 */
public class SubBean {
    @SerializedName("fid")
    private int fid;
    @SerializedName("name")
    private String name;
    @SerializedName("isfavorite")
    private int isfavorite;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(int isfavorite) {
        this.isfavorite = isfavorite;
    }


}
