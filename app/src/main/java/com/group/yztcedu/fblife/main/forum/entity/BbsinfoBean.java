package com.group.yztcedu.fblife.main.forum.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/6.
 */
public class BbsinfoBean {

    @SerializedName("gid")
    private int gid;
    @SerializedName("name")
    private String name;
    /**
     * fid : 17
     * name : 竞技家
     * isfavorite : 0
     */

    @SerializedName("sub")
    private List<SubBean> sub;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubBean> getSub() {
        return sub;
    }

    public void setSub(List<SubBean> sub) {
        this.sub = sub;
    }


}
