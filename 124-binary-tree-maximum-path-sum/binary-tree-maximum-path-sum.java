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

    int maxSum = Integer.MIN_VALUE;
    private int maxGain(TreeNode root) {

        if (root == null)
            return 0;

        // Maximum left and right  subtree
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        int currentPath = left + right + root.val;
        maxSum = Math.max(maxSum, currentPath);
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {

        maxGain(root);

        return maxSum;
    }
}