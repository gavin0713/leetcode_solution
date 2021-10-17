//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 位运算 数组 回溯 👍 5 👎 0

package com.coder.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q剑指_Offer_II_079_TVdhkn {
    public static void main(String[] args) {
        Solution solution = new Q剑指_Offer_II_079_TVdhkn().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> rst = new ArrayList<>();
            for (int i = 0; i < (1 << nums.length); i++) {
                rst.add(getSubset(nums, i));
            }
            return rst;
        }

        private List<Integer> getSubset(int[] nums, int n) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0, mark = 1; i < nums.length; i++, mark <<= 1) {
                if ((n & mark) > 0) {
                    ans.add(nums[i]);
                }
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}