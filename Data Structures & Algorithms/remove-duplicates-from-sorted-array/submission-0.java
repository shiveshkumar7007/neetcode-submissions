class Solution {

    public int removeDuplicates(int[] nums) {

        // i points to the last unique element
        int i = 0;

        // j scans the array
        for (int j = 1; j < nums.length; j++) {

            // Found a new unique element
            if (nums[j] != nums[i]) {

                i++;

                // Place the unique element at next position
                nums[i] = nums[j];
            }
        }

        // Number of unique elements
        return i + 1;
    }
}