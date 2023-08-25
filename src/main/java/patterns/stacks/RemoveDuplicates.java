package patterns.stacks;

/*
You are given a string consisting of lowercase English letters. Repeatedly remove adjacent duplicate letters, one pair at a time. Both members of a pair of adjacent duplicate letters need to be removed.
azxxzy => ay
ab => ab
 */
// EASY

import helpers.Tester;

import java.util.*;
public class RemoveDuplicates {
    public String solve(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(c);
            } else {
                boolean flag = false;
                while(!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                    flag = true;
                }
                if(!flag) stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        Tester.assertEqual(removeDuplicates.solve("azxxzy"), "ay");
        Tester.assertEqual(removeDuplicates.solve("ay"), "ay");
        Tester.assertEqual(removeDuplicates.solve("abby"), "ay");
        Tester.assertEqual(removeDuplicates.solve("abba"), "");
    }
}

