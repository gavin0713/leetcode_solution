//Given the root of a binary search tree, and an integer k, return the kᵗʰ 
//smallest value (1-indexed) of all the values of the nodes in the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= k <= n <= 10⁴ 
// 0 <= Node.val <= 10⁴ 
// 
//
// 
// Follow up: If the BST is modified often (i.e., we can do insert and delete 
//operations) and you need to find the kth smallest frequently, how would you 
//optimize? 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 480 👎 0

package com.coder.leetcode.editor.cn;

import com.coder.leetcode.editor.cn.basic.TreeNode;

public class Q0230_KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new Q0230_KthSmallestElementInABst().new Solution();
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

        private int idx = 0;
        private int ans;
        private int k;
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            mid(root);
            return ans;
        }

        void mid(TreeNode root) {
            if (root != null) {
                mid(root.left);
                if (++idx == k) {
                    ans = root.val;
                    return;
                }
                mid(root.right);
            }
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}