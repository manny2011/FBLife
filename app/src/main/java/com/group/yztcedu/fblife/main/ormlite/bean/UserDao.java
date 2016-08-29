package com.group.yztcedu.fblife.main.ormlite.bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    private ORMLiteHelper ormLiteHelper;
    private static Dao<User,Integer> dao;
    private static UserDao uDao;
    private UserDao(Context context){
       ormLiteHelper = new ORMLiteHelper(context);
        try {
            dao = ormLiteHelper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private static UserDao userDaoInstence(Context context) {
        if (uDao == null) {
            uDao = new UserDao(context);
        }
        return uDao;
    }
    public static void add(User user,Context context){
        userDaoInstence(context);
        try {
            dao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delAll(Context context,User user){
        userDaoInstence(context);
        try {
            dao.delete(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void del(Context context){
        userDaoInstence(context);
        try {
            DeleteBuilder<User, Integer> builder = dao.deleteBuilder();

            builder.where().eq("nameID","name");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void update(Context context,User user) {
        userDaoInstence(context);
        try {
            UpdateBuilder builder = dao.updateBuilder();
            builder.where().eq("name", user.getName());
            builder.updateColumnValue("pwd", "oooo");
             builder.update();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static List<User> quaryAll(Context context) {
        List<User> listuUsers=new ArrayList<>();
        userDaoInstence(context);
        try {
            listuUsers= dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuUsers;
    }
    public static int quaryOne(Context context) {
        List<User> listuUsers=new ArrayList<>();
        userDaoInstence(context);
        try {

            QueryBuilder builder=dao.queryBuilder();

            builder.where().eq("name","zk").and().eq("pwd","oooo");
            listuUsers=builder.query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listuUsers.size();
    }

}
