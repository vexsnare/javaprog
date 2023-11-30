package algorithms.math;

/**
 * @author vinay.saini
 * @created 25/08/2020 - 2:13 PM
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int  p = 0;
            while (true) {
                // complete the circle
                if(p + gas[j] >= cost[j]) {
                    p += gas[j]- cost[j];
                    j = (j+1)%n;
                    if(j == i) return i;
                } else {
                    if(j > i) i = j;
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation gs = new GasStation();
        int result = gs.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        System.out.println(result);
    }
}
