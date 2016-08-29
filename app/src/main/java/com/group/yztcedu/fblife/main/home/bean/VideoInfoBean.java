package com.group.yztcedu.fblife.main.home.bean;

import com.google.gson.annotations.SerializedName;

public class VideoInfoBean {
        @SerializedName("uid")
        private String uid;
        @SerializedName("username")
        private String username;
        @SerializedName("title")
        private String title;
        @SerializedName("summary")
        private String summary;
        @SerializedName("views")
        private String views;
        @SerializedName("publishtime")
        private String publishtime;
        @SerializedName("user_id")
        private String userId;
        @SerializedName("video_id")
        private String videoId;
        @SerializedName("video_name")
        private String videoName;
        @SerializedName("video_duration")
        private String videoDuration;
        @SerializedName("media_id")
        private String mediaId;
        @SerializedName("add_time")
        private String addTime;
        @SerializedName("qrurl")
        private String qrurl;
        @SerializedName("play_url")
        private String playUrl;
        /**
         * backup_url_1 : aHR0cDovL2JwbGF5LmczcHJveHkubGVjbG91ZC5jb20vdm9kL3YyL01qTTRMelV6THpFd05TOWlZMnh2ZFdRdk1UQXhOVGsyTDNabGNsOHdNRjh5TWkweE1EVTROekV6TlRZM0xXRjJZeTAwTWpBME5USXRZV0ZqTFRNeU1EUTVMVEV3T1RrMk1DMDJNelF6TVRBNExUazJPV1V4TUdSa016Um1PRFJsWkRKaE5qSXpPR05pTURWbFpETTROV0kyTFRFME56QXpPRGszT0RjME5ETXViWEEwP2I9NDYwJm1tc2lkPTIwMjExOTIyOSZ0bT0xNDcwNDc4OTEwMzUxJnBpcD1hZjc1ZWYyYzc2YzRkY2Y4ODQ3ZTdlNTlhMTUxYmVjNCZrZXk9MGNjZmQxNjAxNTQ2MzU3M2Y2NzY0ZjA0NjIwZmRlYTUmcGxhdGlkPTImc3BsYXRpZD0yMDYmcGF5ZmY9MCZjdWlkPTEwMTU5NiZ2dHlwZT0xMyZkdXI9MTA5JnAxPTMmcDI9MzEmcDM9MzEwJmNmPWg1LWFuZHJvaWQmcD0xMDEmcGxheWlkPTAmdHNzPW5vJnRhZz1tb2JpbGUmc2lnbj1iY2xvdWRfMTAxNTk2JnRlcm1pZD0yJnBheT0wJm9zdHlwZT1hbmRyb2lkJmh3dHlwZT11bg==
         * backup_url_2 : aHR0cDovLzExNy4xMjEuNTQuMjE5L3ZvZC92Mi9Nak00THpVekx6RXdOUzlpWTJ4dmRXUXZNVEF4TlRrMkwzWmxjbDh3TUY4eU1pMHhNRFU0TnpFek5UWTNMV0YyWXkwME1qQTBOVEl0WVdGakxUTXlNRFE1TFRFd09UazJNQzAyTXpRek1UQTRMVGsyT1dVeE1HUmtNelJtT0RSbFpESmhOakl6T0dOaU1EVmxaRE00TldJMkxURTBOekF6T0RrM09EYzBORE11YlhBMD9iPTQ2MCZtbXNpZD0yMDIxMTkyMjkmdG09MTQ3MDQ3ODkxMDM1MSZwaXA9YWY3NWVmMmM3NmM0ZGNmODg0N2U3ZTU5YTE1MWJlYzQma2V5PTBjY2ZkMTYwMTU0NjM1NzNmNjc2NGYwNDYyMGZkZWE1JnBsYXRpZD0yJnNwbGF0aWQ9MjA2JnBheWZmPTAmY3VpZD0xMDE1OTYmdnR5cGU9MTMmZHVyPTEwOSZwMT0zJnAyPTMxJnAzPTMxMCZjZj1oNS1hbmRyb2lkJnA9MTAxJnBsYXlpZD0wJnRzcz1ubyZ0YWc9bW9iaWxlJnNpZ249YmNsb3VkXzEwMTU5NiZ0ZXJtaWQ9MiZwYXk9MCZvc3R5cGU9YW5kcm9pZCZod3R5cGU9dW4=
         * backup_url_3 : aHR0cDovL3BsYXkuZzNwcm94eS5sZWNsb3VkLmNvbS92b2QvdjIvTWpNNEx6VXpMekV3TlM5aVkyeHZkV1F2TVRBeE5UazJMM1psY2w4d01GOHlNaTB4TURVNE56RXpOVFkzTFdGMll5MDBNakEwTlRJdFlXRmpMVE15TURRNUxURXdPVGsyTUMwMk16UXpNVEE0TFRrMk9XVXhNR1JrTXpSbU9EUmxaREpoTmpJek9HTmlNRFZsWkRNNE5XSTJMVEUwTnpBek9EazNPRGMwTkRNdWJYQTA/Yj00NjAmbW1zaWQ9MjAyMTE5MjI5JnRtPTE0NzA0Nzg5MTAzNTEmcGlwPWFmNzVlZjJjNzZjNGRjZjg4NDdlN2U1OWExNTFiZWM0JmtleT0wY2NmZDE2MDE1NDYzNTczZjY3NjRmMDQ2MjBmZGVhNSZwbGF0aWQ9MiZzcGxhdGlkPTIwNiZwYXlmZj0wJmN1aWQ9MTAxNTk2JnZ0eXBlPTEzJmR1cj0xMDkmcDE9MyZwMj0zMSZwMz0zMTAmY2Y9aDUtYW5kcm9pZCZwPTEwMSZwbGF5aWQ9MCZ0c3M9bm8mcmV0cnk9MSZ0YWc9bW9iaWxlJnNpZ249YmNsb3VkXzEwMTU5NiZ0ZXJtaWQ9MiZwYXk9MCZvc3R5cGU9YW5kcm9pZCZod3R5cGU9dW4=
         * definition : 高清
         * gbr : 460
         * main_url : http://play.g3proxy.lecloud.com/vod/v2/MjM4LzUzLzEwNS9iY2xvdWQvMTAxNTk2L3Zlcl8wMF8yMi0xMDU4NzEzNTY3LWF2Yy00MjA0NTItYWFjLTMyMDQ5LTEwOTk2MC02MzQzMTA4LTk2OWUxMGRkMzRmODRlZDJhNjIzOGNiMDVlZDM4NWI2LTE0NzAzODk3ODc0NDMubXA0?b=460&mmsid=202119229&tm=1470478910351&pip=af75ef2c76c4dcf8847e7e59a151bec4&key=0ccfd16015463573f6764f04620fdea5&platid=2&splatid=206&payff=0&cuid=101596&vtype=13&dur=109&p1=3&p2=31&p3=310&cf=h5-android&p=101&playid=0&tss=no&tag=mobile&sign=bcloud_101596&termid=2&pay=0&ostype=android&hwtype=un
         * sharpness : high
         * storePath : 238/53/105/bcloud/101596/ver_00_22-1058713567-avc-420452-aac-32049-109960-6343108-969e10dd34f84ed2a6238cb05ed385b6-1470389787443.mp4
         * vheight : 544
         * vtype : 13
         * vwidth : 960
         */

