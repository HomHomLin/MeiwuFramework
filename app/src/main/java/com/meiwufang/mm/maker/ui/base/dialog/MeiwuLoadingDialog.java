package com.meiwufang.mm.maker.ui.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;

import com.meiwufang.mm.R;


/**
 * Created by linhomhom on 15-1-6.
 */
public class MeiwuLoadingDialog extends Dialog {

    public MeiwuLoadingDialog(Context context) {
        super(context, R.style.mw_base_loading_dialog);
        init();
    }

    public MeiwuLoadingDialog(Context context, String msg) {
        super(context, R.style.mw_base_loading_dialog);

        init();
        setMessage(msg);
    }
    public MeiwuLoadingDialog(Context context, int msgId) {
        super(context, R.style.mw_base_loading_dialog);

        init();
        setMessage(msgId);
    }

    public MeiwuLoadingDialog setOnCancelListenerAD(OnCancelListener listener) {
        setOnCancelListener(listener);
        return this;
    }
    private TextView tvLoading;

    void init() {
        setContentView(R.layout.mw_base_loading);

        tvLoading = (TextView) findViewById(R.id.tvLoading);
    }

    public void setMessage(String text) {
        tvLoading.setText(text);
    }

    public void setMessage(int textResId) {
        tvLoading.setText(textResId);
    }
}

