package com.meiwufang.mm.maker.configs;

import android.content.Context;

import com.meiwufang.mm.BuildConfig;
import com.meiwufang.mm.maker.json.Jsonable;
import com.meiwufang.mm.maker.log.Log4jIniter;
import com.meiwufang.mm.maker.log.MainLog4jIniter;
import com.meiwufang.mm.maker.log.NullLog4jIniter;
import com.meiwufang.mm.maker.urls.BaseUrlImpl;
import com.meiwufang.mm.maker.urls.BaseUrls;


/**
 * Created by linhomhom on 14-12-31.
 */
public class AppConfigImpl extends Jsonable implements AppConfig {

    //各种Url配置
    public BaseUrlImpl urls;
    //是否输出日志
    public Boolean log = BuildConfig.DEBUG;
    //是否只是输出远程连接的跟踪日志
    public Boolean only_remote_log = false;

    public String force_ip;

    @Override
    public BaseUrls getUrls() {
        return urls;
    }

    @Override
    public Log4jIniter getMainLog4jIniter(Context context) {
        return log() ? new MainLog4jIniter(context) : new NullLog4jIniter();
    }

    @Override
    public boolean log() {
        return log;
    }

    @Override
    public boolean only_remote_log() {
        return only_remote_log;
    }

    @Override
    public String getForceIp() {
        return force_ip;
    }

}
