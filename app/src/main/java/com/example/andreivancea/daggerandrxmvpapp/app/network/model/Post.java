package com.example.andreivancea.daggerandrxmvpapp.app.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andrei.vancea on 4/19/2017.
 */

public class Post {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    @Override
    public String toString() {
        return "{userId: " + userId + ", id: " + id + ", title: " + title + ", body: " + body + "}";
    }
}
