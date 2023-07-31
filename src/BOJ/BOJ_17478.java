package BOJ;

import java.util.Scanner;

public class BOJ_17478 {

    private static int N;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        chatBot(N);
    }

    private static void chatBot(int depth) {
        StringBuilder underBar = new StringBuilder();
        if (depth == -1) {
            return;
        }

        for (int i = depth; i < N; i++) {
            underBar.append("____");
        }

        String text = "\"재귀함수가 뭔가요?\"\n" +
                "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
        String[] eachLine = text.split("\n");
        StringBuilder lastSentence = new StringBuilder();

        lastSentence.append(underBar).append("라고 답변하였지.");
        if (depth != 0) {
            for (String line : eachLine) {
                StringBuilder sb = new StringBuilder();
                System.out.print(sb.append(underBar).append(line) + "\n");
            }
        }
        if(depth == 0) {
            StringBuilder sb = new StringBuilder();
            System.out.print(sb.append(underBar).append("\"재귀함수가 뭔가요?\"\n"));
            sb = new StringBuilder();
            System.out.print(sb.append(underBar).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n"));
        }
        chatBot(depth - 1);
        System.out.println(lastSentence);
    }
}
