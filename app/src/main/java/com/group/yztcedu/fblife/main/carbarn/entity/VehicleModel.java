package com.group.yztcedu.fblife.main.carbarn.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class VehicleModel {


    /**
     * errno : 0
     * count : 8
     * series : [{"id":"145","name":"大切诺基（进口）","pid":"136","groupid":"1","priority":"8","type":"全领域","carfrom":"进口","fwords":"D","words":"grandcherokee","nwords":"大切诺基","series_price_min":"559900","series_price_max":"759900","size":"中型 ","price_range":"50-100万","price":"0","carnum":"0","picnum":"0","content":"","area":"","fid":"234","photo":"http://carport.fblife.com/attachments/series/44/14030170682196.jpg.192x128.jpg","url":"http://","recommend":"0"},{"id":"149","name":"牧马人","pid":"136","groupid":"1","priority":"2","type":"硬派","carfrom":"进口","fwords":"M","words":"wrangler","nwords":"牧马人","series_price_min":"429500","series_price_max":"599900","size":"中型 ","price_range":"30-50万","price":"0","carnum":"0","picnum":"0","content":"","area":"","fid":"233","photo":"http://carport.fblife.com/attachments/series/60/14222840284976.jpg.192x128.jpg","url":"http://","recommend":"1"},{"id":"151","name":"指南者","pid":"136","groupid":"1","priority":"36","type":"城市","carfrom":"进口","fwords":"Z","words":"compass","nwords":"指南者","series_price_min":"221900","series_price_max":"280900","size":"中型 ","price_range":"20-30万","price":"0","carnum":"0","picnum":"0","content":"","area":"","fid":"501","photo":"http://carport.fblife.com/attachments/series/30/14223309101515.jpg.192x128.jpg","url":"http://","recommend":"0"},{"id":"152","name":"自由客","pid":"136","groupid":"1","priority":"36","type":"城市","carfrom":"进口","fwords":"Z","words":"patriot","nwords":"自由客","series_price_min":"221900","series_price_max":"276900","size":"中型 ","price_range":"20-30万","price":"0","carnum":"0","picnum":"0","content":"","area":"","fid":"536","photo":"http://carport.fblife.com/attachments/series/57/14223400253375.jpg.192x128.jpg","url":"http://","recommend":"0"},{"id":"1847","name":"自由光（进口）","pid":"136","groupid":"1","priority":"8","type":"全领域","carfrom":"进口","fwords":"Z","words":"cherokee","nwords":"自由光","series_price_min":"371900","series_price_max":"529900","size":"中型 ","price_range":"30-50万","price":"0","carnum":"0","picnum":"0","content":"","area":"","fid":"665","photo":"http://carport.fblife.com/attachments/series/34/14224944345935.jpg.192x128.jpg","url":"http://","recommend":"0"},{"id":"3235","name":"大切诺基SRT","pid":"136","groupid":"1","priority":"0","type":"全领域","carfrom":"SRT","fwords":"D","words":"grandcherokee_sr","nwords":"大切诺基SRT","series_price_min":"1204900","series_price_max":"1204900","size":"中型 ","price_range":"100万以上","price":"0","carnum":"0","picnum":"0","content":"","area":"","fid":"234","photo":"http://carport.fblife.com/attachments/series/34/14223398744150.jpg.192x128.jpg","url":"","recommend":"0"},{"id":"4051","name":"自由侠","pid":"136","groupid":"1","priority":"0","type":"城市","carfrom":"进口","fwords":"R","words":"renegade","nwords":"自由侠","series_price_min":"141800","series_price_max":"202800","size":"小型 ","price_range":"10-20万","price":"0","carnum":"0","picnum":"0","content":"","area":"","fid":"297","photo":"http://carport.fblife.com/attachments/series/32/14223401283090.jpg.192x128.jpg","url":"","recommend":"0"},{"id":"5388","name":"自由光","pid":"136","groupid":"1","priority":"0","type":"城市","carfrom":"广汽菲克","fwords":"Z","words":"cherokee_guochan","nwords":"自由光","series_price_min":"209800","series_price_max":"315800","size":"中型 ","price_range":"20-30万","price":"0","carnum":"0","picnum":"0","content":"","area":"","fid":"665","photo":"http://carport.fblife.com/attachments/series/6/14466034621354.jpg.192x128.jpg","url":"","recommend":"0"}]
     */

    @SerializedName("errno")
    private int errno;
    @SerializedName("count")
    private int count;
    /**
     * id : 145
     * name : 大切诺基（进口）
     * pid : 136
     * groupid : 1
     * priority : 8
     * type : 全领域
     * carfrom : 进口
     * fwords : D
     * words : grandcherokee
     * nwords : 大切诺基
     * series_price_min : 559900
     * series_price_max : 759900
     * size : 中型
     * price_range : 50-100万
     * price : 0
     * carnum : 0
     * picnum : 0
     * content :
     * area :
     * fid : 234
     * photo : http://carport.fblife.com/attachments/series/44/14030170682196.jpg.192x128.jpg
     * url : http://
     * recommend : 0
     */

    @SerializedName("series")
    private List<SeriesBean> series;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<SeriesBean> getSeries() {
        return series;
    }

    public void setSeries(List<SeriesBean> series) {
        this.series = series;
    }
}
