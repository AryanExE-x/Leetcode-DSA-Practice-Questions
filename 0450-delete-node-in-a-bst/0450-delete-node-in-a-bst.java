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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key){ //go left
            root.left = deleteNode(root.left,key);
        }
        else if(root.val<key){ //go right
            root.right = deleteNode(root.right,key);
        }
        else{ //milgya

            //case -1: leaf node (0 child nodes)
            if(root.left==null && root.right==null)return null;

            //case -2: 1 child node
            if(root.left==null) return root.right;//right child node exists
            if(root.right==null) return root.left;//left child node exists

            //case -3: 2 child nodes
            //step1-> find pred and save it
            //step2-> delete pred from the lst
            //step3-> pred.left=root.left and pred.right=root.right;
            //step4-> return pred;
            TreeNode pred = root;
            pred=root.left;
            while(pred.right!=null) pred=pred.right;//this will store pred
            root.left = deleteNode(root.left,pred.val); //this will delete pred from the lst using recursion. CASE 1 AND CASE 2 since a pred can only have 0 child or 1 child that too on the left side only.
            pred.left=root.left;
            pred.right=root.right;
            return pred;
            
        }
        return root;
    }
}