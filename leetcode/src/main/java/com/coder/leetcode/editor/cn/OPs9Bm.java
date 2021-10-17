//👍 3 👎 0

package com.coder.leetcode.editor.cn;
public class OPs9Bm {
    public static void main(String[] args) {
        Solution solution = new OPs9Bm().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int securityCheck(int[] capacities, int k) {
            int M = 1000000007;
            int[] dp = new int[k+1];
            for (int capacity : capacities) {
                capacity--;
                for (int i = k; i >= capacity; i--) {
                    dp[i] = (dp[i] + dp[i - capacity]) % M;

                }
                dp[capacity]++;
            }
            dp[0] *=2;
            return dp[k] % M;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}