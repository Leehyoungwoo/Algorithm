package codetree.object;

import java.util.Scanner;

class Bomb {

    String code;
    String color;
    int second;

    public Bomb(String code, String color, int second) {
        this.code = code;
        this.color = color;
        this.second = second;
    }
}


public class DisarmTheBomb {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bomb bomb = new Bomb(input.next(), input.next(), input.nextInt());

        System.out.println("code : " + bomb.code);
        System.out.println("color : " + bomb.color);
        System.out.println("second : " + bomb.second);
    }
}
