//Given an array nums of n integers where nums[i] is in the range [1, n], 
//return an array of all the integers in the range [1, n] that do not appear in nums. 
//
// 
// Example 1: 
// Input: nums = [4,3,2,7,8,2,3,1]
//Output: [5,6]
// Example 2: 
// Input: nums = [1,1]
//Output: [2]
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 
// Follow up: Could you do it without extra space and in O(n) runtime? You may 
//assume the returned list does not count as extra space. 
// Related Topics 数组 哈希表 👍 837 👎 0

package com.coder.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0448_FindAllNumbersDisappearedInAnArray {
    public static void main(String[] args) {
        Solution solution = new Q0448_FindAllNumbersDisappearedInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] flag = new boolean[n+1];
        for(int num:nums) {
            flag[num] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if (!flag[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}