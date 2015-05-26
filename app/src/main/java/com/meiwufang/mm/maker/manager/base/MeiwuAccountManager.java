package com.meiwufang.mm.maker.manager.base;

import android.text.TextUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import code.lam.akittycache.AKittyFileCache;

/**
 * Created by linhomhom on 14-12-31.
 */
@Singleton
public class MeiwuAccountManager {

    public static final String ACCOUNT_TEST = "test";

    public static final String PREF_UID = "uid";
    public static final String PREF_REALNAME = "realname";
    public static final String PREF_UNAME = "uname";
    public static final String PREF_MOBILE = "mobile";
    public static final String PREF_CHECK_MOBILE = "check_mobile";
    public static final String PREF_SESSION_ID = "session_id";


    @Inject
    @Named("main")
    AKittyFileCache mStorage;

    @Deprecated
    public String getTestValue() {
        return mStorage.getString(ACCOUNT_TEST, "");
    }

    @Deprecated
    public void setTestValue(String value) {
        mStorage.put(ACCOUNT_TEST, value);
    }

    public boolean isBind(){
        if(!TextUtils.isEmpty(getUID()) && !TextUtils.isEmpty(getUName()) ){
            return true;
        }
        return false;
    }

    public void saveNow() {
        mStorage.saveQuietly();
    }

    public String getUID() {
        return mStorage.getString(PREF_UID, "");
    }

    public void setUID(String uid) {
        mStorage.put(PREF_UID, uid);
    }

    public String getRealName() {
        return mStorage.getString(PREF_REALNAME, "");
    }

    public void setRealName(String realName) {
        mStorage.put(PREF_REALNAME, realName);
    }

    public String getUName() {
        return mStorage.getString(PREF_UNAME, "");
    }

    public void setUName(String uName) {
        mStorage.put(PREF_UNAME, uName);
    }

    public String getMobile() {
        return mStorage.getString(PREF_MOBILE, "");
    }

    public void setMobile(String mobile) {
        mStorage.put(PREF_MOBILE, mobile);
    }

    public boolean isCheckMobile() {
        return mStorage.getBoolean(PREF_CHECK_MOBILE, false);
    }

    public void setCheckMobile(boolean isCheck) {
        mStorage.put(PREF_CHECK_MOBILE, isCheck);
    }

    public String getSession() {
        return mStorage.getString(PREF_SESSION_ID, "");
    }

    public void setSession(String session) {
        mStorage.put(PREF_SESSION_ID, session);
    }

}
