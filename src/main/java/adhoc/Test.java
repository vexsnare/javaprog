package adhoc;

import helpers.Printer;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;

class Test {
    public long solve(String[] queryType, int[][]query) {
            int l  = query.length;
            long ans  = 0;
            long key = 0, value = 0;
            HashMap<Long, Long> m = new HashMap<>();
            for(int i = 0; i < l; i++){
                String type  = queryType[i];
                if(type.equals("addToKey")) {
                    key +=query[i][0];
                } else if(type.equals("addToValue")) {
                    value += query[i][0];
                }else if(type.equals("insert")){
                    long nKey =  query[i][0]+key;
                    long nValue = query[i][1]-value;
                    m.put(nKey,nValue);
                }else {
                    ans += m.get(query[i][0]-key)+value;
                }
            }
            return ans;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.solve(new String[]{"addToKey", "addToKey", "insert", "addToValue", "addToValue", "get", "addToKey", "insert", "addToKey", "addToValue"}, new int[][]{
                {-3},
                {-1},
                {0, -3},
                {3},
                {-1},
                {0},
                {-1},
                {-4, -5},
                {-1},
                {-4}
        });

    }
}