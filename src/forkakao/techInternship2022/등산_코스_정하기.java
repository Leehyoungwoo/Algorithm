package forkakao.techInternship2022;

import java.util.*;

public class 등산_코스_정하기 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[][] paths = {
                {1, 2, 3},
                {2, 3, 5},
                {2, 4, 2},
                {2, 5, 4},
                {3, 4, 4},
                {4, 5, 3},
                {4, 6, 1},
                {5, 6, 1}
        };

        int[] answer = solution.solution(6, paths, new int[]{1, 3}, new int[]{5});
        System.out.println(Arrays.toString(answer)); // [5, 3]
    }
}

class Edge implements Comparable<Edge> {
    int to, cost;

    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class Solution4 {

    private int lowIntensity = Integer.MAX_VALUE;
    private int lowIntensityNode = Integer.MAX_VALUE;
    private List<List<Edge>> graph = new ArrayList<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int from = path[0];
            int to = path[1];
            int cost = path[2];
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost));
        }
        dijkstra(gates, summits);

        return new int[]{lowIntensityNode, lowIntensity};
    }

    private void dijkstra(int[] gates, int[] summits) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] intensity = new int[graph.size()];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        for (int i = 0; i < gates.length; i++) {
            // 모든 출입구를 넣음
            pq.offer(new Edge(gates[i], 0));
        }
        
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int curIdx = cur.to;
            // 여태까지중 제일 빡센
            int curCost = cur.cost;

            if (curCost > lowIntensity) {
                continue;
            }
            for(Edge edge : graph.get(curIdx)) {
                int next = edge.to;
                int nextCost = edge.cost;
                int maxIntensity = Math.max(curCost, nextCost);
                if(Arrays.stream(summits).anyMatch(i -> i == next)) {
                    if (maxIntensity < lowIntensity || maxIntensity == lowIntensity && next < lowIntensityNode) {
                        lowIntensity = maxIntensity;
                        lowIntensityNode = next;
                    }
                } else if (intensity[next] > maxIntensity) {
                    intensity[next] = maxIntensity;
                    pq.offer(new Edge(next, maxIntensity));
                }
            }
        }
    }
}
