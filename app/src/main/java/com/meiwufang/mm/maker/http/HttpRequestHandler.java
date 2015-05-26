package com.meiwufang.mm.maker.http;


import com.meiwufang.mm.maker.json.Jsonable;

/**
 * Created by linhomhom on 14-12-31.
 */
public interface HttpRequestHandler<T extends Jsonable> {
    /**
     * 发起http请求
     */
    public T makeHttpRequest() throws Exception;
}
