package adhoc;

import commons.Range;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * @author vinay.saini
 * @created 19/08/2020 - 7:56 PM
 */
public class FindTime {

    private static int gcd(int x, int y) {
        if(x == 0) return y;
        return gcd(y%x, x);
    }
    public static void main(String[] args) {
        System.out.println(gcd(12, -15));
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(1);

        System.out.println(4%(-1));
    }
}
