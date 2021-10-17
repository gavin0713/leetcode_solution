//Given an integer n, return true if it is a power of two. Otherwise, return 
//false. 
//
// An integer n is a power of two, if there exists an integer x such that n == 2
//ˣ. 
//
// 
// Example 1: 
//
// 
//Input: n = 1
//Output: true
//Explanation: 2⁰ = 1
// 
//
// Example 2: 
//
// 
//Input: n = 16
//Output: true
//Explanation: 2⁴ = 16
// 
//
// Example 3: 
//
// 
//Input: n = 3
//Output: false
// 
//
// Example 4: 
//
// 
//Input: n = 4
//Output: true
// 
//
// Example 5: 
//
// 
//Input: n = 5
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//Follow up: Could you solve it without loops/recursion? Related Topics 位运算 递归 数
//学 👍 415 👎 0

package com.coder.leetcode.editor.cn;
public class Q0231_PowerOfTwo {
    public static void main(String[] args) {
        Solution solution = new Q0231_PowerOfTwo().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n < 0) return false;
            return Integer.bitCount(n) == 1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}