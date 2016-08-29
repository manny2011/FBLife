package com.group.yztcedu.fblife.main.forum.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/8/4.
 */
public class NewsBean {


    /**
     * errno : 0
     * errdesc :
     * pages : 729
     * app : [{"id":"7848","tid":"13904461","photo":["http://cmsweb.fblife.com/attachments/20160804/147024170149890.jpg.180x120.jpg"],"title":"共同打造美好论坛，找回\u201c家\u201d的感觉","stitle":"共同打造美好论坛，找回\u201c家\u201d的感觉","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"35","forumname":"鲁","photosize":"180X120","publishtime":"1470226833","type":"3","likes":"1","comment":"23","shownum":null},{"id":"7847","tid":"13902547","photo":["http://cmsweb.fblife.com/attachments/20160804/147024139723466.jpg.180x120.jpg"],"title":"兄弟，守望相助【山东肆零军团成长记】","stitle":"兄弟，守望相助【山东肆零军团成长记】","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"35","forumname":"鲁","photosize":"180X120","publishtime":"1470226832","type":"3","likes":"0","comment":"7","shownum":null},{"id":"7846","tid":"13890418","photo":["http://cmsweb.fblife.com/attachments/20160804/147024130816737.jpg.180x120.jpg"],"title":"130公里徒步穿越沙漠无人区，地狱级惊艳巴丹吉林体验","stitle":"130公里徒步穿越沙漠无人区，地狱级惊艳巴丹吉林体验","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"10","forumname":"粤","photosize":"180X120","publishtime":"1470226831","type":"3","likes":"1","comment":"51","shownum":null},{"id":"7838","tid":"13909017","photo":["http://cmsweb.fblife.com/attachments/20160802/147014647724016.jpg.180x120.jpg"],"title":"好山、好水、好风景、大瓦处女地！记自贡分队穿越活动","stitle":"好山、好水、好风景、大瓦处女地！记自贡分队穿越活动","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"813","forumname":"自贡分队","photosize":"180X120","publishtime":"1470119292","type":"3","likes":"0","comment":"28","shownum":null},{"id":"7837","tid":"13909431","photo":["http://cmsweb.fblife.com/attachments/20160802/147014636410124.jpg.180x120.jpg"],"title":"肆零军团上蹶子山下玉符河，到莱芜探荒山寻露营点","stitle":"肆零军团上蹶子山下玉符河，到莱芜探荒山寻露营点","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"81","forumname":"济南分队","photosize":"180X120","publishtime":"1470119291","type":"3","likes":"0","comment":"18","shownum":null},{"id":"7836","tid":"13902501","photo":["http://cmsweb.fblife.com/attachments/20160802/147014626553880.jpg.180x120.jpg"],"title":"遇见美好\u2014\u2014比利时、德国、捷克之旅","stitle":"遇见美好\u2014\u2014比利时、德国、捷克之旅","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"54","forumname":"滇","photosize":"180X120","publishtime":"1470119290","type":"3","likes":"0","comment":"103","shownum":null},{"id":"7832","tid":"13906672","photo":["http://cmsweb.fblife.com/attachments/20160802/147010444987836.jpg.180x120.jpg"],"title":"温州分队体验巴丹吉林穿越大海道，小玩库木塔格","stitle":"温州分队体验巴丹吉林穿越大海道，小玩库木塔格","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"228","forumname":"普拉多","photosize":"180X120","publishtime":"1470095021","type":"3","likes":"1","comment":"55","shownum":null},{"id":"7831","tid":"13908743","photo":["http://cmsweb.fblife.com/attachments/20160802/147009512236861.jpg.180x120.jpg"],"title":"百年匠心 五十铃mu-X中蒙俄跨境探秘之旅","stitle":"百年匠心 五十铃mu-X中蒙俄跨境探秘之旅","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"747","forumname":"mu-X","photosize":"180X120","publishtime":"1470095020","type":"3","likes":"0","comment":"9","shownum":null},{"id":"7828","tid":"13908265","photo":["http://cmsweb.fblife.com/attachments/20160801/147004787392736.jpg.180x120.jpg"],"title":"吉姆尼单车15天一万公里环游伊犁北疆","stitle":"吉姆尼单车15天一万公里环游伊犁北疆","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"618","forumname":"吉姆尼","photosize":"180X120","publishtime":"1470039518","type":"3","likes":"0","comment":"61","shownum":null},{"id":"7827","tid":"13856162","photo":["http://cmsweb.fblife.com/attachments/20160801/147004770482779.jpg.180x120.jpg"],"title":"60后滇进青出藏区万里行，素80单车试水大北线","stitle":"60后滇进青出藏区万里行，素80单车试水大北线","storeid":"0","business":"","classid":"0","channelid":"0","channel_name":"","bbsfid":"31","forumname":"渝","photosize":"180X120","publishtime":"1470009201","type":"3","likes":"1","comment":"86","shownum":null}]
     */

    @SerializedName("errno")
    private int errno;
    @SerializedName("errdesc")
    private String errdesc;
    @SerializedName("pages")
    private String pages;
    /**
     * id : 7848
     * tid : 13904461
     * photo : ["http://cmsweb.fblife.com/attachments/20160804/147024170149890.jpg.180x120.jpg"]
     * title : 共同打造美好论坛，找回“家”的感觉
     * stitle : 共同打造美好论坛，找回“家”的感觉
     * storeid : 0
     * business :
     * classid : 0
     * channelid : 0
     * channel_name :
     * bbsfid : 35
     * forumname : 鲁
     * photosize : 180X120
     * publishtime : 1470226833
     * type : 3
     * likes : 1
     * comment : 23
     * shownum : null
     */

    @SerializedName("app")
    private List<App> App;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrdesc() {
        return errdesc;
    }

    public void setErrdesc(String errdesc) {
        this.errdesc = errdesc;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public List<App> getApp() {
        return App;
    }

    public void setApp(List<App> App) {
        this.App = App;
    }

}
