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

    // function for Reverse Preorder Traversal
    // (Root -> Right -> Left)
    private void rightView(TreeNode root, int level, List<Integer> ans) {

        if (root == null)
            return;

      
        if (level == ans.size()) {
            ans.add(root.val);
        }

        // Visit Right and  Subtree first
        rightView(root.right, level + 1, ans);
        rightView(root.left, level + 1, ans);
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        // Start from root
        rightView(root, 0, ans);

        return ans;
    }
}