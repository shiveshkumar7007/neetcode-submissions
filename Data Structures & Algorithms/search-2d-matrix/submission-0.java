class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] <= target && matrix[i][c - 1] >= target) {
                for (int j = 0; j < c; j++) {
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}