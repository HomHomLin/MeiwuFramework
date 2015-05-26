package code.lam.akittycache;

import android.test.AndroidTestCase;
import android.util.Log;

import junit.framework.Assert;

/**
 * 测试 {@link AKittyMemCache}
 */
public class AKittyMemCacheTest extends AndroidTestCase {

    public void testBatch() {
        AKittyCache kc = new AKittyMemCache();

        long before = System.currentTimeMillis();

        for (int i = 0 ; i < 60000; i ++) {
            kc.put("test" + i, "lklksdksdd");
            kc.get("test" + i);
        }
        long after = System.currentTimeMillis();

        Log.d("AKittyMemCacheTest", "testBatch: " + (after - before) + "ms");
    }

    public void testPutAndGet() {
        AKittyCache kc = new AKittyMemCache();
        kc.put("key1", "value1");
        Assert.assertTrue("value1".equals(kc.get("key1")));
    }
    public void testNullValue() {
        AKittyCache kc = new AKittyMemCache();
        assertNull(kc.get("null_value_key"));

        assertEquals(123, kc.getInt("null_value_key", 123));
        assertEquals(13l, kc.getLong("null_value_key", 13l));
        assertEquals("haha", kc.getString("null_value_key", "haha"));
    }
}
