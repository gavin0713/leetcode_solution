//Given an integer array nums, return the number of all the arithmetic 
//subsequences of nums. 
//
// A sequence of numbers is called arithmetic if it consists of at least three 
//elements and if the difference between any two consecutive elements is the same. 
//
//
// 
// For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are 
//arithmetic sequences. 
// For example, [1, 1, 2, 5, 7] is not an arithmetic sequence. 
// 
//
// A subsequence of an array is a sequence that can be formed by removing some 
//elements (possibly none) of the array. 
//
// 
// For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10]. 
// 
//
// The test cases are generated so that the answer fits in 32-bit integer. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,4,6,8,10]
//Output: 7
//Explanation: All arithmetic subsequence slices are:
//[2,4,6]
//[4,6,8]
//[6,8,10]
//[2,4,6,8]
//[4,6,8,10]
//[2,4,6,8,10]
//[2,6,10]
// 
//
// Example 2: 
//
// 
//Input: nums = [7,7,7,7,7]
//Output: 16
//Explanation: Any subsequence of this array is arithmetic.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
// Related Topics 数组 动态规划 👍 228 👎 0

package com.coder.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q0446_ArithmeticSlicesIiSubsequence {
    public static void main(String[] args) {
        Solution solution = new Q0446_ArithmeticSlicesIiSubsequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        Map<Long, Integer>[] maps = new HashMap[nums.length];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<>();
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long diff = (long) nums[j] - nums[i];
                maps[j].merge(diff, maps[i].getOrDefault(diff, 0) + 1, Integer::sum);
            }
        }

        int ans = 0;
        for (Map<Long, Integer> map : maps) {
            ans += map.values().stream().mapToInt(x -> x).sum();
        }
        return ans - nums.length * (nums.length-1) /2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}