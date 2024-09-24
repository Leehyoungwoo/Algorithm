package forkakao.blindrecruitment2023;

import java.util.*;

public class 떨어뜨리기 {

    public static void main(String[] args) {
        Solution7 solution = new Solution7();
        int[][] edges = {
                {2, 4},
                {1, 2},
                {6, 8},
                {1, 3},
                {5, 7},
                {2, 5},
                {3, 6},
                {6, 10},
                {6, 9}
        };
        int[] target = {0, 0, 0, 3, 0, 0, 5, 1, 2, 3};
        int[] answer = solution.solution(edges, target);
        Arrays.stream(answer).forEach(System.out::println);
    }
}
class Solution7 {
    // 아직 못품
    public int[] solution(int[][] edges, int[] target) {
        int[] answer = {};
        return answer;
    }
}
