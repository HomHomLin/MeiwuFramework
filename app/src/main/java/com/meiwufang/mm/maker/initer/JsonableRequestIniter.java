package com.meiwufang.mm.maker.initer;

import android.content.Context;

import com.meiwufang.mm.maker.helper.OSHelper;
import com.meiwufang.mm.maker.manager.base.MeiwuAccountManager;

import javax.inject.Inject;

/**
 * Created by linhomhom on 15-1-5.
 */
public class JsonableRequestIniter {
    @Inject
    Context mContext;
    @Inject
    OSHelper mOSHelper;
    @Inject
    MeiwuAccountManager mAccountManager;

//    public void initJsonableRequest(JsonableRequest request) {
//        request.svr_name = "house";
//        request.req_num = getRequestNum();
//        request.sess_id = mAccountManager.getSession();
//        request.dev_id = mOSHelper.getIMEI();
//        request.sys_type = "d900102";
//        request.cl_ver = "8888";
//    }

}
