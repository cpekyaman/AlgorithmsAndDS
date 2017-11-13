package udemy.algo.strings;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringOps {
    public String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        for(int i = input.length() - 1; i >= 0; --i) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public List<String> suffixes(String input) {
        return IntStream.rangeClosed(1, input.length())
                .mapToObj(i -> input.substring(input.length() - i, input.length()))
                .collect(Collectors.toList());
    }

    private String longestCommonPrefix(String first, String second) {
        int length = Math.min(first.length(), second.length());
        for(int i = 0; i < length; ++i) {
            if(first.charAt(i) != second.charAt(i)) {
                return first.substring(0, i);
            }
        }
        return first.substring(0, length);
    }

    public String longestRepeatedSubstring(String text) {
        List<String> suffixes = suffixes(text);
        Collections.sort(suffixes);

        String longestPrefix = "";
        String temp;
        for(int i = 0; i < text.length() - 1; ++i) {
            temp = longestCommonPrefix(suffixes.get(i), suffixes.get(i + 1));
            if(temp.length() > longestPrefix.length()) {
                longestPrefix = temp;
            }
        }

        return longestPrefix;
    }
}
