//Given a string containing digits from 2-9 inclusive, return all possible 
//letter combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digit to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics 哈希表 字符串 回溯 👍 1551 👎 0

package com.coder.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0017_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new Q0017_LetterCombinationsOfAPhoneNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        String[] map = new String[]
                {"",     "abc", "def",
                        "ghi",  "jkl", "mno",
                        "pqrs", "tuv", "wxyz"};
        List<String> ans;

        public List<String> letterCombinations(String digits) {
            ans = new ArrayList<>();
            if (digits.length() == 0) return ans;
            dfs(digits, "", 0);
            return ans;
        }

        private void dfs(String digits, String comb, int idx) {
            if (idx == digits.length()) {
                ans.add(comb);
            } else {
                int num = digits.charAt(idx) - '1';
                for (int i = 0; i < map[num].length(); i++) {
                    dfs(digits, comb + map[num].charAt(i), idx + 1);
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}