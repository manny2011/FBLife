package com.group.yztcedu.fblife.main.search.URL;

/**
 * Created by Polaris on 2016/8/5.
 */
public class UrlString {
    public static class Path{
        public static final String SEARCH_INFORMATION = "api/searchapi.php";
        public static final String SEARCH_FORUM = "api/searchapi.php";
        public static final String SEARCH_USER = "openapi/index.php";
        public static final String SEARCH_BASE="http://so.fblife.com/";
    }
    public static class Key{
        public  static final String FROMTYPE = "fromtype";
        public  static final String PAGESIZE  = "pagesize";
        public  static final String FORMATTYPE = "formattype";
        public  static final String CHARSET = "charset";
        public  static final String PAGE = "page";
        public  static final String QUERY = "query";
        public  static final String MOD = "mod";
        public  static final String CODE = "code";
        public  static final String USERNAME = "username";
        public  static final String FBTYPE = "fbtype";



    }
    public static class Value{
        public  static final String FROMTYPE_VALUE = "2";
        public  static final String FROMTYPE_FORUM_VALUE = "1";
        public  static final String FROMTYPE_USER_VALUE = "7c383caa";
        public  static final String PAGESIZE_VALUE  = "10";
        public  static final String FORMATTYPE_VALUE = "json";
        public  static final String CHARSET_VALUE = "utf8";
        public  static final String MOD_VALUE= "search";
        public  static final String CODE_VALUE = "user";


    }

}
