package codetree.completeSearch;

import java.util.*;

public class BeautifulSequence2 {

    private static int n;
    private static int m;
    private static int[] a;
    private static int[] b;
    private static int cnt = 0;
    private static boolean[] visited;

    public static void main(String[] args) {
        init();
        System.out.print(answer());
    }

    private static int answer() {
        for (int i = 0; i < a.length - (m-1); i++) {
            visitedInit();

            if(isBeautiful(i, i + (m-1))) {
                cnt++;
                //아름다운 수열이면 count를 올려줌
                // 매개변수로 시작점인 i와 끝점인 i + (m -1)을 받아줌
            }
        }
        return cnt;
    }

    private static boolean isBeautiful(int st, int ed) {
        /// visited를 초기화해서 전부 다 false로 놓아주고

        for (int i = 0; i < b.length; i++) {
            checkBeuti(i, st, ed);
        }

        for (int i = st; i <= ed; i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }


    private static void visitedInit() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    private static void checkBeuti(int i, int st, int ed) {
        for (int j = st; j <= ed; j++) {
            if(!visited[j] && b[i] == a[j]) {
                visited[j] = true;// b[i]와 a[j]를 비교해줌
                break;				// 방문한적이 없으면서 b[i]==a[j]면
            }						// 그 구간은 방문했다고 true로 기록해주고
        }							// 비교를 멈춤
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        a = new int[n];
        b = new int[m];
//아름다운 수열은 a내에서 정해진 구간에서만 체크를 해야하기 때문에 a와 같은
//배열 길이를 가져야 함
        visited = new boolean[n];

        for (int i = 0; i < a.length; i++) {
            a[i] = input.nextInt();
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = input.nextInt();
        }
    }

}