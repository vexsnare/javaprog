package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author vinay.saini
 * @created 25/07/2020 - 6:06 PM
 */

/**
 * Concept detect cycle in a directed acyclic graph
 * Topological sort
 */
public class CourseScheduleII {


    int visited[];
    List<Integer>[] adj;
    Stack<Integer> stk;
    boolean cycle = false;

    private void go(int cur) {
        visited[cur] = 1;
        for(int i = 0; i < adj[cur].size(); i++) {
            int next = adj[cur].get(i);
            if(visited[next] == 1) {
                cycle = true;
                return;
            }
            if(visited[next] == -1)
                go(next);
        }
        visited[cur] = 2;
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
                go(i);
            }
        }

        int[] ans = new int[n];
        if(cycle) return new int[0];

        int i = 0;
        while(!stk.empty()) {
            ans[i++] = stk.pop();
        }
        return ans;
    }

}
