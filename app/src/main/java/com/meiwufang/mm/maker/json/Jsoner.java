package com.meiwufang.mm.maker.json;

import com.google.gson.Gson;

/**
 * Created by linhomhom on 14-12-31.
 */
public class Jsoner {

    private static Jsoner sInstance;

    public static Jsoner getInstance() {
        if (sInstance == null) {
            sInstance = new Jsoner();
        }
        return sInstance;
    }

    private Gson mGson;

    private Jsoner() {
        mGson = new Gson();
    }

    public String toJson(Object obj) {
        return mGson.toJson(obj);
    }

    public <T> T fromJson(String s, Class<T> cls) {
        return mGson.fromJson(s, cls);
    }
}
