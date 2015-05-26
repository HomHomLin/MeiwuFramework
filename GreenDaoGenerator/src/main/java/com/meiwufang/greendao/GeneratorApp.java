package com.meiwufang.greendao;

import java.io.File;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by linhomhom on 14-12-31.
 */
public class GeneratorApp {
    public static final String GREEN_DAO_CODE_PATH = "../app/src/main/database/";
    public static final int VERSION = 18;
    public static final String PACKAGE_NAME = "com.honemen.lanfang.database";

    /**
     * 运行程序
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {

        File code = new File(GREEN_DAO_CODE_PATH);
        if (!code.exists()) {
            code.mkdirs();
        }
        //System.out.println("Generate greendao code to: " + code.getCanonicalPath());
        Schema schema = new Schema(VERSION, PACKAGE_NAME);

        HttpRetryTable http_retry = new HttpRetryTable(schema);
        http_retry.generate();

        AppTable at = new AppTable(schema);
        at.generate();

        new DaoGenerator().generateAll(schema, GREEN_DAO_CODE_PATH);
    }
}
