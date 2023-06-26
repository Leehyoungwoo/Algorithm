package codetree.object;

import  java.util.Scanner;

class User {
    String id;
    int level;

    public User(String id, int level) {
        this.id = id;
        this.level = level;
    }
}

public class NextLevel {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        User userA = new User("codetree", 10);
        User userB = new User(input.next(), input.nextInt());

        System.out.println("user " + userA.id + " " +"lv " + userA.level);
        System.out.println("user " + userB.id + " " +"lv " + userB.level);
    }
}