        @SerializedName("video_url")
        private VideoUrlBean videoUrl;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getPublishtime() {
            return publishtime;
        }

        public void setPublishtime(String publishtime) {
            this.publishtime = publishtime;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public String getVideoName() {
            return videoName;
        }

        public void setVideoName(String videoName) {
            this.videoName = videoName;
        }

        public String getVideoDuration() {
            return videoDuration;
        }

        public void setVideoDuration(String videoDuration) {
            this.videoDuration = videoDuration;
        }

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getAddTime() {
            return addTime;
        }

        public void setAddTime(String addTime) {
            this.addTime = addTime;
        }

        public String getQrurl() {
            return qrurl;
        }

        public void setQrurl(String qrurl) {
            this.qrurl = qrurl;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public VideoUrlBean getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(VideoUrlBean videoUrl) {
            this.videoUrl = videoUrl;
        }

        public static class VideoUrlBean {
            @SerializedName("backup_url_1")
            private String backupUrl1;
            @SerializedName("backup_url_2")
            private String backupUrl2;
            @SerializedName("backup_url_3")
            private String backupUrl3;
            @SerializedName("definition")
            private String definition;
            @SerializedName("gbr")
            private int gbr;
            @SerializedName("main_url")
            private String mainUrl;
            @SerializedName("sharpness")
            private String sharpness;
            @SerializedName("storePath")
            private String storePath;
            @SerializedName("vheight")
            private int vheight;
            @SerializedName("vtype")
            private String vtype;
            @SerializedName("vwidth")
            private int vwidth;

            public String getBackupUrl1() {
                return backupUrl1;
            }

            public void setBackupUrl1(String backupUrl1) {
                this.backupUrl1 = backupUrl1;
            }

            public String getBackupUrl2() {
                return backupUrl2;
            }

            public void setBackupUrl2(String backupUrl2) {
                this.backupUrl2 = backupUrl2;
            }

            public String getBackupUrl3() {
                return backupUrl3;
            }

            public void setBackupUrl3(String backupUrl3) {
                this.backupUrl3 = backupUrl3;
            }

            public String getDefinition() {
                return definition;
            }

            public void setDefinition(String definition) {
                this.definition = definition;
            }

            public int getGbr() {
                return gbr;
            }

            public void setGbr(int gbr) {
                this.gbr = gbr;
            }

            public String getMainUrl() {
                return mainUrl;
            }

            public void setMainUrl(String mainUrl) {
                this.mainUrl = mainUrl;
            }

            public String getSharpness() {
                return sharpness;
            }

            public void setSharpness(String sharpness) {
                this.sharpness = sharpness;
            }

            public String getStorePath() {
                return storePath;
            }

            public void setStorePath(String storePath) {
                this.storePath = storePath;
            }

            public int getVheight() {
                return vheight;
            }

            public void setVheight(int vheight) {
                this.vheight = vheight;
            }

            public String getVtype() {
                return vtype;
            }

            public void setVtype(String vtype) {
                this.vtype = vtype;
            }

            public int getVwidth() {
                return vwidth;
            }

            public void setVwidth(int vwidth) {
                this.vwidth = vwidth;
            }
        }
    }