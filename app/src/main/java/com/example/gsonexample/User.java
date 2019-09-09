package com.example.gsonexample;

import com.google.gson.annotations.SerializedName;

public class User {

    private String login;

    @SerializedName("avatar_url")
    private String image;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

