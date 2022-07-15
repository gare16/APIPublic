package com.apps.publicapi1019911.model;

import com.google.gson.annotations.SerializedName;

public class AnimeModel {
    @SerializedName("anime_id")
    public String anime_id;
    @SerializedName("anime_name")
    public String anime_name;
    @SerializedName("anime_img")
    public String anime_img;

    public String getAnime_id() {
        return anime_id;
    }

    public String getAnime_name() {
        return anime_name;
    }

    public String getAnime_img() {
        return anime_img;
    }
}
