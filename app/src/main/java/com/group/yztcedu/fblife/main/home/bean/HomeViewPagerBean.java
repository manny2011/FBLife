package com.group.yztcedu.fblife.main.home.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
public class HomeViewPagerBean {

    /**
     * errno : 0
     * pages : 5
     * news : [{"type":1,"id":"174991","photo":"http://cmsweb.fblife.com/attachments/20160804/14702690165584.jpg","title":"外媒试驾2017款奥迪Q7 e-tron","stitle":"","link":"http://drive.fblife.com/html/20160803/174991.html"},{"type":2,"id":"13906776","photo":"http://cmsweb.fblife.com/attachments/20160804/14702694298870.jpg","title":"旅行日志 一个人的西行之路","stitle":"","link":"http://bbs.fblife.com/thread_13906776.html"},{"type":2,"id":"13909431","photo":"http://cmsweb.fblife.com/attachments/20160804/14702691498044.jpg","title":"肆零军团上蹶子山下玉符河","stitle":"","link":"http://bbs.fblife.com/thread_13909431.html"},{"type":1,"id":"174924","photo":"http://cmsweb.fblife.com/attachments/20160803/14701854551152.jpg","title":"外媒试驾保时捷Macan GTS","stitle":"","link":"http://drive.fblife.com/html/20160802/174924.html"},{"type":2,"id":"13899315","photo":"http://cmsweb.fblife.com/attachments/20160803/14701932814995.jpg","title":"2016中国路虎卫士俱乐部年会","stitle":"","link":"http://bbs.fblife.com/thread_13899315.html"}]
     */

    @SerializedName("errno")
    private int errno;
    @SerializedName("pages")
    private int pages;
    /**
     * type : 1
     * id : 174991
     * photo : http://cmsweb.fblife.com/attachments/20160804/14702690165584.jpg
     * title : 外媒试驾2017款奥迪Q7 e-tron
     * stitle :
     * link : http://drive.fblife.com/html/20160803/174991.html
     */

    @SerializedName("news")
    private List<HomeViewPagerNewsBean> news;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<HomeViewPagerNewsBean> getNews() {
        return news;
    }

    public void setNews(List<HomeViewPagerNewsBean> news) {
        this.news = news;
    }


}
