package com.meiwufang.mm.maker.configs;

import android.content.Context;

import com.meiwufang.mm.maker.log.Log4jIniter;
import com.meiwufang.mm.maker.urls.BaseUrls;


/**
 * Created by linhomhom on 14-12-31.
 */
public interface AppConfig {

    public BaseUrls getUrls();

    public Log4jIniter getMainLog4jIniter(Context context);

    public boolean log();

    public boolean only_remote_log();

    public String getForceIp(); //在android模拟器上强制使用给定ip

}

