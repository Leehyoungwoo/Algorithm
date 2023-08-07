package swExpertAcademy.SSAFY_10기_서울10반;

import java.util.*;

public class D3_1228 {

    private static final int TEST_CASE = 10;
    private static int N;
    private static LinkedList<Integer> password = new LinkedList<>();

    private static String orders;
    private static int order;
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= TEST_CASE ; tc++) {
            init(input);
            order = Integer.parseInt(input.nextLine());
            orders = input.nextLine();
            followOrder();
            sb.append("#").append(tc).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(password.get(i)).append(" ");
            }
            sb.append("\n");
            password.clear();
        }

        System.out.println(sb);
    }

    private static void followOrder() {
        String[] o = orders.split("I ");
        List<Integer> li = new ArrayList<>();

        for (int i = 1; i < o.length; i++) {
            String[] o1 = o[i].split(" ");
            if (o.length < 2) {
                continue;
            }
            for (int j = 2; j < o1.length; j++) {
                li.add(Integer.parseInt(o1[j]));
            }
            password.addAll(Integer.parseInt(o1[0]), li);
            li.clear();
        }

    }

    private static void init(Scanner input)  {
        N = Integer.parseInt(input.nextLine());

        String[] s = input.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            password.add(Integer.parseInt(s[i]));
        }
    }
}
