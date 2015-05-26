package code.lam.akittycache;

import java.io.Serializable;

/**
 * by fanxu
 */
public interface AKittyCache {
    /**
     * put a new one
     * @param key
     * @param val
     */
    public void put(String key, Serializable val);

    /**
     * get data from cache
     * @param key
     * @return
     */
    public Serializable get(String key);

    /**
     * remove from cache
     * @param key
     */
    public Serializable remove(String key);

    public int getInt(String key, int def);
    public long getLong(String key, long def);
    public String getString(String key, String def);
    public boolean getBoolean(String key, boolean def);
    public float getFloat(String key, float def);
    public double getDouble(String key, double def);

    public int size();
}
