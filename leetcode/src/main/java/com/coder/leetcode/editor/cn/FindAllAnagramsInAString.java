//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 622 👎 0

package com.coder.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();

        solution.findAnagrams("baa", "aa");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] flag = new int[26];
        int fcharNum = 0;
        int scharNum = 0;
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;
        for (char ch : p.toCharArray()) {
            addChar(ch);
        }
        for (int i = 0; i < p.length(); i++) {
            removeChar(s.charAt(i));
        }

        for (int l = 0, r = p.length(); r <= s.length();l++, r++) {
            if (fcharNum == 0 && scharNum == 0) {
                ans.add(l);
            }
            if (r < s.length()) {
                removeChar(s.charAt(r));
                addChar(s.charAt(l));
            }

        }
        return ans;
    }

    private void addChar(char ch) {
        int idx = ch - 'a';
        if (flag[idx] >= 0) {
            fcharNum++;
        } else {
            scharNum++;
        }
        flag[idx]++;
    }

    private void removeChar(char ch) {
        int idx = ch - 'a';
        if (flag[idx] > 0) {
            fcharNum--;
        } else {
            scharNum--;
        }
        flag[idx]--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}