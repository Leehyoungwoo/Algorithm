package forkakao.blindrecrument2022;

public class K진수에서_소수_개수_구하기 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int answer = solution.solution(797161, 3);
        System.out.println(answer);
    }
}

class Solution2 {
    public int solution(int n, int k) {
        int answer = 0;
        String oddNum = Integer.toString(n, k);
        if (oddNum.length() <= 2) {
            if (isOddNum(Integer.parseInt(oddNum))) {
                answer = 1;
            } else {
                answer = 0;
            }
        }
        int startIdx = 0;
        int endIdx = 0;
        while (startIdx < oddNum.length() || endIdx < oddNum.length()) {
            if (endIdx == oddNum.length()) {
                long num = Long.parseLong(oddNum.substring(startIdx));
                if (isOddNum(num)) {
                    answer++;
                }
                break;
            }
            if (oddNum.charAt(endIdx) != '0') {
                endIdx++;
                continue;
            }
            if (startIdx == endIdx) {
                startIdx = ++endIdx;
                continue;
            }
            long num = Long.parseLong(oddNum.substring(startIdx, endIdx));
            if (isOddNum(num)) {
                answer++;
            }
            startIdx = ++endIdx;
        }
        return answer;
    }

    private boolean isOddNum(long num) {
        if (num == 1) {
            return false;
        }
        if(num == 2) {
            return true;
        }

        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}