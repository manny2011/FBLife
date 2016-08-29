package com.group.yztcedu.fblife.main.search.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Polaris on 2016/8/5.
 */
public class SearchBean {

    /**
     * errcode : 0
     * pagesize : 10
     * allnumbers : 181
     * pagenumbers : 19
     * searchinfo : [{"tid":"172272","fid":"811","title":"沧海变革的铁门关 没落的罗布人民族","content":" ... 的香梨人人夸\u201d，库尔勒 ... ","dateline":"1464120449","fromtype":"2","url":"http://news.fblife.com/html/20160525/172272.html","newstype":""},{"tid":"172081","fid":"811","title":"异域南疆 江铃域虎国门之旅第五站","content":" ... 特色可不是人人都能消受 ... 饭桌上那盆人人避之不及 ... ","dateline":"1463646221","fromtype":"2","url":"http://news.fblife.com/html/20160519/172081.html","newstype":""},{"tid":"167983","fid":"795","title":"车轮上的中国 那些年我们过年回家开的车","content":" ... 东西不是人人能买得 ... 毕竟不是人人都能买 ... ","dateline":"1454748171","fromtype":"2","url":"http://news.fblife.com/html/20160206/167983.html","newstype":""},{"tid":"160000","fid":"791","title":"抗洪救灾，人人有责 携手为大赣州灾民祈福","content":"抗洪救灾，人人有责 携手为 ... 抗洪救灾，人人有责；携手 ... ","dateline":"1432292577","fromtype":"2","url":"http://news.fblife.com/html/20150522/160000.html","newstype":""},{"tid":"159062","fid":"824","title":"2015梦想车展前奏：难忘经典容颜-老爷车篇","content":" ... （源于创始人人亨利·福 ... ","dateline":"1430296215","fromtype":"2","url":"http://news.fblife.com/html/20150429/159062.html","newstype":""},{"tid":"158317","fid":"791","title":"爱心助学，成就梦想 吉林中队爱心助学活动","content":" ... 传递。只要人人都献出 ... ","dateline":"1429018852","fromtype":"2","url":"http://news.fblife.com/html/20150414/158317.html","newstype":""},{"tid":"156794","fid":"149","title":"醉在大西南 和域虎一起走过的2014","content":" ... ...景不醉人人自醉， ... ","dateline":"1425631079","fromtype":"2","url":"http://news.fblife.com/html/20150306/156794.html","newstype":""},{"tid":"156760","fid":"811","title":"黄河上的春节 BJ40大中原环游记第五集","content":" ... 竟然可笑到人人都向往蓝天 ... ","dateline":"1425549766","fromtype":"2","url":"http://news.fblife.com/html/20150305/156760.html","newstype":""},{"tid":"156344","fid":"811","title":"e族编辑都怎么玩儿？盘点青哥去哪儿","content":" ... 有着一条人人都想征服 ... 却不是人人都敢去 ... ","dateline":"1424325090","fromtype":"2","url":"http://news.fblife.com/html/20150219/156344.html","newstype":""},{"tid":"152808","fid":"109","title":"李健：我如何向雷军要到2000万美元投资的","content":" ... 月成立的人人车，成立 ... 融资过程，人人车CEO李 ... 点\u2014\u2014兴趣与人人车契合， ... 渐入佳境，以人人车项目终 ... 投资方特点，人人车团队准备 ... 的投资方向人人车递出 ... 模式的创造者人人车来说， ... 逐渐完善出人人车C2C虚拟 ... 、谈起人人车，李 ... ，了解了人人车数据， ... 的入场券。人人车从一批 ... 军问，人人车项目优势 ... 什么?其时的人人车，数据 ... 李健，人人车拿到 ... 行业专家。人人车创始团队 ... 用户痛点的人人车模式， ... ","dateline":"1422428860","fromtype":"2","url":"http://news.fblife.com/html/20150128/152808.html","newstype":""}]
     */

    @SerializedName("errcode")
    private int errcode;
    @SerializedName("pagesize")
    private int pagesize;
    @SerializedName("allnumbers")
    private int allnumbers;
    @SerializedName("pagenumbers")
    private int pagenumbers;
    /**
     * tid : 172272
     * fid : 811
     * title : 沧海变革的铁门关 没落的罗布人民族
     * content :  ... 的香梨人人夸”，库尔勒 ...
     * dateline : 1464120449
     * fromtype : 2
     * url : http://news.fblife.com/html/20160525/172272.html
     * newstype :
     */

    @SerializedName("searchinfo")
    private List<Searchinfobean> searchinfo;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getAllnumbers() {
        return allnumbers;
    }

    public void setAllnumbers(int allnumbers) {
        this.allnumbers = allnumbers;
    }

    public int getPagenumbers() {
        return pagenumbers;
    }

    public void setPagenumbers(int pagenumbers) {
        this.pagenumbers = pagenumbers;
    }

    public List<Searchinfobean> getSearchinfo() {
        return searchinfo;
    }

    public void setSearchinfo(List<Searchinfobean> searchinfo) {
        this.searchinfo = searchinfo;
    }


}
