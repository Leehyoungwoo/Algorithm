package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validTree(5, new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 4}
        }));
    }

    static class Solution {

        private List<List<Integer>> graph;
        private boolean[] visited;

        public boolean validTree(int n, int[][] edges) {
            graph = new ArrayList<>();
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int a = edge[0];
                int b = edge[1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            if (hasCycle(-1, 0)) {
                return false;
            }

            for (boolean v : visited) {
                if (!v) {
                    return false;
                }
            }

            return true;
        }

        private boolean hasCycle(int parent, int node) {
            visited[node] = true;

            for (int next : graph.get(node)) {
                if (!visited[next]) {
                    if (hasCycle(node, next)) {
                        return true;
                    }
                } else if (next != parent) {
                    return true;
                }
            }
            return false;
        }
    }
}
