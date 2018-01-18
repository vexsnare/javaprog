package Leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        int[] fr = new int[26];
        boolean marked[] = new boolean[26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            fr[c-'a']++;
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.empty()) {
                stack.push(c);
                fr[c-'a']--;
                marked[c-'a'] =true;
            } else {
                fr[c-'a']--;
                if(marked[c-'a']) continue;
                while(!stack.empty() && stack.peek() > c && fr[stack.peek()-'a'] > 0) {
                    marked[stack.pop()-'a'] = false;
                }
                stack.push(c);
                marked[c-'a'] = true;
            }
        }
        String result = "";
        while(!stack.empty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}