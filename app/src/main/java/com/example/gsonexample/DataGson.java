package com.example.gsonexample;

import com.google.gson.annotations.SerializedName;

public class DataGson {
    private String img, img1, nama;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public DataGson() {
        this.img = img;
        this.img1 = img1;
        this.nama = nama;
    }
}

