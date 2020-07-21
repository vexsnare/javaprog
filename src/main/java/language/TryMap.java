package language;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author vinay.saini
 * @created 20/07/2020 - 10:29 PM
 */
public class TryMap {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(1,2);
        map.remove(1);
        Set<Map.Entry<Integer, Integer>> e  = map.entrySet();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : e) {
            integerIntegerEntry.getKey();
            integerIntegerEntry.getValue();
        }
    }
}
