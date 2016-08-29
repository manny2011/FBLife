package com.group.yztcedu.fblife.config;

public class UrlConfig {
    /**
     * 首页接口
     */

    public static class Path{
        public static final String BASE_URL="http://cmsweb.fblife.com/";
        public static final String HOME_URL="ajax.php?";

    }
    public static class Key{
        public static final String C = "c";
        public static final String A = "a";
        public static final String TYPE = "type";
        public static final String CLASSNAME = "classname";
        public static final String PAGESIZE = "pagesize";
        public static final String PAGE = "page";
        public static final String DEBUG = "debug";
    }
    public static final String HOMEPAGE_VIEWPAGER_URL = "http://cmsweb.fblife.com/ajax.php?c=newstwo&a=newsslide&classname=appnew&type=json";
    public static final String HOMEPAGE_LISTVIEW_URL = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=&pagesize=10&page=1&debug=1";
    public static final String HOMEPAGE_NEW_CAR = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=newcar&pagesize=20&page=1";
    public static final String HOMEPAGE_GUIDE = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=guide&pagesize=20&page=1";
    public static final String HOMEPAGE_DRIVE = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=drive&pagesize=20&page=1";
    public static final String HOMEPAGE_PHOTO = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=photo&pagesize=20&page=1";
    public static final String HOMEPAGE_DEPRECIATE = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=depreciate&pagesize=20&page=1";
    public static final String HOMEPAGE_CULTURE = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=culture&pagesize=20&page=1";
    public static final String HOMEPAGE_RESTYLE = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=restyle&pagesize=20&page=1";
    public static final String HOMEPAGE_TOUR = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=tour&pagesize=20&page=1";
    public static final String HOMEPAGE_NEWS = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=news&pagesize=20&page=1";
    public static final String HOMEPAGE_RV = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=rv&pagesize=20&page=1";
    public static final String HOMEPAGE_TIEQI = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=tieqi&pagesize=20&page=1";
    public static final String HOMEPAGE_EVENT = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=event&pagesize=20&page=1";
    public static final String HOMEPAGE_USE = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=use&pagesize=20&page=1";
    public static final String HOMEPAGE_SPORTS = "http://cmsweb.fblife.com/ajax.php?c=appnews&a=getAppIndex&type=json&classname=sports&pagesize=20&page=1";
    /**
     * bbs接口
     */
    public static final String BBSPAGE_RECOMMENT = "http://cmsweb.fblife.com/ajax.php?c=newstwo&a=getappindex&=10&datatype=3&type=json&pagesize=10&page=1";
    public static final String BBSPAGE_RECOMMENT_BASE = "http://cmsweb.fblife.com/ajax.php?c=newstwo&a=getappindex&=10&datatype=3&type=json&pagesize=10&page=";


    /**
     * 视频接口
     */
    public static final String VIDEOPAGE = "http://cmsweb.fblife.com/ajax.php?c=news&a=getvideolist&pagesize=20&page=1";
    /**
     * 商城接口
     */
    public static final String STORE ="http://m.fblife.com/mall/";
}
