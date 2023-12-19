    package codetree.intermediateMid.hashset;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.HashSet;
    import java.util.StringTokenizer;

    public class SymmetricDifference {

        private static int n;
        private static int m;
        private static HashSet<Integer> set1 = new HashSet<>();
        private static HashSet<Integer> set2 = new HashSet<>();

        public static void main(String[] args) throws IOException {
            init();
            findAnswer();
        }

        private static void init() throws IOException {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer tokenizer = new StringTokenizer(input.readLine());
            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(input.readLine());
            for (int i = 0; i < n; i++) {
                set1.add(Integer.parseInt(tokenizer.nextToken()));
            }
            tokenizer = new StringTokenizer(input.readLine());
            for (int i = 0; i < m; i++) {
                set2.add(Integer.parseInt(tokenizer.nextToken()));
            }
        }

        private static void findAnswer() {
            set1.addAll(set2);
            System.out.println(2 * set1.size() - n - m);
        }
    }
