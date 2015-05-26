package com.meiwufang.greendao;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by linhomhom on 14-12-31.
 */
public class AppTable implements Table {
    private Schema mSchema;

    public AppTable(Schema schema) {
        setSchema(schema);
    }

    @Override
    public void setSchema(Schema schema) {
        mSchema = schema;
    }

    @Override
    public void generate() {
        Entity app = mSchema.addEntity("AppCache");

        app.addIdProperty();

        app.addStringProperty("PackageId").notNull();
        app.addStringProperty("Name");
        app.addIntProperty("VersionCode");
        app.addStringProperty("VersionName");
        app.addLongProperty("Size");
        app.addBooleanProperty("System");
        app.addStringProperty("Path");
        app.addLongProperty("Date");
        app.addBooleanProperty("exportable");
    }
}
