class Solution {
public:
    int maxFreqSum(string& s) {
        int freq[26] = {};
        for (char c : s) freq[c - 'a']++;

        int maxC = 0, maxV = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            if (string("aeiou").find('a' + i) != string::npos)
                maxV = max(maxV, freq[i]);
            else
                maxC = max(maxC, freq[i]);
        }
        return maxC + maxV;
    }
};
