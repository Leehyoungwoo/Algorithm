package swExpertAcademy.SSAFY_10기_서울10반;

import java.util.*;
public class D3_0731 {

        private static int T;
        private static String s;
        private static char[] right;

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            T = input.nextInt();

            for (int t = 0; t < T; t++) {
                s = input.next();
                right = new char[s.length()];
                fillc();
                int cnt = findMinFix();
                System.out.println("#" + (t+1) + " " + cnt);
            }
        }

        private static int findMinFix() {
            int cnt = 0;
            char[] ch = new char[s.length()];

            for (int i = 0; i < ch.length; i++) {
                ch[i] = '0';
            }


            for (int i = 0; i < right.length; i++) {
                if (ch[i] == right[i]) {
                    continue;
                }
                for (int j = i; j < right.length; j++) {
                    ch[j] = right[i];
                }
                cnt++;

                if (isFixed(ch)) {
                    break;
                }
            }

            return cnt;
        }

        private static boolean isFixed(char[] ch) {
            for (int i = 0; i < right.length; i++) {
                if(ch[i] != right[i]) {
                    return false;
                }
            }
            return true;
        }

        private static void fillc() {
            for (int i = 0; i < right.length; i++) {
                right[i] = s.charAt(i);
            }
        }

    }
