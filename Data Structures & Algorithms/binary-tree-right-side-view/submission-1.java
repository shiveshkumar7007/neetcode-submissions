class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        boolean first = true;

        while(!q.isEmpty()){

            TreeNode tmp = q.poll();

            if(tmp == null){

                if(q.isEmpty()){
                    return res;
                }

                first = true;
                q.add(null);
                continue;
            }

            if(first){
                res.add(tmp.val);
                first = false;
            }

            if(tmp.right != null){
                q.add(tmp.right);
            }

            if(tmp.left != null){
                q.add(tmp.left);
            }
        }

        return res;
    }
}