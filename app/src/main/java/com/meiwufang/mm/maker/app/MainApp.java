package com.meiwufang.mm.maker.app;

import android.graphics.Bitmap;

import com.meiwufang.mm.maker.configs.AppConfig;
import com.meiwufang.mm.maker.storage.ExternalStorage;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;

import org.apache.log4j.Level;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by Linhh on 15/5/26.
 */
public class MainApp implements MyApp {

    private MeiwuApp mMeiwuApp;
    private ObjectGraph mObjectGraph;
    private AppConfig mAppConfig;

    public MainApp(MeiwuApp meiwuApp, AppConfig appConfig) {
        setMeiwuApp(meiwuApp);
        setAppConfig(appConfig);
    }

    @Override
    public void setMeiwuApp(MeiwuApp meiwuApp) {
        mMeiwuApp = meiwuApp;
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }

    @Override
    public void setAppConfig(AppConfig appConfig) {
        mAppConfig = appConfig;
    }


    @Override
    public void onCreate() {
        initObjectGraph();
        mObjectGraph.inject(this);
        initLog4j();
        initImageLoader();
    }

    @Inject
    ExternalStorage mExternalStorage;

    private void initImageLoader() {
        File cacheDir = mExternalStorage.getExternalCacheDir();
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .imageScaleType(ImageScaleType.EXACTLY)
                .resetViewBeforeLoading(true)
                .delayBeforeLoading(50)
                .cacheInMemory(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .cacheOnDisk(true)
                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mMeiwuApp)
                .defaultDisplayImageOptions(displayImageOptions)
                .memoryCache(new LruMemoryCache(25 * 1024 * 1024))
                .memoryCacheSize(25 * 1024 * 1024)
                .diskCacheSize(500 * 1024 * 1024)
                .denyCacheImageMultipleSizesInMemory()
                .diskCache(new UnlimitedDiscCache(cacheDir))
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .threadPoolSize(4)
                .memoryCacheSizePercentage(30)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .diskCacheFileCount(500)
                .build();
        ImageLoader.getInstance().init(config);
    }

    @Override
    public void onTerminate() {
        mObjectGraph = null;
    }

    private void initObjectGraph() {
        mObjectGraph = ObjectGraph.create(getModules(mMeiwuApp).toArray());
    }

    private List<Object> getModules(MeiwuApp meiwuApp) {
        return Arrays.<Object>asList(
                new AppModule(meiwuApp)
        );
    }

    private void initLog4j() {
        Level level = null;
        mAppConfig.getMainLog4jIniter(mMeiwuApp).init(level);
    }
}

