//Given the root of a binary tree and an integer targetSum, return the number 
//of paths where the sum of the values along the path equals targetSum. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards (i.e., traveling only from parent nodes to child nodes). 
//
// 
// Example 1: 
//
// 
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
// 
//
// Example 2: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 1000]. 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1088 👎 0

package com.coder.leetcode.editor.cn;

import com.coder.leetcode.editor.cn.basic.TreeNode;

import java.util.Stack;

public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    private Stack<Long> stack = new Stack<>();
    private int targetSum;
    private int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root != null) {
            long cur = (stack.isEmpty() ? 0 : stack.peek()) + root.val;

            updateAns(stack, cur);
            stack.push(cur);
            dfs(root.left);
            dfs(root.right);
            stack.pop();
        }
    }

    private void updateAns(Stack<Long> stack, long cur) {
        for (Long s : stack) {
            if (cur - s == targetSum) {
                ans++;
            }
        }
    }


}


//leetcode submit region end(Prohibit modification and deletion)

}