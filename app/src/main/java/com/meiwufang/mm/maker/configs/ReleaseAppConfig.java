package com.meiwufang.mm.maker.configs;

import com.meiwufang.mm.maker.app.MeiwuApp;
import com.meiwufang.mm.maker.urls.ReleaseUrls;

/**
 * Created by linhomhom on 14-12-31.
 */
public class ReleaseAppConfig extends AppConfigImpl {

    public ReleaseAppConfig(MeiwuApp app) {
        urls = new ReleaseUrls();
        log = true;
        only_remote_log = true;
    }
}
