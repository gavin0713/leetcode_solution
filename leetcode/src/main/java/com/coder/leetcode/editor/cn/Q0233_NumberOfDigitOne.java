//Given an integer n, count the total number of digit 1 appearing in all non-
//negative integers less than or equal to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 13
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: n = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 10⁹ 
// 
// Related Topics 递归 数学 动态规划 👍 345 👎 0

package com.coder.leetcode.editor.cn;
public class Q0233_NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution = new Q0233_NumberOfDigitOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int countDigitOne(int n) {
            // 72
            int count = 0;
            for (long k = 1; k <= n; k *= 10) {
                long r = n / k, m = n % k;
                // sum up the count of ones on every place k
                count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
            }

            return count;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}