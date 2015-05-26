package com.meiwufang.greendao;

import de.greenrobot.daogenerator.Schema;

/**
 * Created by linhomhom on 14-12-31.
 */
public interface Table {

    public void setSchema(Schema schema);
    public void generate();
}
