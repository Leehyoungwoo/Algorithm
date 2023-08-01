package codetree.LinkedList;

import java.util.*;

public class IntegerCommand8 {

    private static int N;
    private static String[] orders;
    private static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        init();
        followOrder();
    }

    private static void followOrder() {
        for (int i = 0; i < orders.length; i++) {
            if(orders[i].contains(" ")) {
                firstStyleOrder(orders[i]);
                continue;
            }
            secondStyleOrder(orders[i]);
        }
    }

    private static void secondStyleOrder(String order) {
        if (order.equals("pop_front")) {
            System.out.println(list.pollFirst());
        }

        if (order.equals("pop_back")) {
            System.out.println(list.pollLast());
        }

        if (order.equals("size")) {
            System.out.println(list.size());
        }

        if (order.equals("empty")) {
            if(list.isEmpty()) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        if (order.equals("front")) {
            System.out.println(list.peekFirst());
        }

        if (order.equals("back")) {
            System.out.println(list.peekLast());
        }
    }

    private static void firstStyleOrder(String s) {
        String[] order = s.split(" ");

        if (order[0].equals("push_front")) {
            list.addFirst(Integer.parseInt(order[1]));
        }

        if (order[0].equals("push_back")) {
            list.addLast(Integer.parseInt(order[1]));
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        input.nextLine();
        orders = new String[N];

        for (int i = 0; i < N; i++) {
            orders[i] = input.nextLine();
        }
    }
}
