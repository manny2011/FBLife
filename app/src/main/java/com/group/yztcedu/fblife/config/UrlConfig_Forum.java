package com.group.yztcedu.fblife.config;

/**
 * Created by Administrator on 2016/8/4.
 */
public class UrlConfig_Forum {

    /*     public static final String BBSPAGE_RECOMMENT=
    "http://cmsweb.fblife.com/ajax.php?
    c=newstwo &a=getappindex &=10&datatype=3 &type=json &pagesize=10 &page=1";
*/
public static class Path{
        public static final String base_url="http://cmsweb.fblife.com/";
        public static final String relative_url="ajax.php";
    }
    public static class Key{
        public static final String C="c";
        public static final String A="a";
        public static final String DATATYPE="datatype";
        public static final String TYPE="type";
        public static final String PAGESIZE="pagesize";
        public static final String PAGE="page";
    }
    public static class Value{
        public static final String C="newstwo";
        public static final String A="getappindex";
        public static final String DATATYPE="3";
        public static final String TYPE="json";
        public static final String PAGESIZE="10";
        public static final String PAGE="1";
    }
    /**http://bbs.fblife.com/
     * bbsapinew/getforumsbycategory.php?
     *
     * categorytype=diqu&
     *
     * authcode=VmBWNgdmUjcGMFc1DTNWLVE4VzIMPQA8A3xRMwBoU25TZQ==&
     * formattype=json*/
    public static class DistrictPath{
        public static final String BASE_URL="http://bbs.fblife.com/";
        public static final String RELATIVE_URL="bbsapinew/getforumsbycategory.php";
    }
    public static class DistrictKey{
        public static final String authcode="authcode";
        public static final String formattype="formattype";
        public static final String categorytype="categorytype";

    }
    public static class DistrictValue{
        public static final String authcode="VmBWNgdmUjcGMFc1DTNWLVE4VzIMPQA8A3xRMwBoU25TZQ==";
        public static final String formattype="json";
        public static final String categorytype="diqu";
    }
}
