//English description is not available for the problem. Please switch to 
//Chinese. 
// Related Topics 数组 哈希表 排序 👍 576 👎 0

package com.coder.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Q剑指_Offer_03_ShuZuZhongZhongFuDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new Q剑指_Offer_03_ShuZuZhongZhongFuDeShuZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return num;
                } else {
                    set.add(num);
                }
            }
            return 0;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}