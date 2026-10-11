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
    public void flatten(TreeNode root) {
        
        if(root==null) return;
        TreeNode lst = root.left;
        TreeNode rst = root.right;
        //detached
        root.left=null;
        root.right=null; 
        flatten(lst);
        flatten(rst);
        root.right=lst; //root ke right mein lst ko attach kro
        TreeNode lstLastEl = root; //ye lst ka last element hoga after flattened out
        while(lstLastEl.right!=null) lstLastEl=lstLastEl.right;
        lstLastEl.right=rst;
    }
    
}