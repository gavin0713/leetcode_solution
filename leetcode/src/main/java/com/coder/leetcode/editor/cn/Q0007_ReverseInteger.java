//Given a signed 32-bit integer x, return x with its digits reversed. If 
//reversing x causes the value to go outside the signed 32-bit integer range [-2³¹, 2³¹ -
// 1], then return 0. 
//
// Assume the environment does not allow you to store 64-bit integers (signed 
//or unsigned). 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3155 👎 0

package com.coder.leetcode.editor.cn;
public class Q0007_ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new Q0007_ReverseInteger().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private String reverse(String s) {
            int len = s.length();
            StringBuffer result = new StringBuffer(len);
            for (int i = 0; i < len; i++) {
                result.append(s.charAt(len-1-i));
            }
            return result.toString();
        }

        public int reverse(int x) {
            if (x==Integer.MIN_VALUE) return 0;
            int k = 1;
            if (x < 0) {
                x = -x;
                k = -1;
            }
            String strx = Integer.toString(x);
            strx = reverse(strx);
            Long tmp = Long.valueOf(strx) * k;
            if (tmp>Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) {
                return 0;
            } else {
                return tmp.intValue();
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}