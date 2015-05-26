package code.lam.akittycache;

import android.content.Context;

import java.io.File;

/**
 *
 */
public class AKittyBackupableCache extends AKittyFileCache {
    public AKittyBackupableCache(Context context, String name) {
        super(context, name);
    }

    @Override
    public synchronized void save() throws Exception {
        super.save();
        if (mContext == null) {
            throw new Exception("context can't be null.");
        }
        File cache = getBackupFile();
        backupToFile(cache);
    }

    File getBackupFile() {
        return new File(mContext.getFilesDir(), getName() + "_bk");
    }

    @Override
    public synchronized void restore() throws Exception {
        try {
            super.restore();
        } finally {
            File backup_file;

            if (size() == 0
                    && (backup_file = getBackupFile()).exists()) {
                restoreFromFile(backup_file);
                save();
            }
        }
    }
}
