package leetcode;

import java.util.*;

/**
 * @author vinay.saini
 * @created 25/08/2020 - 2:13 PM
 */
public class GasStation {
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        if (A.isEmpty()) return -1;
        int startStation = 0;
        int curStation = 0;
        int petrol = 0;
        int n = A.size();
        while (startStation < n) {
            while (petrol + A.get(curStation) >= B.get(curStation)) {
                petrol -= B.get(curStation);
                petrol += A.get(curStation);
                curStation = (curStation + 1) % n;
                if(curStation == startStation) return startStation;
            }
            if(curStation < startStation) return -1;
            startStation = curStation + 1;
            curStation = startStation;
            petrol = 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation gs = new GasStation();
        int result = gs.canCompleteCircuit(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(3, 4, 5, 1, 2 ));
        System.out.println(result);
    }
}
