/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        int j = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp == null){
                if(q.isEmpty()){
                    return res;
                }
                j++;
                q.add(null);
                continue;

            }
            if(res.size() <= j){
                res.add(tmp.val);
            }
            else{
                res.set(j, tmp.val);
            }

            if(tmp.left != null){
                q.add(tmp.left);
            }

            if(tmp.right != null){
                q.add(tmp.right);
            }
        }
        return res;
        
    }
}
