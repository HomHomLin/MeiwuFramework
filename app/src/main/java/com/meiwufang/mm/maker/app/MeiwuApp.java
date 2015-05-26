package com.meiwufang.mm.maker.app;

import android.app.Application;
import android.content.Context;

import com.honemen.lanfang.database.DaoMaster;
import com.honemen.lanfang.database.DaoSession;
import com.meiwufang.mm.maker.configs.AppConfig;
import com.meiwufang.mm.maker.configs.AppConfigIniter;
import com.meiwufang.mm.maker.helper.OSHelper;

import dagger.ObjectGraph;

/**
 * Created by Linhh on 15/5/26.
 */
public class MeiwuApp extends Application {
    private OSHelper mOSHelper = new OSHelper(this);
    private MyApp mCurrentApp;
    String mProcessName;
    private AppConfig appConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        appConfig = new AppConfigIniter(this).init();
        sMeiwuApp = this;
        mProcessName = mOSHelper.getProcessNameByPid(android.os.Process.myPid());
        mCurrentApp = new MainApp(this, appConfig);
        mCurrentApp.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        mCurrentApp.onTerminate();
    }

    public ObjectGraph getObjectGraph() {
        return mCurrentApp.getObjectGraph();
    }

    private static MeiwuApp sMeiwuApp;

    @Deprecated
    public static MeiwuApp getApp() {
        return sMeiwuApp;
    }

    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static final String DB_NAME = "meiwu_mm_db";

    public static DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context,DB_NAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}

