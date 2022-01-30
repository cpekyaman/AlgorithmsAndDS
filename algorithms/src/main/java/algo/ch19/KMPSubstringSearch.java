package algo.ch19;

// knuth-morris-pratt
public final class KMPSubstringSearch {
    private static final int R = 256;

    private final String pattern;
    private final int M;
    private final int[][] dfa;

    public KMPSubstringSearch(String pattern) {
        this.pattern = pattern;
        this.M = pattern.length();
        this.dfa = new int[R][M];
        buildDFA();
    }

    private void buildDFA() {
        dfa[pattern.charAt(0)][0] = 1;
        for(int x = 0, j = 1; j < M; j++) {
            // mismatch state
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][x];
            }
            // match state
            dfa[pattern.charAt(j)][j] = j + 1;

            // reset start
            x = dfa[pattern.charAt(j)][x];
        }
    }

    public int findInText(String text) {
        int i, j;
        for (i = 0, j = 0; i < text.length() && j < M; i++) {
            j = dfa[text.charAt(i)][j];
        }
        return j == M ? i - M : -1;
    }
}
