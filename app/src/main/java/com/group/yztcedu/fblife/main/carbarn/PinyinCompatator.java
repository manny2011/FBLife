package com.group.yztcedu.fblife.main.carbarn;

import com.group.yztcedu.fblife.main.carbarn.entity.Vehicle;

import java.util.Comparator;

/**
 * Created by Administrator on 2016/8/10.
 */
public class PinyinCompatator implements Comparator<Vehicle> {

    //对数据源中的所有对象比较首字母 Ascii,来进行排序;
    @Override
    public int compare(Vehicle Vehicle, Vehicle t1) {
        if(Vehicle.getSortedKey().equals("#")){
            return 1;
        }else if (t1.getSortedKey().equals("#")){
            return -1;
        }else{
            return Vehicle.getSortedKey().compareTo(t1.getSortedKey());
        }
    }
}
