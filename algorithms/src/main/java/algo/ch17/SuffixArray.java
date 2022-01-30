package algo.ch17;

import java.util.Arrays;

public final class SuffixArray {
    private final String data;

    public SuffixArray(String data) {
        this.data = data;
    }

    public String lrs() {
        String[] suffixArray = new String[data.length()];
        for (int i = 0; i < data.length(); i++) {
            suffixArray[i] = data.substring(i);
        }

        Arrays.sort(suffixArray);
        String lrs = "";
        for (int i = 0; i < suffixArray.length - 1; i++) {
            int len = longestCommonPrefix(suffixArray[i], suffixArray[i + 1]);
            if(len > lrs.length()) {
                lrs = suffixArray[i].substring(0, len);
            }
        }
        return lrs;
    }

    private int longestCommonPrefix(String left, String right) {
        int i = 0;
        int stopLen = Integer.min(left.length(), right.length());

        while(i < stopLen && left.charAt(i) == right.charAt(i)) {
            i++;
        }
        return i;
    }
}
