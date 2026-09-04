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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            m.put(inorder[i], i);
        }
        int[] idx = new int[1];

        return dfs(preorder, 0, preorder.length-1, idx, m);
    }

    private TreeNode dfs(int[] preorder, int l, int r, int[] idx, HashMap<Integer, Integer> m){
        if(l>r) return null;
        int root_val = preorder[idx[0]++];
        TreeNode root = new TreeNode(root_val);
        int mid = m.get(root_val);

        root.left = dfs(preorder, l, mid-1, idx, m);
        root.right = dfs(preorder, mid+1, r, idx, m);

        return root;

    }
}
