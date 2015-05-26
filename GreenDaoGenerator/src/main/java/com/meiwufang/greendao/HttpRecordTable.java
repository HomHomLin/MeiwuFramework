package com.meiwufang.greendao;

import de.greenrobot.daogenerator.Schema;

/**
 * Created by linhomhom on 14-12-31.
 */
public class HttpRecordTable implements Table {
    Schema mSchema;

    @Override
    public void setSchema(Schema schema) {
        mSchema = schema;
    }

    @Override
    public void generate() {

    }
}
