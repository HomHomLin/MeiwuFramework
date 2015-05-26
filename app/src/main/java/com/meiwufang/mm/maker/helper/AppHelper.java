package com.meiwufang.mm.maker.helper;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by linhomhom on 15-2-26.
 */
@Singleton
public class AppHelper {
    @Inject
    public AppHelper(){

    }

    public void openMarket(Context context, String package_name) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + package_name)));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, "没有找到任何市场", Toast.LENGTH_LONG).show();
        }
    }
}
