package com.meiwufang.mm.maker.helper;

import android.app.ActivityManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Lazy;

/**
 * Created by linhomhom on 14-12-31.
 */
@Singleton
public class OSHelper {

    Context mContext;

    @Inject
    public OSHelper(Context context) {
        mContext = context;
    }

    /**
     * 获取进程名。
     *
     * @param pid 进程id
     * @return 进程名
     */
    public String getProcessNameByPid(int pid) {
        ActivityManager manager = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo processInfo : manager.getRunningAppProcesses()) {
            if (processInfo.pid == pid) {
                return processInfo.processName;
            }
        }
        return "";
    }

    @Inject
    Lazy<TelephonyManager> mTelephonyManager;

    /**
     * Android ID
     */
    public String getAndroidID() {
        try {
            String androidId = Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.ANDROID_ID);
            return androidId == null ? "" : androidId;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    public String getIMEI() {
        try {
            return mTelephonyManager.get().getDeviceId() == null ? "" : mTelephonyManager.get().getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getMacAddress() {
        WifiManager wifiMgr = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = (null == wifiMgr ? null : wifiMgr.getConnectionInfo());
        if (null != info) {
            return info.getMacAddress();
        }
        return null;
    }


    public String getId() {
        String s = getIMEI() + getAndroidID() + getMacAddress();
        return getMd5(s);
    }

    public String getMd5(String text) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(text.getBytes("utf-8"));
            byte[] bytes = algorithm.digest();
            StringBuilder hexString = new StringBuilder();
            String hs;
            for (byte b : bytes) {
                hs = Integer.toHexString(0xFF & b);
                if (hs.length() == 1) {
                    hexString.append("0").append(hs);
                } else {
                    hexString.append(hs);
                }
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            //never happened.
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
