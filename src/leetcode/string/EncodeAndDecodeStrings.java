package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        Codec codec = new Codec();

        // Test cases
        List<String> input = List.of("Hello,World", "", "Java!");
        String encoded = codec.encode(input);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }

    static class Codec {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder encoded = new StringBuilder();
            for (String str : strs) {
                // Append length and content of each string
                encoded.append(str.length()).append("#").append(str);
            }
            return encoded.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> decoded = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                // Find the next '#' which separates the length
                int delimiterIndex = s.indexOf("#", i);
                int length = Integer.parseInt(s.substring(i, delimiterIndex));

                // Extract the actual string based on the length
                i = delimiterIndex + 1; // Move to the start of the string
                decoded.add(s.substring(i, i + length));
                i += length; // Move to the next encoded substring
            }
            return decoded;
        }
    }
}
