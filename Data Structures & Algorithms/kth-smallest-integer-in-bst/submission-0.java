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
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = new int[2];
        inorder(root, k, ans);
        return ans[1];
    }

    private void inorder(TreeNode root, int k,int[] ans){
        if(root == null) return;

        inorder(root.left, k, ans);
        ans[0]++;
        if(ans[0] == k) ans[1] = root.val;

        inorder(root.right, k, ans);
        
        }
}
