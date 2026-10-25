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
    public TreeNode convertBST(TreeNode root) {
        ArrayList<TreeNode> arr = new ArrayList<>();
        inorder(root,arr); //1 2 3 4 5
        Collections.reverse(arr); //5 4 3 2 1
        int sum=0;
        for(int i=0;i<arr.size();i++){
            int val = arr.get(i).val; //stores val of element
            arr.get(i).val=sum+val; //re-assign value with sum of previous+original value
            sum+=val;
        }
        return root;// 15 10 6 3 1
    }
    public void inorder(TreeNode root,ArrayList<TreeNode> arr){
        if(root==null) return;
        inorder(root.left,arr);
        arr.add(root);
        inorder(root.right,arr);
    }
}