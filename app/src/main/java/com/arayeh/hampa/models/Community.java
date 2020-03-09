package com.arayeh.hampa.models;

import android.widget.ImageView;

import java.util.List;

public class Community {
    private String comminityName;
    private int memberNumber;
    private List<String> list;
    private int imageView;
    public Community(String communityName, int img){
        this.comminityName=communityName;
        this.imageView=img;
    }

    public String getComminityName() {
        return comminityName;
    }

    public void setComminityName(String comminityName) {
        this.comminityName = comminityName;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }


    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
