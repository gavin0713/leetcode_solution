//Given a string expression of numbers and operators, return all possible 
//results from computing all the different possible ways to group numbers and operators.
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: expression = "2-1-1"
//Output: [0,2]
//Explanation:
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// Example 2: 
//
// 
//Input: expression = "2*3-4*5"
//Output: [-34,-14,-10,-10,10]
//Explanation:
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
// Constraints: 
//
// 
// 1 <= expression.length <= 20 
// expression consists of digits and the operator '+', '-', and '*'. 
// All the integer values in the input expression are in the range [0, 99]. 
// 
// Related Topics 递归 记忆化搜索 数学 字符串 动态规划 👍 446 👎 0

package com.coder.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q0241_DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        Solution solution = new Q0241_DifferentWaysToAddParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            return diffWaysToCompute(expression.toCharArray(), 0, expression.length() - 1);
        }

        public List<Integer> diffWaysToCompute(char[] expr, int lo, int hi) {
            List<Integer> ans = new ArrayList<>();
            int value = 0;
            for (int i = lo; i <= hi; i++) {
                if (expr[i]== '+' || expr[i]== '-' || expr[i]== '*' ) {
                    List<Integer> l = diffWaysToCompute(expr, lo, i - 1);
                    List<Integer> r = diffWaysToCompute(expr, i + 1, hi);
                    for (Integer ll : l) {
                        for (Integer rr : r) {
                            if (expr[i] == '+') {
                                ans.add(ll + rr);
                            } else if (expr[i] == '-') {
                                ans.add(ll - rr);
                            } else if (expr[i] == '*') {
                                ans.add(ll * rr);
                            }
                        }
                    }
                } else {
                    value *= 10;
                    value += expr[i] - '0';
                }
            }
            if (ans.isEmpty()) ans.add(value);
            return ans;

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}