//Given an array of integers arr, return true if the number of occurrences of 
//each value in the array is unique, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,2,2,1,1,3]
//Output: true
//Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two 
//values have the same number of occurrences. 
//
// Example 2: 
//
// 
//Input: arr = [1,2]
//Output: false
// 
//
// Example 3: 
//
// 
//Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 1000 
// -1000 <= arr[i] <= 1000 
// 
// Related Topics 数组 哈希表 👍 124 👎 0

package com.coder.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q1207_UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        Solution solution = new Q1207_UniqueNumberOfOccurrences().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : arr) {
                map.merge(a, 1, Integer::sum);
            }
            boolean[] flag = new boolean[arr.length + 1];
            for (int v : map.values()) {
                if (flag[v]) {
                    return false;
                }
                flag[v] = true;
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}