package codetree.completeSearch;

import java.util.*;

public class LevelingTheField {

    private static int N;
    private static int H;
    private static int T;
    private static int[] height;

    public static void main(String[] args) {
        init(); // 초기화 메서드, 입력값 받아 오는 것을 처리
        System.out.println(answer());
    }

    private static int answer() {	// 최소 비용을 찾아 내서 int값으로 반환하게 만드는 메서드
        int min = Integer.MAX_VALUE;

        //순서대로 정렬한 밭의 높이를 매 i마다 T구간씩 최소 비용을 계산하여 최소값을 찾아보기
        for (int i = 0; i < height.length - (T-1); i++) {
            int cost = findCostOfEachArea(i, i + (T-1));
            min = Math.min(cost, min);
        }

        return min;
    }

    private static int findCostOfEachArea(int start, int end) {
        int sumCost = 0;

        // 매개변수로 받은 시작점과 끝점에서 높이를 H로 수정할때 드는 비용을 더함,
        // 각각의 값이 음수일지 양수일지 모르니 절대값을 씌워줘서 더해야함
        for(int i = start; i <= end; i++) {
            sumCost+=Math.abs(H-height[i]);
        }
        return sumCost;
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        H = input.nextInt();
        T = input.nextInt();
        height = new int[N];

        Arrays.sort(height); 	//배열이 크게와 상관없이 뒤죽박죽으로 되어 있으면
        //구간으로 훑어도 진짜 최솟값을 찾지 못할수도

        for (int i = 0; i < height.length; i++) {
            height[i] = input.nextInt();
        }
    }

}
