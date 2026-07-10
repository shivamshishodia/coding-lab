// https://leetcode.com/problems/jewels-and-stones/submissions/

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int jewelCount = 0;
        
        Set<Character> jewelsBox = new HashSet<Character>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelsBox.add(jewels.charAt(i));
        }
        
        for (int j = 0; j < stones.length(); j++) {
            if (jewelsBox.contains(stones.charAt(j))) {
                jewelCount++;
            }
        }
        return jewelCount;
    }
}