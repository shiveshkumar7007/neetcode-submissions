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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp == null){
                ans.add(list);

                if(q.isEmpty()){
                    return ans;
                }
                
                list = new ArrayList<>();
                q.add(null);
                continue;
            }
            list.add(tmp.val);

            if(tmp.left != null){
                q.add(tmp.left);
            }

            if(tmp.right != null){
                q.add(tmp.right);
            }
        }
        return ans;
        
    }
}
