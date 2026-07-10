// https://leetcode.com/problems/shuffle-the-array/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffleNums = new int[n * 2];
        int numsCount = nums.length;
        int count = 0;
        for (int i = 0; i < numsCount / 2; i++) {
            shuffleNums[count++] = nums[i];
            shuffleNums[count++] = nums[i + n];
        }
        return shuffleNums;
    }
}