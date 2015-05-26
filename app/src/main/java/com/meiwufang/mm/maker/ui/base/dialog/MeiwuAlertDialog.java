package com.meiwufang.mm.maker.ui.base.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Spanned;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.meiwufang.mm.R;


/**
 * Created by linhomhom on 15-1-6.
 */
public class MeiwuAlertDialog extends MeiwuDialog implements View.OnClickListener {

    protected DialogInterface.OnClickListener mPositiveButtonOnClickListener = null;
    protected DialogInterface.OnClickListener mNegativeButtonOnClickListener = null;

    public MeiwuAlertDialog(Context context) {
        super(context);
        setContentView(getContentResId());
        findViews();
        setDismissOnTouchoutSide(true);

        llBtnPane.setVisibility(View.GONE);
        btnOK.setVisibility(View.GONE);
        btnCancel.setVisibility(View.GONE);
    }

    public int getContentResId() {
        return R.layout.mw_dlg_base_alert_dialog;
    }

    public MeiwuAlertDialog setPositiveButton(String text, DialogInterface.OnClickListener listener) {

        mPositiveButtonOnClickListener = listener;
        btnOK.setText(text);
        btnOK.setOnClickListener(this);

        llBtnPane.setVisibility(View.VISIBLE);
        btnOK.setVisibility(View.VISIBLE);

        return this;
    }

    public MeiwuAlertDialog setPositiveButton(int textResId, DialogInterface.OnClickListener listener) {

        mPositiveButtonOnClickListener = listener;
        btnOK.setText(textResId);
        btnOK.setOnClickListener(this);

        llBtnPane.setVisibility(View.VISIBLE);
        btnOK.setVisibility(View.VISIBLE);

        return this;
    }

    public MeiwuAlertDialog setNegativeButton(String text, DialogInterface.OnClickListener listener) {

        mNegativeButtonOnClickListener = listener;
        btnCancel.setText(text);
        btnCancel.setOnClickListener(this);

        llBtnPane.setVisibility(View.VISIBLE);
        btnCancel.setVisibility(View.VISIBLE);

        return this;
    }

    public MeiwuAlertDialog setNegativeButton(int textResId, DialogInterface.OnClickListener listener) {

        mNegativeButtonOnClickListener = listener;
        btnCancel.setText(textResId);
        btnCancel.setOnClickListener(this);
        llBtnPane.setVisibility(View.VISIBLE);
        btnCancel.setVisibility(View.VISIBLE);

        return this;
    }

    public MeiwuAlertDialog setMessage(String msg) {
        tvMessage.setText(msg);
        return this;
    }

    public MeiwuAlertDialog setMessage(int msgResId) {
        tvMessage.setText(msgResId);
        return this;
    }

    public MeiwuAlertDialog setMessage(Spanned msg) {
        tvMessage.setText(msg);
        return this;
    }

    public MeiwuAlertDialog setMessageTextSize(int textSizeDp) {
        tvMessage.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSizeDp);
        return this;
    }

    public MeiwuAlertDialog setTitleAD(String title) {
        tvTitle.setText(title);
        return this;
    }

    public MeiwuAlertDialog setTitleAD(int titleResId) {
        tvTitle.setText(titleResId);
        return this;
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        //throw new IllegalArgumentException("use setTitleAD");
        setTitleAD(title.toString());
    }

    @Override
    public void setTitle(int titleId) {
        super.setTitle(titleId);
        setTitleAD(titleId);
//        throw new IllegalArgumentException("use setTitleAD");
    }

    public MeiwuAlertDialog setTitleIcon(int icon_res_id) {
        ivTitleIcon.setImageResource(icon_res_id);
        return this;
    }

    public Button btnOK, btnCancel;
    TextView tvMessage;
    ImageView ivTitleIcon;
    TextView tvTitle;
    View llBtnPane;


    private void findViews() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        ivTitleIcon = (ImageView) findViewById(R.id.ivTitleIcon);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        llBtnPane = findViewById(R.id.llBtnPane);
    }

    public MeiwuAlertDialog setOnCancelListenerAD(DialogInterface.OnCancelListener listener) {
        super.setOnCancelListener(listener);
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOK: {
                if (mPositiveButtonOnClickListener != null) {
                    mPositiveButtonOnClickListener.onClick(this, R.id.btnOK);
                }
            }
            break;
            case R.id.btnCancel: {
                if (mNegativeButtonOnClickListener != null) {
                    mNegativeButtonOnClickListener.onClick(this, R.id.btnCancel);
                }
            }
            break;
            default:
                break;
        }
        if (mAutoDismiss) {
            this.dismiss();
        }
    }
}