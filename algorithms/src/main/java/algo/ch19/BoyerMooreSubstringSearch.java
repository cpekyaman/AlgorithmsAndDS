package algo.ch19;

import java.util.Arrays;

public final class BoyerMooreSubstringSearch {
    private static final int R = 256;

    private final String pattern;
    private final int[] skipTable;
    private final int m;

    public BoyerMooreSubstringSearch(String pattern) {
        this.pattern = pattern;
        this.m = pattern.length();
        this.skipTable = new int[R];
        buildSkipTable();
    }

    private void buildSkipTable() {
        Arrays.fill(skipTable, -1);
        for (int j = 0; j < pattern.length(); j++) {
            skipTable[pattern.charAt(j)] = j;
        }
    }

    public int findInText(String text) {
        int n = text.length();
        int skip;
        for (int i = 0; i <= n-m; i+=skip) {
            skip = 0;
            for (int j = m-1; j >= 0 ; j--) {
                if(pattern.charAt(j) != text.charAt(i+j)) {
                    skip = Integer.max(1, j - skipTable[text.charAt(i+j)]);
                    break;
                }
            }
            if(skip == 0) {
                return i;
            }
        }
        return -1;
    }
}
