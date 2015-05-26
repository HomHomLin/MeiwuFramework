package com.meiwufang.mm.maker.manager.base;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import code.lam.akittycache.AKittyFileCache;

/**
 * Created by linhomhom on 15-1-13.
 */
@Singleton
public class OtherPrefManager {

    public static final String PREF_CITY = "pref_city";
    public static final String PREF_CITY_CODE = "pref_city_code";
    public static final String PREF_PUSH_ENABLE = "pref_push_enable";
    public static final String PREF_PUSH_TOKEN = "pref_push_token";
    public static final String PREF_PUSH_CONFIG_GET = "pref_push_config_get";
    public static final String PREF_DISCLAIMER = "pref_disclaimer";

    @Inject
    @Named("main")
    AKittyFileCache mStorage;

    public void saveNow() {
        mStorage.saveQuietly();
    }

    public String getCurrentCity() {
        return mStorage.getString(PREF_CITY, "福州");
    }

    public void setCurrentCity(String value) {
        mStorage.put(PREF_CITY, value);
    }

    public String getCurrentCityCode() {
        return mStorage.getString(PREF_CITY_CODE, "fz");
    }

    public void setCurrentCityCode(String value) {
        mStorage.put(PREF_CITY_CODE, value);
    }

    public boolean getPushEnable(){
        return mStorage.getBoolean(PREF_PUSH_ENABLE,true);
    }

    public void setPushEnable(boolean value) {
        mStorage.put(PREF_PUSH_ENABLE, value);
    }

    public String getPushToken(){
        return mStorage.getString(PREF_PUSH_TOKEN,"");
    }

    public void setPushToken(String value) {
        mStorage.put(PREF_PUSH_TOKEN, value);
    }

    public boolean isPushConfig(){
        return mStorage.getBoolean(PREF_PUSH_CONFIG_GET,false);
    }

    public void setPushConfig(boolean value) {
        mStorage.put(PREF_PUSH_CONFIG_GET, value);
    }

    public String getDisclaimer(){
        return mStorage.getString(PREF_DISCLAIMER, "");
    }

    public void setDisclaimer(String value){
        mStorage.put(PREF_DISCLAIMER, value);
    }

}
