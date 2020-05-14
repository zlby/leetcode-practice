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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        viewLevel(root, res, 0);
        return res;
    }
    
    public void viewLevel(TreeNode curr, ArrayList<Integer> res, int currLevel) {
        if (curr == null) {
            return;
        }
        if (currLevel == res.size()) {
            res.add(curr.val);
        }
        viewLevel(curr.right, res, currLevel+1);
        viewLevel(curr.left, res, currLevel+1);
    }
}
