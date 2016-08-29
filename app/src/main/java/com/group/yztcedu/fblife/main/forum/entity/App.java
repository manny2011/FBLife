package com.group.yztcedu.fblife.main.forum.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
public class App {
    @SerializedName("id")
    private String id;
    @SerializedName("tid")
    private String tid;
    @SerializedName("title")
    private String title;
    @SerializedName("stitle")
    private String stitle;
    @SerializedName("storeid")
    private String storeid;
    @SerializedName("business")
    private String business;
    @SerializedName("classid")
    private String classid;
    @SerializedName("channelid")
    private String channelid;
    @SerializedName("channel_name")
    private String channelName;
    @SerializedName("bbsfid")
    private String bbsfid;
    @SerializedName("forumname")
    private String forumname;
    @SerializedName("photosize")
    private String photosize;
    @SerializedName("publishtime")
    private String publishtime;
    @SerializedName("type")
    private String type;
    @SerializedName("likes")
    private String likes;
    @SerializedName("comment")
    private String comment;
    @SerializedName("shownum")
    private Object shownum;
    @SerializedName("photo")
    private List<String> photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStitle() {
        return stitle;
    }

    public void setStitle(String stitle) {
        this.stitle = stitle;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getChannelid() {
        return channelid;
    }

    public void setChannelid(String channelid) {
        this.channelid = channelid;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getBbsfid() {
        return bbsfid;
    }

    public void setBbsfid(String bbsfid) {
        this.bbsfid = bbsfid;
    }

    public String getForumname() {
        return forumname;
    }

    public void setForumname(String forumname) {
        this.forumname = forumname;
    }

    public String getPhotosize() {
        return photosize;
    }

    public void setPhotosize(String photosize) {
        this.photosize = photosize;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Object getShownum() {
        return shownum;
    }

    public void setShownum(Object shownum) {
        this.shownum = shownum;
    }

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }

}
