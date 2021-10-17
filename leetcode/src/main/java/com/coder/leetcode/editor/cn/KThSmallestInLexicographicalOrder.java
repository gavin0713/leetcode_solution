//Given two integers n and k, return the kᵗʰ lexicographically smallest integer 
//in the range [1, n]. 
//
// 
// Example 1: 
//
// 
//Input: n = 13, k = 2
//Output: 10
//Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7
//, 8, 9], so the second smallest number is 10.
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
// Related Topics 字典树 👍 238 👎 0

package com.coder.leetcode.editor.cn;
public class KThSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        Solution solution = new KThSmallestInLexicographicalOrder().new Solution();

        solution.findKthNumber(10, 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findKthNumber(int n, int k) {
            long prefix = 1;
            int idx = 1;
            while (idx < k) {
                long count = getNumCount(prefix, n);
                if (idx + count > k) {
                    prefix *= 10;
                    idx ++;
                } else {
                    prefix++;
                    idx += count;
                }
            }
            return (int) prefix;
        }
        private long getNumCount(long prefix, int n) {
            long count = 0;
            for (long cur = prefix, next = prefix+1; cur <= n; cur *= 10, next*=10) {
                count += Math.min(next, n+1) -cur;
            }
            return count;
        }
}


//leetcode submit region end(Prohibit modification and deletion)

}