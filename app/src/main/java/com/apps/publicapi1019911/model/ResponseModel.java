package com.apps.publicapi1019911.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ResponseModel {
    @SerializedName("success")
    public boolean success;
    @SerializedName("data")
    public List<AnimeModel> data = new ArrayList<>();

    public boolean isSuccess() {
        return success;
    }

    public List<AnimeModel> getData() {
        return data;
    }
}
