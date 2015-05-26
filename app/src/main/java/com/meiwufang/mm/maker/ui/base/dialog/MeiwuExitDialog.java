package com.meiwufang.mm.maker.ui.base.dialog;

import android.app.Dialog;
import android.view.MotionEvent;
import android.view.View;

import com.meiwufang.mm.MmActivityMainActivity;
import com.meiwufang.mm.R;
import com.meiwufang.mm.maker.base.otto.event.ExitDialogOKClickedEvent;
import com.squareup.otto.Bus;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by linhomhom on 15-1-6.
 */
public class MeiwuExitDialog extends Dialog implements View.OnClickListener{

    @Inject
    public MeiwuExitDialog(MmActivityMainActivity activity) {
        super(activity, R.style.mw_base_dialog_no_frame);

        setContentView(R.layout.mw_base_exit_dialog_view);
        findViewById(R.id.ok).setOnClickListener(this);
        findViewById(R.id.cancel).setOnClickListener(this);
    }
    @Inject
    @Named("main")
    Bus mMain;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() != MotionEvent.ACTION_UP) {
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok: {
                dismiss();
                mMain.post(new ExitDialogOKClickedEvent());
            }
            break;
            case R.id.cancel: {
                dismiss();
            }
            break;
            default:
                break;
        }
    }
}

