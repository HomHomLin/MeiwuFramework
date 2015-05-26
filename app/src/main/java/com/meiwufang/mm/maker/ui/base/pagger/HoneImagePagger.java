package com.meiwufang.mm.maker.ui.base.pagger;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by linhomhom on 15-2-6.
 */
public class HoneImagePagger extends ViewPager {


    public HoneImagePagger(Context context)
    {
        super(context);
    }

    public HoneImagePagger(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        try
        {
            return super.onInterceptTouchEvent(ev);
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}