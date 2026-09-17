/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // 1. Find the peak index
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1; 
            } else {
                right = mid; 
            }
        }
        int peak = left;
        
        // 2. Search left slope (Ascending)
        left = 0;
        right = peak;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);
            
            if (val == target) return mid;
            if (val < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // 3. Search right slope (Descending)
        left = peak + 1;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = mountainArr.get(mid);
            
            if (val == target) return mid;
            // Reversed logic because the right side strictly decreases
            if (val > target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        
        return -1;
    }
}