package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//https://leetcode.com/problems/combinations/

public class Combinations {
    static int[] path;
    static int K;
    static int N;
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static List<List<Integer>> combine(int n, int k) {
        K = k;
        N = n;
        path = new int[k];
        solve(1, 0);
        return ans;
    }
    static void solve(int i, int p) {
        if(p == K) {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < K; j++) {
                list.add(path[j]);
            }
            ans.add(list);
            return;
        }
        if(i == N+1) return;
        path[p] = i;
        solve(i+1, p+1);
        solve(i+1, p);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        List<List<Integer>> ret = combine(n,k);
        for (int i = 0; i < ret.size(); i++) {
            List<Integer> ar = ret.get(i);
            for (int j = 0; j < ar.size(); j++) {
                System.out.print(ar.get(j) + " ");
            }
            System.out.println();
        }
    }
}