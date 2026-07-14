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

    // initillay it is zero
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return diameter;
    }

    public int height(TreeNode root) {

       
        if (root == null) {
            return 0;
        }

       
        int left = height(root.left);
        int right = height(root.right);

        // Diameter- it is count of edges
        diameter = Math.max(diameter, left + right);

        // height- it is count of nodes
        return 1 + Math.max(left, right);
    }
}