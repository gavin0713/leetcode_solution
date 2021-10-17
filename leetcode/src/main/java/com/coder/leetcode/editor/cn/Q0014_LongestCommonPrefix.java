//Write a function to find the longest common prefix string amongst an array of 
//strings. 
//
// If there is no common prefix, return an empty string "". 
//
// 
// Example 1: 
//
// 
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
// 
//
// Example 2: 
//
// 
//Input: strs = ["dog","racecar","car"]
//Output: ""
//Explanation: There is no common prefix among the input strings.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] consists of only lower-case English letters. 
// 
// Related Topics 字符串 👍 1817 👎 0

package com.coder.leetcode.editor.cn;
public class Q0014_LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new Q0014_LongestCommonPrefix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int end = 0;
        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        abc: for (int i = 0; i < minLength ; i++) {
            for (int n = 1; n < strs.length; n++) {
                if (strs[n].charAt(i) != strs[0].charAt(i)) {
                    end = i;
                    break abc;
                }
            }
            end = i + 1;
        }
        return strs[0].substring(0, end);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}