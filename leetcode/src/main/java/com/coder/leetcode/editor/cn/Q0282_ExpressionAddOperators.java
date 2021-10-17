//Given a string num that contains only digits and an integer target, return 
//all possibilities to insert the binary operators '+', '-', and/or '*' between the 
//digits of num so that the resultant expression evaluates to the target value. 
//
// Note that operands in the returned expressions should not contain leading 
//zeros. 
//
// 
// Example 1: 
//
// 
//Input: num = "123", target = 6
//Output: ["1*2*3","1+2+3"]
//Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
// 
//
// Example 2: 
//
// 
//Input: num = "232", target = 8
//Output: ["2*3+2","2+3*2"]
//Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
// 
//
// Example 3: 
//
// 
//Input: num = "105", target = 5
//Output: ["1*0+5","10-5"]
//Explanation: Both "1*0+5" and "10-5" evaluate to 5.
//Note that "1-05" is not a valid expression because the 5 has a leading zero.
// 
//
// Example 4: 
//
// 
//Input: num = "00", target = 0
//Output: ["0*0","0+0","0-0"]
//Explanation: "0*0", "0+0", and "0-0" all evaluate to 0.
//Note that "00" is not a valid expression because the 0 has a leading zero.
// 
//
// Example 5: 
//
// 
//Input: num = "3456237490", target = 9191
//Output: []
//Explanation: There are no expressions that can be created from "3456237490" 
//to evaluate to 9191.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num.length <= 10 
// num consists of only digits. 
// -2³¹ <= target <= 2³¹ - 1 
// 
// Related Topics 数学 字符串 回溯 👍 317 👎 0

package com.coder.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0282_ExpressionAddOperators {
    public static void main(String[] args) {
        Solution solution = new Q0282_ExpressionAddOperators().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> rst = new ArrayList<String>();
            if (num == null || num.length() == 0) return rst;
            helper(rst, "", num, target, 0, 0, 0);
            return rst;
        }

        public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
            if (pos == num.length()) {
                if (target == eval)
                    rst.add(path);
                return;
            }
            for (int i = pos; i < num.length(); i++) {
                if (i != pos && num.charAt(pos) == '0') break;
                long cur = Long.parseLong(num.substring(pos, i + 1));
                if (pos == 0) {
                    helper(rst, path + cur, num, target, i + 1, cur, cur);
                } else {
                    helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

                    helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

                    helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
                }
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}