package com.gwamelody.myapplication.Model;

/**
 * Created by Gwa Melody on 9/12/2560.
 */

public class Animals {
    private  String engName;
    private  String thaiName;
    private  int picture;
    private  String details;

    public Animals(String engName, String thaiName, int picture, String details) {
        this.engName = engName;
        this.thaiName = thaiName;
        this.picture = picture;
        this.details = details;
    }
    public Animals(){


    }

    public String getEngName() {
        return engName;
    }

    public String getThaiName() {
        return thaiName;
    }

    public int getPicture() {
        return picture;
    }

    public String getDetails() {
        return details;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public void setThaiName(String thaiName) {
        this.thaiName = thaiName;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
