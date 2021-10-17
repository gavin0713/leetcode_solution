//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6271 👎 0

package com.coder.leetcode.editor.cn;
public class Q0003_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Q0003_LongestSubstringWithoutRepeatingCharacters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] flags = new boolean[128];
        char[] chars = s.toCharArray();
        int max = 0;
        int start = 0;
        int end = 0;
        for (; end < chars.length; end++) {
            if(!flags[chars[end]]) {
                flags[chars[end]] = true;
            } else {
                max = Math.max(max, end - start);
                while(chars[start] !=chars[end]) {
                    flags[chars[start]] = false;
                    start++;
                }
                start++;
            }
        }
        max = Math.max(max, end - start);
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}