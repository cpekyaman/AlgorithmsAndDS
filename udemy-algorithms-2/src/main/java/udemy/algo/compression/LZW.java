package udemy.algo.compression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZW {
    public List<Integer> compress(String text) {
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            dict.put("" + (char) i, i);
        }

        List<Integer> result = new ArrayList<>();
        String lastCheckedString = "";
        for(char c : text.toCharArray()) {
            String currentString = lastCheckedString + c;
            if(dict.containsKey(currentString)) {
                lastCheckedString = currentString;
            } else {
                result.add(dict.get(lastCheckedString));
                dict.put(currentString, dict.size() + 1);
                System.out.printf("Inserted %s into dictionary\n", currentString);
                lastCheckedString = "" + c;
            }
        }

        if(! lastCheckedString.isEmpty()) {
            result.add(dict.get(lastCheckedString));
        }
        return result;
    }
}
