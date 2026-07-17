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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Final answer
        List<List<Integer>> ans = new ArrayList<>();

        // If tree is empty, return empty list
        if (root == null) {
            return ans;
        }

        // Queue Level Order(FIFO)
        Queue<TreeNode> queue = new LinkedList<>();

        //start with root node
        queue.offer(root);
        // true  -> L to R
        // false -> R to L
        boolean leftToRight = true;

        
        while (!queue.isEmpty()) {
            int size = queue.size();

              // addFirst() R to L
            // addLast()  -> L to R ( normal)
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                // Remove one node from the queue
                TreeNode node = queue.poll();
                if (leftToRight) {
                    level.addLast(node.val);
                }
                else {
                    level.addFirst(node.val);
                }

                // Add left child and right
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Current level is complete
            ans.add(level);

            // Change direction for the next level
            leftToRight = !leftToRight;
        }
        return ans;
    }
}