// https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
// Time complexity: O(n)

public class reverseArrayRecursion {

    static void reverseRecursion(int arr[], int start, int end) {
        if (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            reverseRecursion(arr, start + 1, end - 1);
        }
        return;
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        reverseRecursion(arr, 0, arr.length - 1);
        printArray(arr);
    }
    
}
