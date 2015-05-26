package com.meiwufang.mm.maker.ui.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;

import com.meiwufang.mm.R;


/**
 * Created by linhomhom on 15-1-6.
 */
public class MeiwuDialog extends Dialog {

    protected boolean mAutoDismiss = true;

    public void setAutoDismiss(boolean auto) {
        mAutoDismiss = auto;
    }
    protected boolean mDismissOnTouchOutSide = false;
    public void setDismissOnTouchoutSide(boolean dismissed) {
        mDismissOnTouchOutSide = dismissed;
    }
    public MeiwuDialog(Context context) {
        super(context, R.style.mw_base_dialog);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() != MotionEvent.ACTION_UP || !mDismissOnTouchOutSide) {
            return super.dispatchTouchEvent(ev);
        }

        float x = ev.getX();
        float y = ev.getY();

        int left = this.getWindow().getDecorView().getLeft();
        int right = this.getWindow().getDecorView().getRight();
        int top = this.getWindow().getDecorView().getTop();
        int bottom = this.getWindow().getDecorView().getBottom();

        if (!(x < right && x > left && y > top && y < bottom)) {
            dismiss();
        }
        return super.dispatchTouchEvent(ev);
    }
}

