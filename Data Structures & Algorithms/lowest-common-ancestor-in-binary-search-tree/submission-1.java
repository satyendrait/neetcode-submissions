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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pPath = new ArrayList();
        ArrayList<TreeNode> qPath = new ArrayList();
        path(root, p, pPath);
        path(root, q, qPath);
        TreeNode res = null;
        int size = Math.min(pPath.size(), qPath.size());
        for (int i = 0; i < size; i++) {
            if (pPath.get(i) == qPath.get(i)) {
                res = pPath.get(i);
                continue;
            } else {
                break;
            }
        }
        return res;
    }

    TreeNode path(TreeNode root, TreeNode node, List<TreeNode> path) {
        if (root == null || node == null)
            return null;
        path.add(root);
        if (root.val == node.val) {
            return root;
        }
        TreeNode found = path(root.left, node, path);
        if (found == null) {
            path.remove(root.left);
        } else {
            return found;
        }
        found = path(root.right, node, path);
        if (found == null) {
            path.remove(root.right);
        } else {
            return found;
        }
        return null;
    }
}
