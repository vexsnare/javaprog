package algorithms.recursion;

import utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinay.saini
 * @created 26/08/2020 - 12:16 AM
 */
public class GeneratePalindromePartitioning {
    private boolean isPalin(String s, int lo, int hi) {
        while(lo < hi) {
            if(s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = solve(s, 0, n-1);
        return ans;
    }

    private List<List<String>> solve(String s, int lo, int hi) {
        List<List<String>> ans = new ArrayList<>();
        if(lo > hi) return ans;
        for(int k = lo; k <= hi; k++) {
            if(isPalin(s, lo, k)) {
                List<List<String>> r = solve(s, k+1, hi);
                for(int i = 0; i < r.size(); i++) {
                    List<String> p = new ArrayList<>();
                    p.add(s.substring(lo, k+1));
                    p.addAll(r.get(i));
                    ans.add(p);
                }
                if(r.size() == 0) {
                    List<String> p = new ArrayList<>();
                    p.add(s.substring(lo, k+1));
                    ans.add(p);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GeneratePalindromePartitioning gpp = new GeneratePalindromePartitioning();
        List<List<String>> ans = gpp.partition("bbbb");
        for(List<String> list: ans) {
            Printer.printStr(list);
        }
    }
}
