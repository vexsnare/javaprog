package leetcode;

import java.util.*;

/**
 * @author vinay.saini
 * @created 05/09/2020 - 11:10 PM
 */
public class AlientDictionary {
    Map<Character, List<Character>> m = new HashMap<>();
    Map<Character, Integer> visited = new HashMap<>();
    boolean isCyclic = false;
    private void findDiff(String s1, String s2) {
        for(int i = 0; i < s1.length() && i < s2.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 != c2) {
                // if(m.containsKey(c1)) {
                //     m.put(c1, m.get(c1).add(c2));
                // } else {
                //     List<Character> list = new ArrayList<>();
                // }
                List<Character> adj = m.getOrDefault(c1, new ArrayList<>());
                if(!adj.contains(c2)) adj.add(c2);
                m.put(c1, adj);
                break;
            }
        }
    }
    private int[] extractChars(String s) {
        for(int i = 0; i < s.length(); i++) {
            visited.put(s.charAt(i), 0);
        }
        return null;
    }

    void go(Stack<Character> seq, char c) {
        if(visited.get(c) == 2) return;
        if(visited.get(c) == 1) {
            isCyclic = true;
            return;
        };
        if(!m.containsKey(c)) {
            visited.put(c, 2);
            seq.add(c);
        } else {
            visited.put(c, 1);
            for(int k = 0; k < m.get(c).size(); k++) {

                go(seq, m.get(c).get(k));

            }
            visited.put(c, 2);
            seq.add(c);
        }
    }

    public String alienOrder(String[] words) {
        extractChars(words[0]);
        for (int i = 1; i < words.length; i++) {
            findDiff(words[i-1], words[i]);
            extractChars(words[i]);
        }

        // Topological sort
        Stack<Character> stk = new Stack<>();
        for(char c: visited.keySet()) {
            if(visited.get(c) == 2) continue;
            go(stk, c);
            if(isCyclic) return "";
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AlientDictionary alientDictionary = new AlientDictionary();
        System.out.println(alientDictionary.alienOrder(new String[]{"za","zb","ca","cb"}));
    }
}
