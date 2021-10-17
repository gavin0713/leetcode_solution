//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics 字符串 动态规划 👍 4198 👎 0

package com.coder.leetcode.editor.cn;
public class Q0005_LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new Q0005_LongestPalindromicSubstring().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private String initStr(String s) {
            char starb = '\11';
            char sb = '\10';
            StringBuffer newstr = new StringBuffer(s.length()*2+3);
            newstr.append(starb);
            for (int i = 0; i < s.length(); i++) {
                newstr.append(sb);
                newstr.append(s.charAt(i));
            }
            newstr.append(sb);
            newstr.append('\01');
            return newstr.toString();
        }

        private String getResult(String s) {
            StringBuffer result = new StringBuffer(s.length()/2);
            for (int i = 0; i < s.length(); i++) {
                if (i%2==1) {
                    result.append(s.charAt(i));
                }
            }
            return  result.toString();
        }

        public String longestPalindrome(String s) {
            s = initStr(s);
            int maxLen = -1;

            String result = null;

            int[] p = new int[s.length()];

            int id = -1;
            int mx = 0;

            for (int i = 1; i < s.length()-1; i++) {
                if (i<mx) {
                    p[i] = Math.min(p[2*id-i], mx -i);
                } else {
                    p[i] = 1;
                }
                while (s.charAt(i-p[i])==s.charAt(i+p[i])) {
                    p[i]++;
                }

                if (mx < i + p[i]){
                    id = i;
                    mx = i + p[i];
                }


                if (maxLen < p[i] - 1) {
                    maxLen = p[i] - 1;

                    result = s.substring(i-(p[i]-1), i+(p[i]-1));
                }

            }

            return getResult(result);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}