package com.meiwufang.mm.maker.helper;

import android.content.Context;

import com.meiwufang.mm.maker.manager.base.MeiwuAccountManager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by linhomhom on 15-1-7.
 */
@Singleton
public class AccountHelper {
    @Inject
    Context mContext;
    @Inject
    MeiwuAccountManager mAccountManager;

    public static final int HAS_CHECK_MOBILE = 1;
    public static final int NO_CHECK_MOBILE = 0;

    @Inject
    public AccountHelper() {
    }

    public void bindAccount(String uid, String realname, String unmae, String mobile, int checkmobile,String session){
        mAccountManager.setUID(uid);
        mAccountManager.setRealName(realname);
        mAccountManager.setUName(unmae);
        mAccountManager.setMobile(mobile);
        if(checkmobile == HAS_CHECK_MOBILE) {
            mAccountManager.setCheckMobile(true);
        }else{
            mAccountManager.setCheckMobile(false);
        }
        mAccountManager.setSession(session);
        mAccountManager.saveNow();
    }

    public void unbindAccount(){
        mAccountManager.setUID("");
        mAccountManager.setRealName("");
        mAccountManager.setUName("");
        mAccountManager.setCheckMobile(false);
        mAccountManager.saveNow();
    }
}
