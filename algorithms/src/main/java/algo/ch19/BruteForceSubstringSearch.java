package algo.ch19;

public final class BruteForceSubstringSearch {
    private final String text;

    public BruteForceSubstringSearch(String text) {
        this.text = text;
    }

    public int find(String pattern) {
        int m = pattern.length();
        int n = text.length();

        int pPos = 0, tPos = 0;
        int matchIndex = -1;
        // increment both pattern and text indices as long as we match.
        // reset the text pos to beginning of last non-matching sequence we had.
        while(tPos < n && pPos < m) {
            if(text.charAt(tPos) == pattern.charAt(pPos)) {
                if(matchIndex < 0) {
                    matchIndex = tPos;
                }
                pPos++;
                tPos++;
            } else {
                matchIndex = -1;
                tPos-=(pPos-1);
                pPos = 0;
            }
        }

        return matchIndex;
    }
}
