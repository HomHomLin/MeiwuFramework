package com.meiwufang.mm.maker.helper;

import java.util.HashMap;

/**
 * Created by linhomhom on 14-12-31.
 */
public interface HttpHelper {
    String httpGet(String url, int time_out, long expire) throws Exception;

    String httpGet(String url) throws Exception;

    String httpPost(String url, HashMap<String, ?> post) throws Exception;

    String httpPost(String url, HashMap<String, ?> post, int time_out) throws Exception;

}
