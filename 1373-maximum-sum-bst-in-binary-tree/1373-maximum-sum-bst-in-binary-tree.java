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
class Quad{
    int max;
    int min;
    int sum;
    boolean isBST;
    Quad(int max,int min, int sum, boolean isBST){
        this.max=max;
        this.min=min;
        this.sum=sum;
        this.isBST=isBST;
    }
}
class Solution {
    static int maxSum;
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        helper(root);
        return maxSum;

        
    }
    public Quad helper(TreeNode root){
        if(root==null) return new Quad(Integer.MIN_VALUE,Integer.MAX_VALUE,0,true);
        Quad lst = helper(root.left);
        Quad rst = helper(root.right);
        int maxVal = Math.max(root.val,Math.max(lst.max,rst.max));
        int minVal = Math.min(root.val,Math.min(lst.min,rst.min));
        int sum = root.val + lst.sum + rst.sum; //IMPORTANT
        boolean isBST = lst.isBST && rst.isBST && (lst.max<root.val) && (rst.min>root.val);

        if(isBST) maxSum = Math.max(sum,maxSum);
        return new Quad(maxVal,minVal,sum,isBST);
    }
}