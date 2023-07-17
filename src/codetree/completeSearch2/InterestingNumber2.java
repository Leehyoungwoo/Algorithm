import java.util.*;

public class InterestingNumber2 {

    private static int X;
    private static int Y;
    private static int[] visited = new int[10];

    public static void main(String[] args) {
        init();
        System.out.println(answer());
    }

    private static int answer() {
        int cnt = 0;

        for (int i = X; i <= Y; i++) {
            String num = Integer.toString(i);
            for (int j = 0; j < num.length(); j++) {
                visited[num.charAt(j) - '0']++;
            }

            for (int j = 0; j < visited.length; j++) {
                if(visited[j] == num.length() - 1) {
                    cnt++;
                }
            }
            initVisited();
        }

        return cnt;
    }

    private static void initVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        X = input.nextInt();
        Y = input.nextInt();
    }
}