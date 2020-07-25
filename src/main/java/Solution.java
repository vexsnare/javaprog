import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {

    int visited[];
    List<Integer>[] adj;
    Stack<Integer> stk;
    boolean cycle = false;

    private void go(int cur, int mark) {
        visited[cur] = mark;
        for(int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur].get(i);
            if(visited[next] == mark) {
                cycle = true;
                return;
            }
            if(visited[next] == -1) go(next, mark);
        }
        stk.push(cur);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        stk = new Stack<Integer>();
        visited = new int[n];
        Arrays.fill(visited, -1);
        adj = new ArrayList[n];
        // initialize
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        // fill dag details
        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        // dfs
        for(int i = 0; i < n && !cycle; i++) {
            if(visited[i] == -1) {
                go(i, i);
            }
        }

        if(cycle){
            return new int[0];
        }
        int[] ans = new int[n];
        int i = 0;
        while(!stk.empty()) {
            ans[i++] = stk.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intput = {{0,1}};
        sol.findOrder(2, intput);
    }
}