package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));

    }

    static class Solution {

        private List<List<Integer>> graph;
        private boolean[] visited;
        private boolean[] onPath;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            graph = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : prerequisites) {
                int from = edge[1];
                int to = edge[0];
                graph.get(from).add(to);
            }

            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (hasCircle(i)) {
                    return false;
                }
            }

            return true;
        }

        private boolean hasCircle(int start) {
            if (onPath[start]) {
                return true;
            }
            if (visited[start]) {
                return false;
            }

            visited[start] = true;
            onPath[start] = true;

            for (Integer next : graph.get(start)) {
                if (hasCircle(next)) {
                    return true;
                }
            }

            onPath[start] = false;
            return false;
        }
    }
}