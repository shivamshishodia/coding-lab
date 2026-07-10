// https://leetcode.com/problems/running-sum-of-1d-array/

class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] runningSum = new int[n];
        for(int i = 0; i < n; i++) {
            if (i == 0) {
                runningSum[i] = nums[i];
                continue;
            }
            runningSum[i] = runningSum[i--] + nums[i];
        }
        return runningSum;
    }
}