class Solution {
    public int[] plusOne(int[] digits) {

        // Start from last digit
        for (int i = digits.length - 1; i >= 0; i--) {

            // No carry needed
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // 9 + 1 = 10
            digits[i] = 0;
        }

        // All digits were 9
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;

        return ans;
    }
}