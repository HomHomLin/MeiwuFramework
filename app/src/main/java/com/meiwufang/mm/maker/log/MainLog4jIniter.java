package com.meiwufang.mm.maker.log;

import android.content.Context;

import com.meiwufang.mm.maker.storage.ExternalStorage;

import org.apache.log4j.Level;

import java.io.File;

import de.mindpipe.android.logging.log4j.LogConfigurator;

/**
 * Created by linhomhom on 14-12-31.
 */
public class MainLog4jIniter implements Log4jIniter {

    //日志输出格式
    public static final String LOG4J_FILE_PATTERN = "%d - [%-6p-%c] - %m%n";
    //日志文件总个数
    public static final int LOG4J_FILE_MAX_COUNT = 2;
    //单个日志文件大小
    public static final long LOG4J_FILE_MAX_SIZE = 2*1024 * 1024;
    //日志文件名
    public static final String LOG4J_FILE_NAME = "main.log";

    ExternalStorage mExternalStorage;

    public MainLog4jIniter(Context context) {
        mExternalStorage  = new ExternalStorage(context);
    }
    public String getLogFile() {
        return new File(mExternalStorage.getExternalFilesDir(null), LOG4J_FILE_NAME).getAbsolutePath();
    }

    @Override
    public void init(Level level) {
        try {
            final LogConfigurator lc = new LogConfigurator();
            lc.setFileName(getLogFile());
            lc.setFilePattern(LOG4J_FILE_PATTERN);
            lc.setMaxBackupSize(LOG4J_FILE_MAX_COUNT);
            lc.setMaxFileSize(LOG4J_FILE_MAX_SIZE);
            if (level != null) {
                lc.setRootLevel(level);
            }
            else {
                lc.setRootLevel(Level.ALL);
            }

            // Set log level of a specific logger
            lc.setLevel("org.apache", Level.ALL);
            lc.configure();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

