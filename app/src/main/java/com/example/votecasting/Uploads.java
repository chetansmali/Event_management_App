package com.example.votecasting;

import com.google.firebase.database.Exclude;

public class Uploads {
    private String imgName;
    private String imgUrl;
    private String mKey;

    public Uploads() {
    }

    public Uploads(String imgName, String imgUrl) {
        if(imgName.trim().equals(""))
        {
            imgName="No name";
        }
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    @Exclude
    public String getKey() {
        return mKey;
    }

    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}

