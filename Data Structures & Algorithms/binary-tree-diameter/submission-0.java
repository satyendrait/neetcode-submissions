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
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        dia = Math.max(dia, l + r);
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return dia;
    }

    int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depth(root.left) + 1, depth(root.right) + 1);
    }
}
