package com.group.yztcedu.fblife.main.home.bean;

import com.google.gson.annotations.SerializedName;

public  class NewCarInfoBean {
        @SerializedName("id")
        private String id;
        @SerializedName("photo")
        private String photo;
        @SerializedName("title")
        private String title;
        @SerializedName("stitle")
        private String stitle;
        @SerializedName("publishtime")
        private String publishtime;
        @SerializedName("summary")
        private String summary;
        @SerializedName("comment")
        private String comment;
        @SerializedName("likes")
        private String likes;
        @SerializedName("newstype")
        private String newstype;
        @SerializedName("jumpurl")
        private String jumpurl;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
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

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getLikes() {
            return likes;
        }

        public void setLikes(String likes) {
            this.likes = likes;
        }

        public String getNewstype() {
            return newstype;
        }

        public void setNewstype(String newstype) {
            this.newstype = newstype;
        }

        public String getJumpurl() {
            return jumpurl;
        }

        public void setJumpurl(String jumpurl) {
            this.jumpurl = jumpurl;
        }
    }