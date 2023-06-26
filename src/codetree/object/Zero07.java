package codetree.object;

import java.util.Scanner;

class Agent {
    String code;
    String place;
    String time;

    public Agent(String code, String place, String time) {
        this.code = code;
        this.place = place;
        this.time = time;
    }
}

public class Zero07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Agent agent = new Agent(input.next(), input.next(), input.next());

        System.out.println("secret code : " + agent.code);
        System.out.println("meeting point : " + agent.place);
        System.out.println("time : " + agent.time);
    }
}
