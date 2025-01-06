package leetcode.frequency;

import java.util.ArrayList;
import java.util.List;

public class ValidWordAbbreviation {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validWordAbbreviation("internationalization", "i12iz4n")); // true
        System.out.println(solution.validWordAbbreviation("apple", "a2e")); // false
    }

    static class Solution {

        public boolean validWordAbbreviation(String word, String abbr) {
            int wordIndex = 0;
            int abbrIndex = 0;

            while (wordIndex < word.length() && abbrIndex < abbr.length()) {
                char c = abbr.charAt(abbrIndex);

                if (Character.isLetter(c)) {
                    if (wordIndex >= word.length() || word.charAt(wordIndex) != c) {
                        return false;
                    }
                    wordIndex++;
                    abbrIndex++;
                } else {
                    if (c == '0') {
                        return false;
                    }

                    int num = 0;
                    while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                        num = num * 10 + (abbr.charAt(abbrIndex) - '0');
                        abbrIndex++;
                    }

                    wordIndex += num;
                }
            }

            return wordIndex == word.length() && abbrIndex == abbr.length();
        }
    }
}
