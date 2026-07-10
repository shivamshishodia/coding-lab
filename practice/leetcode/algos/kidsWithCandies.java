import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/submissions/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;
        
        List<Boolean> result = Arrays.asList(new Boolean[candies.length]);
        Collections.fill(result, Boolean.FALSE);
        
        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(candies[i], maxCandies);
        }
        
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                result.set(i, true);
            }
        }
        return result;
    }
};