package com.meiwufang.mm.maker.http;

import com.meiwufang.mm.maker.helper.AQueryHelper;
import com.meiwufang.mm.maker.helper.HttpHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by linhomhom on 14-12-31.
 */
@Singleton
public class HttpHelperSwitcher {

    @Inject
    AQueryHelper mAQueryHelper;

    public HttpHelper getHttpHelper() {
        return mAQueryHelper;
    }
}
