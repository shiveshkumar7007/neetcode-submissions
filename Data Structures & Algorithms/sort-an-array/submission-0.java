public class Solution {
    public int[] sortArray(int[] nums) {
        // Start merge sort on the entire array
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] arr, int l, int r) {

        // Base case: single element is already sorted
        if (l >= r) return;

        int m = (l + r) / 2;

        // Sort left half
        mergeSort(arr, l, m);

        // Sort right half
        mergeSort(arr, m + 1, r);

        // Merge the two sorted halves
        merge(arr, l, m, r);
    }

    public void merge(int[] arr, int l, int m, int r) {

        // Temporary list to store merged elements
        ArrayList<Integer> temp = new ArrayList<>();

        // Pointer for left half
        int i = l;

        // Pointer for right half
        int j = m + 1;

        // Compare elements from both halves
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }

        // Copy remaining elements from left half
        while (i <= m) {
            temp.add(arr[i]);
            i++;
        }

        // Copy remaining elements from right half
        while (j <= r) {
            temp.add(arr[j]);
            j++;
        }

        // Copy merged elements back into original array
        for (i = l; i <= r; i++) {
            arr[i] = temp.get(i - l);
        }
    }
}