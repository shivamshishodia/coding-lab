// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int finalValue = 0;
        int opsNumber = operations.length;
        for (int i = 0; i < opsNumber; i++) {
            if (operations[i].charAt(1) == '+') {
                finalValue++;
                continue;
            }
            finalValue--;
        }
        return finalValue;
    }
}