import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(fraction(-1, 20398077));
    }
    public static String fraction(int n, int d) {
        boolean neg = n < 0 && d > 0 || n > 0 && d < 0;
        long neum = n;
        long denom = d;
        neum = Math.abs(neum);
        denom = Math.abs(denom);
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        ans.append(Long.toString(neum/denom));
        long rem = neum % denom;
        if(rem == 0) return ans.toString();
        Map<Long, Integer> map = new HashMap<>();
        ans.append(".");
        while (rem > 0) {
            if(map.containsKey(rem)) {
                int idx = map.get(rem);
                return ans.append(temp.substring(0, idx)).append('(').append(temp.substring(idx)).append(')').toString();
            }
            map.put(rem, temp.length());
            rem *= 10;
            temp.append(Long.toString(rem/denom));
            rem = rem % denom;
        }
        return (neg ? "-" : "") + ans.toString() + temp.toString();
    }
}