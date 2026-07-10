// https://leetcode.com/problems/number-of-good-pairs/

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int goodPairCount = 0;
        int numCount = nums.length;
        for (int i = 0; i < numCount - 1; i++) {
            for (int j = i + 1; j < numCount; j++) {
                if (nums[i] == nums[j])
                    goodPairCount++;
            }
        }
        return goodPairCount;
    }
}