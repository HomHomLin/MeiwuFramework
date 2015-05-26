package com.meiwufang.mm.maker.ui.base.pagger;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by linhomhom on 15-2-6.
 */
public class HoneImagePaggerV2 extends ViewPager {


    public HoneImagePaggerV2(Context context)
    {
        super(context);
    }

    public HoneImagePaggerV2(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;

    }
}