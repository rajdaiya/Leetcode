/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
public boolean isSymmetric(TreeNode root) {
    if(root==null) return true;
    return isSymmetric(root.left, root.right);
}
private boolean isSymmetric(TreeNode root1, TreeNode root2) {
    if(root1==null && root2==null) return true;
    if(root1==null || root2==null) return false;
    if(root1.val!=root2.val) return false;
    return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
}
}