package code.lam.akittycache;

import android.content.Context;

/**
 * by fanxu
 */
public interface AKittyFileStore {

    /**
     * Store name
     * @return
     */
    public String getName();

    /**
     * set Store name of this File Store
     * @param name
     */
    public void setName(String name);

    /**
     * Save to File
     */
    public void save() throws Exception;

    /**
     * Restore from file
     */
    public void restore() throws Exception;

    public boolean saveQuietly();
    public boolean restoreQuietly();

    public void setContext(Context context);
}
