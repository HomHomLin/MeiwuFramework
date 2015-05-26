package code.lam.akittycache;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * KittyCache.
 * <p/>
 * Copy implement from "Kitty-Cache"
 * by fanxu
 */
public class AKittyMemCache implements AKittyCache {

    public static final String PREF_LAST_PUT_TIME = "AKitty.last_put_time";

    protected Map<String, Serializable> mCache = new ConcurrentHashMap<String, Serializable>(500);
    protected AtomicInteger mSize  = new AtomicInteger();

    public Map<String, Serializable> getCache() {
        return Collections.unmodifiableMap(mCache);
    }
    @Override
    public void put(String key, Serializable val) {
        if (key == null || val == null) {
            throw new NullPointerException("key or val is null.");
        }

        mCache.put(key, val);
        mCache.put(PREF_LAST_PUT_TIME, new Date().toString());
    }

    @Override
    public Serializable get(String key) {
        if (key == null) {
            throw new NullPointerException("key is null.");
        }
        return mCache.get(key);
    }

    @Override
    public int size() {
        return mCache.size();
    }

    @Override
    public Serializable remove(String key) {
        if (key == null) {
            throw new NullPointerException("key is null.");
        }
        mSize.decrementAndGet();
        return mCache.remove(key);
    }

    @Override
    public int getInt(String key, int def) {
        Object value = get(key);
        return value != null ? (Integer) value : def;
    }

    @Override
    public long getLong(String key, long def) {
        Object value = get(key);
        return value != null ? (Long) value : def;
    }

    @Override
    public String getString(String key, String def) {
        Object value = get(key);
        return value != null ? (String) value : def;
    }

    @Override
    public boolean getBoolean(String key, boolean def) {
        Object value = get(key);
        return value != null ? (Boolean) value : def;
    }

    @Override
    public float getFloat(String key, float def) {
        Object value = get(key);
        return value != null ? (Float) value : def;
    }

    @Override
    public double getDouble(String key, double def) {
        Object value = get(key);
        return value != null ? (Double) value : def;
    }
}
