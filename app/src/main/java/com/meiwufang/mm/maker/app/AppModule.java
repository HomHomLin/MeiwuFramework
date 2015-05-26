package com.meiwufang.mm.maker.app;

import android.content.Context;
import android.os.Handler;

import com.meiwufang.mm.maker.base.otto.BusProvider;
import com.meiwufang.mm.maker.helper.HttpHelper;
import com.meiwufang.mm.maker.http.HttpHelperSwitcher;
import com.meiwufang.mm.maker.manager.base.MeiwuAccountManager;
import com.meiwufang.mm.maker.manager.base.OtherPrefManager;
import com.meiwufang.mm.maker.module.SystemModule;
import com.meiwufang.mm.maker.urls.BaseUrlImpl;
import com.meiwufang.mm.maker.urls.BaseUrls;
import com.squareup.otto.Bus;

import javax.inject.Named;
import javax.inject.Singleton;

import code.lam.akittycache.AKittyBackupableCache;
import code.lam.akittycache.AKittyFileCache;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Linhh on 15/5/26.
 */
@Module(
        injects = {
                MainApp.class,
                BusProvider.class,
                BaseUrls.class,
                MeiwuAccountManager.class,
                OtherPrefManager.class
        },
        includes = {
                SystemModule.class
        },
        library = true, complete = false
)
public class AppModule {
    private Context mContext;
    private Handler mHandler;
    public AppModule(Context context) {
        mContext = context;
        mHandler = new Handler();
    }

    @Singleton
    @Provides
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    @Named("main")
    Bus provideMainBus(BusProvider provider) {
        return provider.getMainBus();
    }

    @Singleton
    @Provides
    @Named("any")
    Bus provideAnyBus(BusProvider provider) {
        return provider.getAnyBus();
    }

    @Singleton
    @Provides
    BusProvider provideBusProvider() {
        return BusProvider.INSTANCE;
    }

    @Singleton
    @Provides
    HttpHelper provideHttpHelper(HttpHelperSwitcher switcher) {
        return switcher.getHttpHelper();
    }

    @Provides
    public BaseUrls provideBaseUrls() {
        return new BaseUrlImpl();
    }

    @Singleton
    @Provides
    @Named("main")
    AKittyFileCache provideMainAKittyFileCache(Context context) {
        AKittyFileCache main = new AKittyBackupableCache(context, "main_preference");
        main.restoreQuietly();
        return main;
    }

    @Singleton
    @Provides
    @Named("account")
    AKittyFileCache provideAccountAKittyFileCache(Context context) {
        AKittyFileCache main = new AKittyBackupableCache(context, "account_preference");
        main.restoreQuietly();
        return main;
    }

    @Singleton
    @Provides
    Handler provideHandler() {
        return mHandler;
    }
}
