package udemy.algo.compression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TODO: improve implementation to not use numbers for single chars
public class RunLengthEncoding {
    public String encode(String originalText) {
        StringBuilder encoded = new StringBuilder();

        for (int i = 0; i < originalText.length(); i++) {
            int runLength = 1;
            while(sameCharInSequence(originalText, i)) {
                runLength++;
                i++;
            }
            encoded.append(runLength).append(originalText.charAt(i));
        }

        return encoded.toString();
    }

    public String decode(String encodedText) {
        StringBuilder decoded = new StringBuilder();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(encodedText);

        while(matcher.find()) {
            int runLength = Integer.parseInt(matcher.group());
            matcher.find();
            while(runLength-- > 0) {
                decoded.append(matcher.group());
            }
        }

        return decoded.toString();
    }

    private boolean sameCharInSequence(String text, int i) {
        return i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1);
    }
}
