package algo.ch19;

import java.math.BigInteger;
import java.util.Random;

public final class RabinKarpSubstringSearch {
    private static final int R = 256;

    private final String pattern;
    private final int m;
    private final long q;
    private final long hash;
    private final long RM;

    public RabinKarpSubstringSearch(String pattern) {
        this.pattern = pattern;
        this.m = pattern.length();
        this.q = randomPrime();
        this.hash = computeHash(pattern, m);
        this.RM = computeRM();
    }

    private long computeRM() {
        long rm = 1;
        for (int i = 1; i < m; i++) {
            rm = (R * rm) % q;
        }
        return rm;
    }

    // Horner's method
    private long computeHash(String txt, int len) {
        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (R * hash + txt.charAt(i)) % q;
        }
        return hash;
    }

    private long randomPrime() {
        return BigInteger.probablePrime(31, new Random()).longValue();
    }

    public int findInText(String text) {
        int n = text.length();
        long txtHash = computeHash(text, m);
        if(txtHash == hash) {
            return 0;
        }

        for (int i = m; i < n; i++) {
            txtHash = (txtHash + q - RM * text.charAt(i-m) % q) % q;
            txtHash = (txtHash * R + text.charAt(i)) % q;
            // monte-carlo version: returning as soon as hash matches
            // las vegas version: check char match to avoid hash collision probability
            if(hash == txtHash) {
                return i - m + 1;
            }
        }

        return -1;
    }
}
