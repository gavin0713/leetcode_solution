//You have n coins and you want to build a staircase with these coins. The 
//staircase consists of k rows where the iᵗʰ row has exactly i coins. The last row of 
//the staircase may be incomplete. 
//
// Given the integer n, return the number of complete rows of the staircase you 
//will build. 
//
// 
// Example 1: 
//
// 
//Input: n = 5
//Output: 2
//Explanation: Because the 3ʳᵈ row is incomplete, we return 2.
// 
//
// Example 2: 
//
// 
//Input: n = 8
//Output: 3
//Explanation: Because the 4ᵗʰ row is incomplete, we return 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 179 👎 0

package com.coder.leetcode.editor.cn;
public class Q0441_ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new Q0441_ArrangingCoins().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2l*n+0.25)-0.5);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}