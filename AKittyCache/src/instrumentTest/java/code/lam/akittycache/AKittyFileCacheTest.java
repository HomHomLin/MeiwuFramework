package code.lam.akittycache;

import android.test.AndroidTestCase;

import junit.framework.Assert;

/**
 * 测试 {@link AKittyFileCache}
 */
public class AKittyFileCacheTest extends AndroidTestCase {

    public void testSaveAndStore() throws Exception {
        AKittyFileCache cache = new AKittyFileCache(getContext(), "test");

        cache.put("key1", 98);
        cache.save();

        cache.remove("key1");
        Assert.assertNull(cache.get("key1"));

        cache.restore();
        Assert.assertEquals(98, cache.get("key1"));
    }
}
