package com.meiwufang.mm.maker.ui.base;


import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meiwufang.mm.R;
import com.meiwufang.mm.maker.helper.ActivityHelper;


/**
 * Created by Linhh on 2014/8/17.
 */
public class MeiwuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initTitle();
    }

    protected TextView tvTitle;
    protected ActionBar actionBar;

    void initTitle() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        View customView = View.inflate(this, R.layout.mw_base_actionbar_custom_view, null);
        TextView title = tvTitle = (TextView) customView.findViewById(R.id.title);
        title.setText(getTitle());
        LinearLayout llBack = (LinearLayout) customView.findViewById(R.id.llBack);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        actionBar.setCustomView(customView, layoutParams);

        llBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });
    }

    public void back() {
        mActivityHelper.finish(MeiwuActivity.this);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        tvTitle.setText(title);
    }

    @Override
    public void setTitle(int titleId) {
        super.setTitle(titleId);
        tvTitle.setText(titleId);
    }

    public ActivityHelper mActivityHelper = new ActivityHelper();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            back();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        back();
    }

    /**
     * Copied from android annotation
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (((Build.VERSION.SDK_INT < 5) && (keyCode == KeyEvent.KEYCODE_BACK)) && (event.getRepeatCount() == 0)) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }
}
