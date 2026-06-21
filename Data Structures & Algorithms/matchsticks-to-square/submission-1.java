class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }

        int target = sum / 4;

        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        int[] sides = new int[4];
        return dfs(0, matchsticks, sides, target);
    }

    public boolean dfs(int idx, int[] matchsticks, int[] sides, int target) {

        // All matchsticks used
        if (idx == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }

        int stick = matchsticks[idx];

        // Try placing current stick on each side
        for (int i = 0; i < 4; i++) {

            // Skip if side exceeds target length
            if (sides[i] + stick > target) {
                continue;
            }

            // Choose
            sides[i] += stick;

            
            if (dfs(idx + 1, matchsticks, sides, target)) {
                return true;
            }

            sides[i] -= stick;

            // Pruning:
            // If this side was empty before placing the stick
            // and placing it here didn't work, trying other
            // empty sides is redundant.
            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}