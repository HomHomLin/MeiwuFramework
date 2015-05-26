package com.meiwufang.mm.maker.module;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.telephony.TelephonyManager;

import com.androidquery.AQuery;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linhomhom on 14-12-31.
 */
@Module(
        library = true, complete = false
)
public class SystemModule {
    @Singleton
    @Provides
    AlarmManager provideAlarmManager(Context context) {
        return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    @Singleton
    @Provides
    ConnectivityManager provideConnectivityManager(Context context) {
        return (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    @Singleton
    @Provides
    TelephonyManager provideTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    @Provides
    @Singleton
    PackageManager providePackageManager(Context context) {
        return context.getPackageManager();
    }

    @Singleton
    @Provides
    WifiManager provideWifiManager(Context context) {
        return (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    @Named("expose")
    Gson provideExposeGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Singleton
    @Provides
    LocationManager provideLocationManager(Context context) {
        return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    @Singleton
    @Provides
    NotificationManager provideNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Singleton
    @Provides
    PowerManager providePowerManager(Context context) {
        return (PowerManager) context.getSystemService(Context.POWER_SERVICE);
    }

    @Singleton
    @Provides
    AQuery provideAQuery(Context context) {
        return new AQuery(context);
    }
}
