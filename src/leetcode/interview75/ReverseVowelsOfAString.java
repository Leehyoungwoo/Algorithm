package leetcode.interview75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverseVowels("IceCreAm"));
        System.out.println(solution.reverseVowels("leetcode"));
    }

    static class Solution {

        public String reverseVowels(String s) {
            StringBuilder answer = new StringBuilder();
            List<Character> vowels = new ArrayList<>();
            Set<Character> vowelsSet = new HashSet<>();
            vowelsSet.add('a'); vowelsSet.add('e'); vowelsSet.add('i'); vowelsSet.add('o'); vowelsSet.add('u');
            vowelsSet.add('A'); vowelsSet.add('E'); vowelsSet.add('I'); vowelsSet.add('O'); vowelsSet.add('U');

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    vowels.add(c);
                }
            }
            int vowelCount = 0;
            int vowelSize = vowels.size();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (vowelsSet.contains(c)) {
                    char reverseChar = vowels.get(
                            vowelSize - 1 - (vowelCount)
                    );
                    if (i == 0) {
                        answer.append(reverseChar);
                    } else {
                        answer.append(reverseChar);
                    }
                    vowelCount++;
                } else {
                    answer.append(c);
                }
            }

            return answer.toString();
        }
    }
}
