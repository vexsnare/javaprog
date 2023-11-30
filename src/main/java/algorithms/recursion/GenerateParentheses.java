package algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinay.saini
 * @created 17/08/2020 - 7:05 PM
 */
public class GenerateParentheses {
    List<String > ans;
    int N;


    private  List<String> genParanthesis(int n) {
        this.N = n;
        this.ans = new ArrayList<>();
        if(n <= 0) return ans;
        solve("(", 1);
        return ans;
    }

    private void solve(String s, int open) {
        if(s.length() == 2*N) {
            if(open == 0) ans.add(s);
            return;
        }
        int lastIndex = s.length()-1;
        if(s.charAt(lastIndex) == '(') {
            solve(s + "(", open + 1);
            solve(s + ")", open - 1);
        }
        if(s.charAt(lastIndex) == ')') {
            solve(s + "(", open + 1);
            if(open > 0)
                solve(s + ")", open - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses parenthesis = new GenerateParentheses();
        parenthesis.genParanthesis(5);
        for(String s: parenthesis.ans) {
            System.out.println(s);
        }
    }
}
