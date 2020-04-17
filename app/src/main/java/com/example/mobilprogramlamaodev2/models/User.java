package com.example.mobilprogramlamaodev2.models;

public class User {
    private String userName;
    private String password;
    private String picture_path;
    private int gender;
    private int height;
    private int weight;
    private int age;
    private int appMode;
    private int imageId;


    public User(String userName, String password, String picture_path, int gender, int height, int weight, int age, int appMode, int imageId) {
        this.userName = userName;
        this.password = password;
        this.picture_path = picture_path;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.appMode = appMode;
        this.imageId = imageId;

    }

    public User(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAppMode() {
        return appMode;
    }

    public void setAppMode(int appMode) {
        this.appMode = appMode;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
