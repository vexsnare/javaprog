package psds.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Topological Sort
 * -------------------
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * Return the ordering of courses you should take to finish all courses.
 * If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */

// https://leetcode.com/problems/course-schedule-ii/description/

public class CourseSchedule {
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
/**
 *  This Concept also detects cycle in a directed acyclic graph
 */
