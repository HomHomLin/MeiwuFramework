package com.meiwufang.mm.maker.base.otto;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by linhomhom on 14-12-31.
 */
public class BusProvider {
    public static BusProvider INSTANCE = new BusProvider();

    private Bus mMainBus = new Bus(ThreadEnforcer.MAIN);

    private Bus mAnyBus  = new Bus(ThreadEnforcer.ANY);

    public Bus getMainBus() {
        return mMainBus;
    }

    public Bus getAnyBus() {
        return mAnyBus;
    }
}
