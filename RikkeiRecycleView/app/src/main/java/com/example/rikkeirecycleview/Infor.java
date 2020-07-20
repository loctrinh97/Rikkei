package com.example.rikkeirecycleview;

import android.media.Image;
import android.net.Uri;

public class Infor {
    private int img;
    private String name;

    public Infor(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
