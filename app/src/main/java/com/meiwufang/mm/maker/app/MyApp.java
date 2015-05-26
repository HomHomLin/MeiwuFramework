package com.meiwufang.mm.maker.app;

import com.meiwufang.mm.maker.configs.AppConfig;

import dagger.ObjectGraph;

/**
 * Created by Linhh on 15/5/26.
 */
public interface MyApp {
    public void onCreate();

    public void onTerminate();

    public void setMeiwuApp(MeiwuApp meiwuApp);

    public ObjectGraph getObjectGraph();

    public void setAppConfig(AppConfig appConfig);
}