package com.group.yztcedu.fblife.main.home.bean;

import com.google.gson.annotations.SerializedName;

public class HomeViewPagerNewsBean {
        @SerializedName("type")
        private int type;
        @SerializedName("id")
        private String id;
        @SerializedName("photo")
        private String photo;
        @SerializedName("title")
        private String title;
        @SerializedName("stitle")
        private String stitle;
        @SerializedName("link")
        private String link;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

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

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }