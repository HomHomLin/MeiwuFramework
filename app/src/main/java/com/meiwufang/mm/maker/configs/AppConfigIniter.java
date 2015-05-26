package com.meiwufang.mm.maker.configs;

import com.meiwufang.mm.maker.app.MeiwuApp;

/**
 * Created by linhomhom on 14-12-31.
 */
public class AppConfigIniter {
    //程序配置来源
    public static String APP_CONFIG_SOURCE = "unknown";
    MeiwuApp mMeiwuApp;
    public static int appConfigType;
    public static final int APP_CONFIG_CFG_RELEASE = 4;

    public AppConfigIniter(MeiwuApp app) {
        mMeiwuApp = app;
    }

    public AppConfig init() {
        AppConfig appConfig;
        appConfig = new ReleaseAppConfig(mMeiwuApp);
        APP_CONFIG_SOURCE = "Default: ReleaseAppConfig";
        appConfigType = APP_CONFIG_CFG_RELEASE;
        return appConfig;
    }
}

