package leetcode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfConnectedComponents {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3,4}}));
    }

    static class Solution {
        public int countComponents(int n, int[][] edges) {
            boolean[] visited = new boolean[n];
            int count = 0;
            List<List<Integer>> graph = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> l = new LinkedList<>();
                graph.add(l);
            }

            for (int i = 0; i < edges.length; i++) {
                int from = edges[i][0];
                int to = edges[i][1];
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    bfs(graph, visited, i);
                    count++;
                }
            }

            return count;
        }

        private void bfs(List<List<Integer>> graph, boolean[] visited, int cur) {
            Queue<Integer> que = new LinkedList<>();
            que.offer(cur);
            visited[cur] = true;
            while (!que.isEmpty()) {
                int c = que.poll();
                for (int next : graph.get(c)) {
                    if (!visited[next]) {
                        que.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
    }
}
