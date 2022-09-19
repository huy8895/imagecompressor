package com.app.imagecompressor.ultil;

import com.google.gson.Gson;

public class Utils {
    private static final Gson gson = new Gson();

    public static <T> T fromJson(String json, Class<T> classOfT){
        return gson.fromJson(json, classOfT);
    }

    public static String toJson(Object src){
        return gson.toJson(src);
    }

}
