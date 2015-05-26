package code.lam.akittycache;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A KittyCache can be save to File.
 * by fanxu
 */
public class AKittyFileCache extends AKittyMemCache implements AKittyFileStore {

    public static final String PREF_LAST_SAVE_TIME    = "AKitty.last_save_time";
    public static final String PREF_LAST_RESTORE_TIME = "AKitty.last_restore_time";

    public AKittyFileCache() {
    }

    public AKittyFileCache(Context context, String name) {
        setContext(context);
        setName(name);
    }

    protected String mName;

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setName(String name) {
        mName = name;
    }

    @Override
    public synchronized void save() throws Exception {
        if (mContext == null) {
            throw new Exception("context can't be null.");
        }
        File cache = new File(mContext.getFilesDir(), getName());
        put(PREF_LAST_SAVE_TIME, new Date().toString());
        backupToFile(cache);
    }

    public void backupToFile(File cache) throws Exception {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(cache));
            oos.writeObject(mCache);
            oos.writeObject(mSize);
        } finally {
            if (oos != null) {
                oos.close();
            }
        }
    }

    @Override
    public synchronized void restore() throws Exception {
        if (mContext == null) {
            throw new Exception("context can't be null.");
        }

        File cache = new File(mContext.getFilesDir(), getName());
        restoreFromFile(cache);

        put(PREF_LAST_RESTORE_TIME, new Date().toString());
    }

    public void restoreFromFile(File cache) throws Exception {
        Log.d("AKittyFileCache", "restoreFromFile: " + cache.getAbsolutePath());
        ObjectInputStream ois = null;
        try {
            if (!cache.exists()) {
                mCache = new HashMap<String, Serializable>();
                mSize = new AtomicInteger();
                return;
            }
            ois = new ObjectInputStream(new FileInputStream(cache));

            mCache.clear();
            mCache = null;
            mSize = null;

            mCache = (Map<String, Serializable>) ois.readObject();
            mSize = (AtomicInteger) ois.readObject();
        } finally {
            if (ois != null) {
                ois.close();
            }

            if (mCache == null || mSize == null) {
                mCache = new HashMap<String, Serializable>();
                mSize = new AtomicInteger();
            }
        }
    }

    @Override
    public boolean saveQuietly() {
        try {
            save();
            return true;
        } catch (Exception e) {
            onSaveFailed(e);
            return false;
        }
    }

    public static final String KEY_SAVE_FAILED = "save_failed";

    void onSaveFailed(Exception e) {
        appendValue(KEY_SAVE_FAILED, "msg: " + e.getMessage() + ", " + new Date().toString());
    }

    public static final String KEY_RESTORE_FAILED = "restore_failed";

    void onRestoreFailed(Exception e) {
        appendValue(KEY_RESTORE_FAILED, "msg: " + e.getMessage() + ", " + new Date().toString());
    }

    void appendValue(String key, String value) {
        String last_value = getString(key, "");
        put(key, last_value + ";" + value);
    }

    @Override
    public boolean restoreQuietly() {
        try {
            restore();
            return true;
        } catch (Exception e) {
            onRestoreFailed(e);
            return false;
        }
    }

    protected Context mContext;

    @Override
    public void setContext(Context context) {
        mContext = context;
    }
}
