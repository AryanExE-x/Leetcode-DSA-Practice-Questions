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

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        dfs(root, arr, ans);

        return ans;
    }

    public void dfs(TreeNode root, ArrayList<Integer> arr,
                    List<String> ans) {

        if(root == null)
            return;

        arr.add(root.val);

        if(root.left == null && root.right == null) {

            String path = "";

            for(int i = 0; i < arr.size(); i++) {

                path += arr.get(i);

                if(i != arr.size() - 1)
                    path += "->";
            }

            ans.add(path);

            arr.remove(arr.size() - 1);
            return;
        }

        dfs(root.left, arr, ans);
        dfs(root.right, arr, ans);

        // backtracking
        arr.remove(arr.size() - 1);
    }
}