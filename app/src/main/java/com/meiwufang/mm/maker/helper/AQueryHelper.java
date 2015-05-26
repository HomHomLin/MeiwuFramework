package com.meiwufang.mm.maker.helper;

import android.text.TextUtils;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;

import org.apache.log4j.Logger;

import java.net.URL;
import java.util.HashMap;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * 底层基础
 * Created by linhomhom on 14-12-31.
 */
@Singleton
public class AQueryHelper implements HttpHelper {

    public static final Logger logger = Logger.getLogger(AQueryHelper.class.getSimpleName());
    private static final int TIME_OUT = 1 * 30 * 1000; //30s
    AQuery mAQuery;

    @Inject
    public AQueryHelper(AQuery query) {
        mAQuery = query;
    }

    public static final String SUCCESS = "200";
    public static final String OUT_DATE = "406";

    @Override
    public String httpGet(String url, int time_out, long expire) throws Exception {
        logger.debug("httpGet " + url);
        AjaxCallback<String> cb = new AjaxCallback<String>();
        cb.url(url).type(String.class)
                .fileCache(true)
                .memCache(false)
                .expire(expire);
        AjaxCallback.setTimeout(time_out);
        cb.header("Content-Type", "application/json");
        mAQuery.sync(cb);
        AjaxStatus status = cb.getStatus();
        if (status.getCode() != 200) {
            throw new Exception("Error response code: " + status.getCode());
        }
        return cb.getResult();
    }

    /**
     * Get
     */
    @Override
    public String httpGet(String url) throws Exception {
        logger.debug("httpGet " + url);
        URL parsed = new URL(url);
        String path = parsed.getPath();
        try {
            return httpGetInternal(parsed);
        } catch (Exception e) {
            //再重试一次
            logger.debug("httpGet.Result: retry, " + path);
            try {
                return httpGetInternal(parsed);
            } catch (Exception failedAgain) {
                logger.debug("httpGet.Result: Failed again, " + path);
                throw failedAgain;
            }
        }
    }

    private String httpGetInternal(URL url) throws Exception {
        //logger.debug("httpGet:" + url);
        //recheckHttpConnection();
        AjaxCallback<String> cb = new AjaxCallback<String>();
        cb.url(url.toString())
                .type(String.class)
                .fileCache(false)
                .memCache(false);
        cb.header("Content-Type", "application/json");
        AjaxCallback.setTimeout(TIME_OUT);
        mAQuery.sync(cb);
        AjaxStatus status = cb.getStatus();

        if (status.getCode() != 200) {
            throw new Exception("Error response code: " + status.getCode());
        }
        String result = cb.getResult();
        if (TextUtils.isEmpty(result)) {
            throw new Exception("Empty response." + url);
        }
        return result;
    }

    /**
     * Post
     */
    @Override
    public String httpPost(String url, HashMap<String, ?> post) throws Exception {
        return httpPost(url, post, TIME_OUT);
    }

    @Override
    public String httpPost(String url, HashMap<String, ?> post, int time_out) throws Exception {
        logger.debug("httpPost " + url);
        return httpPostInternal(url, post, time_out);
    }

    String httpPostInternal(String url, HashMap<String, ?> post, int time_out) throws Exception {
        String result = "";
        AjaxCallback<String> cb = httpPostAjaxCallback(url, post, time_out);
        AjaxStatus status = cb.getStatus();
        if (status.getCode() != 200) {
            throw new Exception("Error response code:" + status.getCode());
        }
        result = cb.getResult();
        if (TextUtils.isEmpty(result)) {
            throw new Exception("Empty response:" + 10000);
        }
        return result;
    }

    public AjaxCallback httpPostAjaxCallback(String url, HashMap<String, ?> post, int time_out) throws Exception {
        //logger.info("httpPost:" + url);
        //recheckHttpConnection();
        AjaxCallback<String> cb = new AjaxCallback<String>();
        cb.url(url)
                .type(String.class)
                .fileCache(false)
                .memCache(false)
                .params(post)
                .timeout(time_out);
        cb.header("Content-Type", "application/json");
        mAQuery.sync(cb);
        return cb;
    }

    public AjaxCallback httpPutAjaxCallback(String url, HashMap<String, ?> put, int time_out) throws Exception {
        //logger.info("httpPut:" + url);
        //recheckHttpConnection();
        AjaxCallback<String> cb = new AjaxCallback<String>();
        cb.url(url)
                .type(String.class)
                .fileCache(false)
                .memCache(false)
                .params(put)
                .timeout(time_out)
                .method(AQuery.METHOD_PUT);
        cb.header("Content-Type", "application/json");
        mAQuery.sync(cb);
        return cb;
    }
}
