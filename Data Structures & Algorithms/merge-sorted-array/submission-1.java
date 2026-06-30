class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Pointer to the last valid element in nums1
        int i = m - 1;

        // Pointer to the last element in nums2
        int j = n - 1;

        // Pointer to the last position in nums1 (including empty spaces)
        int k = m + n - 1;

        // Compare elements from the end and place the larger one at position k
        while (i >= 0 && j >= 0) {

            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // If any elements are left in nums2, copy them
        // (No need to copy remaining nums1 elements because
        // they are already in their correct positions.)
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}