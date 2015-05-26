package com.meiwufang.greendao;

import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;
import de.greenrobot.daogenerator.ToMany;

/**
 * Created by linhomhom on 14-12-31.
 */
public class HttpRetryTable implements Table {
    private Schema mSchema;

    public HttpRetryTable(Schema schema) {
        mSchema = schema;
    }

    @Override
    public void setSchema(Schema schema) {
        mSchema = schema;
    }

    @Override
    public void generate() {
        Entity http_requests = addHttpRetryRequestTable();
        Entity post_params = addHttpRetryPostParamTable();
        Entity get_params = addGetParamsTable();


        addHttpRequestAndGetParamRelations(http_requests, get_params);
        addHttpRequestAndPostParamsRelations(http_requests, post_params);

    }

    private void addHttpRequestAndGetParamRelations(Entity http_requests, Entity get_params) {
        Property requestId = get_params.addLongProperty("requestId").notNull().getProperty();
        get_params.addToOne(http_requests, requestId);
        ToMany getParams = http_requests.addToMany(get_params, requestId);
        getParams.setName("getParams");
    }

    private Entity addGetParamsTable() {
        Entity get_params = mSchema.addEntity("HttpRetryGetParam");
        get_params.addIdProperty();
        get_params.addStringProperty("key").notNull();
        get_params.addStringProperty("value").notNull();
        return get_params;
    }

    private void addHttpRequestAndPostParamsRelations(Entity http_requests, Entity post_params) {
        Property requestId = post_params.addLongProperty("requestId").notNull().getProperty();
        post_params.addToOne(http_requests, requestId);
        ToMany postParams = http_requests.addToMany(post_params, requestId);
        postParams.setName("postParams");
    }

    private Entity addHttpRetryPostParamTable() {
        Entity post_params = mSchema.addEntity("HttpRetryPostParam");
        post_params.addIdProperty();
        post_params.addStringProperty("key").notNull();
        post_params.addStringProperty("value").notNull();
        post_params.addBooleanProperty("isFile").notNull();

        return post_params;
    }

    private Entity addHttpRetryRequestTable() {
        Entity http_requests = mSchema.addEntity("HttpRetryRequest");

        http_requests.addIdProperty();
        http_requests.addStringProperty("url").notNull();
        http_requests.addBooleanProperty("deleted");

        //上次重试返回Http Code
        http_requests.addIntProperty("responseCode");
        http_requests.addStringProperty("reponseResult");

        http_requests.addLongProperty("createTime");
        http_requests.addLongProperty("lastRetryTime");
        http_requests.addIntProperty("retryCount");
        return http_requests;
    }


}
