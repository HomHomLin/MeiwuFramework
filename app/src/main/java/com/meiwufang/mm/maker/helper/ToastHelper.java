package com.meiwufang.mm.maker.helper;

import android.app.Activity;
import android.widget.Toast;

import javax.inject.Inject;

/**
 * Created by linhomhom on 15-1-7.
 */
public class ToastHelper {
    private Activity mActivity;

    @Inject
    public ToastHelper(Activity activity) {
        mActivity = activity;
    }

    public void showLongToast(int msgResId) {
        Toast.makeText(mActivity, msgResId, Toast.LENGTH_LONG).show();
    }

    public void showLongToast(String msg) {
        Toast.makeText(mActivity, msg, Toast.LENGTH_LONG).show();
    }

    public void showShortToast(int msgResId) {
        Toast.makeText(mActivity, msgResId, Toast.LENGTH_SHORT).show();
    }
}

