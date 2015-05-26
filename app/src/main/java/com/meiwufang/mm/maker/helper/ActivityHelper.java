package com.meiwufang.mm.maker.helper;

import android.app.Activity;
import android.content.Intent;

import com.meiwufang.mm.R;

import javax.inject.Inject;

/**
 * Created by linhomhom on 15-1-4.
 */
public class ActivityHelper {

    @Inject
    public ActivityHelper() {
    }

    public void start(Activity activity, Intent intent) {
        activity.startActivity(intent);
        overridePendingTransitionStart(activity);
    }

    public void startForResult(Activity activity, Intent intent, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
        overridePendingTransitionStart(activity);
    }

    public void overridePendingTransitionStart(Activity activity) {
        activity.overridePendingTransition(R.anim.mw_base_slide_in_right, R.anim.mw_base_slide_out_left);
    }

    public void overridePendingTransitionBack(Activity activity) {
        activity.overridePendingTransition(R.anim.mw_base_slide_in_left, R.anim.mw_base_slide_out_right);
    }

    public void finish(Activity activity) {
        activity.finish();
        overridePendingTransitionBack(activity);
    }

    public void startFade(Activity activity, Intent intent) {
        activity.startActivity(intent);
        overridePendingTransitionFade(activity);
    }

    public void overridePendingTransitionFade(Activity activity) {
        activity.overridePendingTransition(R.anim.mw_base_fade_in, R.anim.mw_base_fade_out);
    }
}

