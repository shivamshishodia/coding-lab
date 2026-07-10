// https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
// Time complexity: O(n)

public class reverseArray {

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        int arrLen = arr.length;
        for (int i = 0; i < arrLen; i++) {
            int temp = arr[i];
            arr[i] = arr[arrLen - 1];
            arr[arrLen - 1] = temp;
            arrLen--;
        }
        printArray(arr);
    }
    
}
