package forkakao.winterintern2024;

import java.util.*;

public class no2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] answer = solution.solution(new int[][]{
                {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2},
                {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10},
                {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}});
        Arrays.stream(answer).forEach(System.out::println); // Expected output: 2 1 1 0
    }
}

class Solution2 {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        // [0]은 나가는거 [1]은 들어가는거
        Map<Integer, int[]> map = new HashMap<>();

        // n개의 정점과 n개의 간선
        // 노드의 수
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < edges.length; i++) {
            int[] temp = map.getOrDefault(edges[i][0], new int[2]);
            temp[0]++;
            map.put(edges[i][0], temp);
            set.add(edges[i][0]);

            int[] temp2 = map.getOrDefault(edges[i][1], new int[2]);
            temp2[1]++;
            map.put(edges[i][1], temp2);
            set.add(edges[i][1]);
        }
        // 노드가 1,2,3,4,5 이런 식이 아니라
        // 1, 3, 5, 7 이런식일수도 있어서 set에 넣은 숫자를 순회해야할듯? 단순 i++ for문으로 해서 nullpointException나오는거 같음
        for (Integer i : set) {
            //도넛 모양 그래프, 막대 모양 그래프, 8자 모양 그래프의 수의 합은 2이상이면서 들어오는 간선이 없으면 정점
            if (map.get(i)[0] >= 2 && map.get(i)[1] == 0) {
                answer[0] = i;
                continue;
            }

            // 나가는 간선이 없으면 직선 그래프
            if (map.get(i)[0] == 0 && map.get(i)[1] >= 1) {
                answer[2]++;
                continue;
            }

            // 8자형 그래프
            if (map.get(i)[0] >= 2 && map.get(i)[1] >= 2) {
                answer[3]++;
            }
        }

        // 총 그래프의 개수는 정점에서 나가는 간선의 개수
        answer[1] = map.get(answer[0])[0] - answer[2] - answer[3];
        return answer;
    }
}
