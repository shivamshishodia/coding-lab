// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

class Solution {
    public int mostWordsFound(String[] sentences) {
        int mostWordCount = 0;
        for (String s : sentences) {
            int count = 1;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ' ') {
                    count++;
                }
            }
            mostWordCount = Math.max(mostWordCount, count);
        }
        return mostWordCount;
    }
}