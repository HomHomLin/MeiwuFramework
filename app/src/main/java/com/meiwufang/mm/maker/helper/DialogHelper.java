package com.meiwufang.mm.maker.helper;

import android.app.Activity;
import android.app.Dialog;

import com.meiwufang.mm.R;
import com.meiwufang.mm.maker.ui.base.dialog.MeiwuAlertDialog;


/**
 * Created by linhomhom on 15-1-6.
 */
public class DialogHelper {

    Activity mActivity;

    public DialogHelper(Activity activity) {
        mActivity = activity;
    }

    public void showAlertDialog(int msgResId) {
        showDialog(
                new MeiwuAlertDialog(mActivity)
                        .setMessage(msgResId)
                        .setPositiveButton(R.string.mw_ok, null)
        );
    }

    public void showAlertDialog(int msgResId,String sErrCode) {
        showDialog(
                new MeiwuAlertDialog(mActivity)
                        .setMessage(mActivity.getResources().getString(msgResId)+ " ("+sErrCode+")")
                        .setPositiveButton(R.string.mw_ok, null)
        );
    }

    public void showAlertDialog(String str) {
        showDialog(
                new MeiwuAlertDialog(mActivity)
                        .setMessage(str)
                        .setPositiveButton(R.string.mw_ok, null)
        );
    }

    /**
     * 显示对话框， 自带判断
     */
    public void showDialog(Dialog dialog) {
        if (!mActivity.isFinishing()) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.show();
        }
    }
}

