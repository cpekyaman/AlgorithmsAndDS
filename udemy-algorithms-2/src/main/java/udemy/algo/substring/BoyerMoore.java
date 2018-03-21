package udemy.algo.substring;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
    private final Map<Character, Integer> badMatchTable;

    public BoyerMoore() {
        this.badMatchTable = new HashMap<>();
    }

    public int search(String text, String pattern) {
        buildBadMatchTable(pattern);

        int shifts;
        for(int i = 0; i <= text.length() - pattern.length(); i += shifts) {
            shifts = 0;
            for(int j = pattern.length() - 1; j >= 0; --j) {
                char textChar = text.charAt(i + j);
                if(textChar != pattern.charAt(j)) {
                    if(badMatchTable.containsKey(textChar)) {
                        shifts = badMatchTable.get(textChar);
                    } else {
                        shifts = pattern.length();
                    }
                    break;
                }
            }
            if(shifts == 0) {
                return i;
            }
        }

        return -1;
    }

    private void buildBadMatchTable(String pattern) {
        for(int i = 0; i < pattern.length(); ++i) {
            Character c = pattern.charAt(i);
            int shift = Math.max(1, pattern.length() - i - 1);
            badMatchTable.put(c, shift);
        }
    }
}
