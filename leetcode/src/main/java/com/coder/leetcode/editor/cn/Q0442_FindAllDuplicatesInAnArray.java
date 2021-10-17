//Given an integer array nums of length n where all the integers of nums are in 
//the range [1, n] and each integer appears once or twice, return an array of all 
//the integers that appears twice. 
//
// You must write an algorithm that runs in O(n) time and uses only constant 
//extra space. 
//
// 
// Example 1: 
// Input: nums = [4,3,2,7,8,2,3,1]
//Output: [2,3]
// Example 2: 
// Input: nums = [1,1,2]
//Output: [1]
// Example 3: 
// Input: nums = [1]
//Output: []
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// Each element in nums appears once or twice. 
// 
// Related Topics 数组 哈希表 👍 441 👎 0

package com.coder.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0442_FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        Solution solution = new Q0442_FindAllDuplicatesInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] flag = new int[nums.length + 1];
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (++flag[num] == 2) {
                ans.add(num);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}