class Solution {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        dfs(root, 0, res);

        return res;
    }

    public void dfs(TreeNode root, int level, List<Integer> res){

        if(root == null){
            return;
        }

        if(level == res.size()){
            res.add(root.val);
        }

        dfs(root.right, level + 1, res);
        dfs(root.left, level + 1, res);
    }
}