// https://leetcode.com/problems/richest-customer-wealth/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int customers = accounts.length;
        int maxWealth = Integer.MIN_VALUE;
        for (int i = 0; i < customers; i++) {
            int customerWealth = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                customerWealth += accounts[i][j];
            }
            if (customerWealth > maxWealth) {
                maxWealth = customerWealth;
            }
        }
        return maxWealth;
    }
}