package com.meiwufang.mm.maker.storage;

import android.content.Context;
import android.os.Environment;

import com.meiwufang.mm.BuildConfig;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by linhomhom on 14-12-31.
 */
@Singleton
public class ExternalStorage {

    private Context mContext;

    @Inject
    public ExternalStorage(Context context) {
        mContext = context;
    }

    public File getExternalFilesDir(String type) {
        File result = null;
        try {
            if (isExternalStorageAvailable()) {
                result = mContext.getExternalFilesDir(type);
            }
            if (result == null) {
                //外置sdcard无效时的兼容处理.
                result = new File("/sdcard/android/data/" + BuildConfig.APPLICATION_ID + "/" + type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public File getExternalCacheDir() {
        return getExternalFilesDir("cache");
    }

    /**
     * 外置存储是否可用
     */
    public boolean isExternalStorageAvailable() {
        try {
            return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
        } catch (Exception ex) {
            return false;
        }
    }
}
