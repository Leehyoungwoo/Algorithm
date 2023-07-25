package BOJ;

import java.util.*;

public class BOJ_2980 {

    private static int N;
    private static int L;
    private static char[] road;
    private static int[] redLight;
    private static int[] greenLight;

    public static void main(String[] args) {
        init();
        int answer = goingRoad();
        System.out.println(answer);
    }

    private static int goingRoad() {
        int time = 0;
        int trafficLight = 0;

        for (int i = 0; i < road.length; i++) {
            if (i != road.length - 1 && isNextTrafficLight(i + 1)) {
                if (isRedRight(i, time, trafficLight)) {
                    time += (redLight[trafficLight] - time % (redLight[trafficLight] + greenLight[trafficLight]));
                }
                trafficLight++;
            }
            time++;
        }

        return time - 1;
    }

    private static boolean isRedRight(int i, int time, int trafficLight) {
        int range = time % (redLight[trafficLight] + greenLight[trafficLight]);
        return 0 <= range && range < redLight[trafficLight];
    }

    private static boolean isNextTrafficLight(int i) {
        return road[i] == '!';
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        L = input.nextInt();
        road = new char[L];
        redLight = new int[N];
        greenLight = new int[N];

        for (int i = 0; i < N; i++) {
            int D = input.nextInt();
            int R = input.nextInt();
            int G = input.nextInt();

            road[D] = '!';
            redLight[i] = R;
            greenLight[i] = G;
        }
    }
}