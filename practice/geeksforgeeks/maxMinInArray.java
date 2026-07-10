// https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/
// Time complexity: O(n) 

public class maxMinInArray {

    static class Pair {
        int min;
        int max;
    }

    static Pair findMaxMin(int arr[]) {
        Pair results = new Pair();
        if (arr.length == 1) {
            results.min = arr[0];
            results.max = arr[0];
            return results;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        results.min = min;
        results.max = max;
        return results;
    }

    public static void main(String[] args) {

        int arr[] = {2, 6, 3, 4, 1};
        Pair results = findMaxMin(arr);
        System.out.println(results.min + " - " + results.max);
    }
    
}
