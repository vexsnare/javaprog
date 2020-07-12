package algo;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by vinaysaini on 5/28/16.
 */

/**
 * Uber Interview question
 */
public class TransformString {
    static Set<String> dict = new HashSet<String>();
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++) {
//            String s = in.nextLine();
//            dict.add(s);
//        }
        int ans = solve(s1, s2);
        System.out.println(ans);
    }
    static class State {
        String s;
        int step;
        State(String s, int step) {
            this.s = s;
            this.step = step;
        }
    }
    static int solve(String s1, String s2) {
        if(s1.length() != s2.length()) return INF;
        State a = new State(s1, 0);
        Queue<State> q = new LinkedList<State>();
        q.add(a);
        Set<String> visited = new HashSet<String>();
        while (!q.isEmpty()){
            State current = q.poll();
            if(current.s.equals(s2)) return current.step;
            if(visited.contains(current.s)) continue;
            for (int i = 0; i < current.s.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    String str = current.s.substring(0, i) + (char) (j + 'a') + current.s.substring(i + 1);
                  //  if(dict.contains(str)) {
                        q.add(new State(str, current.step+1));
                    //}
                }
            }
            visited.add(current.s);
        }
        return INF;
    }
}
