package com.example.mobilprogramlamaodev2.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mobilprogramlamaodev2.models.User;

import java.util.ArrayList;

public class SharedPrefUtil {


    public static User getUser(Context context, String userName){
        SharedPreferences sharedpreferences =  context.getSharedPreferences(userName, Context.MODE_PRIVATE);
        User temp = new User();
        temp.setUserName((sharedpreferences.getString(ConstantUtil.NAME,"")));
        temp.setGender((sharedpreferences.getInt(ConstantUtil.GENDER,0)));
        temp.setHeight((sharedpreferences.getInt(ConstantUtil.HEIGHT,0)));
        temp.setWeight((sharedpreferences.getInt(ConstantUtil.WEIGHT,0)));
        temp.setAge((sharedpreferences.getInt(ConstantUtil.AGE,0)));
        temp.setAppMode((sharedpreferences.getInt(ConstantUtil.APP_MODE,0)));

        return temp;
    }

    public static void editUser(Context context, User user, String userName){
        SharedPreferences sharedpreferences =  context.getSharedPreferences(userName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(ConstantUtil.GENDER,user.getGender());
        editor.putInt(ConstantUtil.HEIGHT, user.getHeight());
        editor.putInt(ConstantUtil.WEIGHT, user.getWeight());
        editor.putInt(ConstantUtil.AGE, user.getAge());
        editor.putInt(ConstantUtil.APP_MODE, user.getAppMode());
        editor.apply();
    }

    public static void setUserInfos(Context context, User user){
        SharedPreferences sharedpreferences =  context.getSharedPreferences(user.getUserName(), Context.MODE_PRIVATE);
    }


    public static void addUsersInfos(Context context, ArrayList<User> users) {
        for (User user : users) {
            addUserInfos(context, user);
        }
    }


    public static void addUserInfos(Context context, User user) {
            SharedPreferences sharedpreferences = context.getSharedPreferences(user.getUserName(), Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(ConstantUtil.NAME, user.getUserName());
            editor.putString(ConstantUtil.PASSWORD, user.getPassword());
            editor.putString(ConstantUtil.PIC_PATH, user.getPicture_path());
            editor.putInt(ConstantUtil.GENDER,user.getGender());
            editor.putInt(ConstantUtil.HEIGHT, user.getHeight());
            editor.putInt(ConstantUtil.WEIGHT, user.getWeight());
            editor.putInt(ConstantUtil.AGE, user.getAge());
            editor.putInt(ConstantUtil.APP_MODE, user.getAppMode());
            editor.apply();
    }




}
