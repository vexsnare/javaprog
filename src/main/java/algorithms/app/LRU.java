package algorithms.app;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author vinay.saini
 * @created 14/09/2020 - 7:51 PM
 */
public class LRU {
    LinkedHashMap<String, String> lm;
    LRU(int capacity) {
        lm = new LinkedHashMap<String, String>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest)
            {
                return size() > capacity;
            }
        };
    }
    private void add(String key, String value) {
        lm.put(key, value);
    }

    private String get(String key) {
        return lm.getOrDefault(key, "");
    }

}
