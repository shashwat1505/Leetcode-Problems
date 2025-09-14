import java.util.*;

class Solution {
    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) >= 0;
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (isVowel(Character.toLowerCase(c))) {
                sb.append('*');
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();
        for (String word : wordlist) {
            exactWords.add(word);

            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String dev = devowel(word);
            vowelInsensitive.putIfAbsent(dev, word);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exactWords.contains(q)) {
                ans[i] = q; 
            } else if (caseInsensitive.containsKey(q.toLowerCase())) {
                ans[i] = caseInsensitive.get(q.toLowerCase());
            } else if (vowelInsensitive.containsKey(devowel(q))) {
                ans[i] = vowelInsensitive.get(devowel(q));
            } else {
                ans[i] = "";
            }
        }

        return ans;
    }
}