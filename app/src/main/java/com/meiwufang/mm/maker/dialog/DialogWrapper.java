package com.meiwufang.mm.maker.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

import com.meiwufang.mm.maker.helper.DialogHelper;

/**
 * Created by linhomhom on 15-1-7.
 */
public abstract class DialogWrapper<T extends Dialog> {

    private Activity mActivity;

    public DialogWrapper(Activity activity) {
        mActivity = activity;
    }

    T mDialog;

    /**
     * 构建对话框
     */
    public abstract T onCreate(Context context);

    public T getDialog() {
        if (mDialog == null) {
            mDialog = onCreate(mActivity);
        }
        return mDialog;
    }

    /**
     * 显示
     */
    public void show() {
        try {
            T dialog = getDialog();
            if (!dialog.isShowing()) {
                new DialogHelper(mActivity).showDialog(dialog);
            }
        } catch (Exception e) {
        }
    }

    /**
     * 隐藏
     */
    public void dismiss() {
        try {
            T dialog = getDialog();
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
        } catch (Exception e) {
        }
    }
}

