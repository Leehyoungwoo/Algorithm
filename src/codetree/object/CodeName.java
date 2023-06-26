package codetree.object;

import java.util.Scanner;

class SecretAgent {
    String codename;
    int score;

    public SecretAgent(String codename, int score) {
        this.codename = codename;
        this.score = score;
    }
}

public class CodeName {

    private static SecretAgent[] secretAgent;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        secretAgent = new SecretAgent[5];

        for (int i = 0; i < 5; i++) {
            String codename = input.next();
            int score = input.nextInt();
            secretAgent[i] = new SecretAgent(codename, score);
        }
        printLowAgent();
    }

    private static void printLowAgent() {
        SecretAgent lowAgent = findLowestAgent();
        System.out.println(lowAgent.codename + " " + lowAgent.score);
    }

    private static SecretAgent findLowestAgent() {
        SecretAgent lowAgent = new SecretAgent("Lee", 100);
        for(int i = 0; i < 5; i++) {
            if(secretAgent[i].score < lowAgent.score) {
                lowAgent = secretAgent[i];
            }
        }
        return lowAgent;
    }
}
