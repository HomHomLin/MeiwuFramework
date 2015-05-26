package code.lam.akittycache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class AKittyMemCachePrinter {

    public interface PrintCallback {
        public void onValue(String key, Serializable val);
    }

    public void print(AKittyMemCache aKittyMemCache, PrintCallback callback) {
        Map<String, Serializable> caches = aKittyMemCache.getCache();
        Set<Map.Entry<String, Serializable>> entries = caches.entrySet();
        for(Map.Entry<String, Serializable> entry : entries) {
            callback.onValue(entry.getKey(), entry.getValue());
        }
    }

    public interface PrintCallbackObject<T> {
        public void onValue(String key, Serializable val, T context);
    }

    public <T> void print(AKittyMemCache aKittyMemCache, PrintCallbackObject<T> callback, T context) {
        Map<String, Serializable> caches = aKittyMemCache.getCache();
        ArrayList<String> keys = new ArrayList<String>();
        keys.addAll(caches.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareToIgnoreCase(s2);
            }
        });
        for (String k : keys) {
            callback.onValue(k, caches.get(k), context);
        }
    }
}
