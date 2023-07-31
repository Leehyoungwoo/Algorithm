    package codetree.ArrayAndArrayList;

    import java.util.*;

    public class IntegerCommandProcessing {

        private static int N;
        private static ArrayList<Integer> list = new ArrayList<>();

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            N = input.nextInt();

            for (int i = 0; i < N; i++) {
                String order = input.next();
                int n = Integer.parseInt(input.next());
                doOrder(order, n);
            }
        }

        private static void doOrder(String order, int n) {
            if(order.equals("push_back")) {
                list.add(n);
            }

            if(order.equals("pop_back")) {
                System.out.print(list.get(list.size() - 1));
                list.remove(list.size() - 1);
            }

            if(order.equals("size")) {
                System.out.print(list.size());
            }

            if(order.equals("get")) {
                System.out.print(list.get(n-1));
            }
        }
    }
