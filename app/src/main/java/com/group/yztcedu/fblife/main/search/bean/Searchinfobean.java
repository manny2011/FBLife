package com.group.yztcedu.fblife.main.search.bean;

import com.google.gson.annotations.SerializedName;

public  class Searchinfobean {
        @SerializedName("tid")
        private String tid;
        @SerializedName("fid")
        private String fid;
        @SerializedName("title")
        private String title;
        @SerializedName("content")
        private String content;
        @SerializedName("dateline")
        private String dateline;
        @SerializedName("fromtype")
        private String fromtype;
        @SerializedName("url")
        private String url;
        @SerializedName("newstype")
        private String newstype;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getFromtype() {
            return fromtype;
        }

        public void setFromtype(String fromtype) {
            this.fromtype = fromtype;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNewstype() {
            return newstype;
        }

        public void setNewstype(String newstype) {
            this.newstype = newstype;
        }
    }