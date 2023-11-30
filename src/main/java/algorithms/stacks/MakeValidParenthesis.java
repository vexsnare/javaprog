package algorithms.stacks;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
Given a string, s, that may have matched and unmatched parentheses, remove the minimum number of parentheses so that the resulting string represents a valid parenthesization.
For example, the string “a(b)” represents a valid parenthesization while the string “a(b” doesn’t, since the opening parenthesis doesn’t have any corresponding closing parenthesis.

What is the output if the following string is given as input?
“(((abc)(to)((q)()(”
=> “(abc)(to)((q)()”
 */
public class MakeValidParenthesis {
    public String solve(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else if(s.charAt(i) == ')') {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') stack.pop();
                else stack.push(i);
            }
        }
        Set<Integer> invalidLookup = new HashSet<>();
        while (!stack.isEmpty()) invalidLookup.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!invalidLookup.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        MakeValidParenthesis makeValidParenthesis = new MakeValidParenthesis();
        String ans = makeValidParenthesis.solve("(((abc)(to)((q)()(");
        System.out.println(ans);
        String ans2 = makeValidParenthesis.solve(")))(((((");
        System.out.println(ans2);
    }
}
