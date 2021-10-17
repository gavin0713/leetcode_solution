//Roman numerals are represented by seven different symbols: I, V, X, L, C, D 
//and M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, 2 is written as II in Roman numeral, just two one's added 
//together. 12 is written as XII, which is simply X + II. The number 27 is written as 
//XXVII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. 
//However, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same 
//principle applies to the number nine, which is written as IX. There are six 
//instances where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given an integer, convert it to a roman numeral. 
//
// 
// Example 1: 
//
// 
//Input: num = 3
//Output: "III"
// 
//
// Example 2: 
//
// 
//Input: num = 4
//Output: "IV"
// 
//
// Example 3: 
//
// 
//Input: num = 9
//Output: "IX"
// 
//
// Example 4: 
//
// 
//Input: num = 58
//Output: "LVIII"
//Explanation: L = 50, V = 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: num = 1994
//Output: "MCMXCIV"
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics 哈希表 数学 字符串 👍 700 👎 0

package com.coder.leetcode.editor.cn;
public class Q0012_IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new Q0012_IntegerToRoman().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private int[] getNums(int num) {
            int[] nums = new int[4];
            for (int i = 0; i < nums.length; i++) {
                int target = num%10;
                num = num/10;
                nums[3-i] = target;
            }
            return nums;
        }
        public String intToRoman(int num) {
            int[] nums = getNums(num);
            String result = "";
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result += getRoman(nums[i], 3-i);
                }
            }
            return result;
        }

        private char[] getMaltiRoman(int count, char romanChar) {
            char[] result = new char[count];
            for (int i = 0; i < result.length; i++) {
                result[i] = romanChar;
            }
            return result;
        }

        private String getRomanString(int num, char[] romanChar) {

            StringBuilder stringBuilder = new StringBuilder();
            // 1,2,3
            if (num < 4) {
                stringBuilder.append(getMaltiRoman(num, romanChar[0]));
            } else if (num == 4) {
                // 4
                stringBuilder.append(romanChar[0]);
                stringBuilder.append(romanChar[1]);
            } else if (num < 9) {
                //5,6,7,8
                stringBuilder.append(romanChar[1]);
                stringBuilder.append(getMaltiRoman(num-5, romanChar[0]));
            } else if (num == 9) {
                // 9
                stringBuilder.append(romanChar[0]);
                stringBuilder.append(romanChar[2]);
            }
            return stringBuilder.toString();
        }

        private String getRoman(int num, int i) {
            char[][] romanChar = {{'I', 'V', 'X'}, {'X', 'L', 'C'}, {'C', 'D', 'M'}, {'M'}};
            return getRomanString(num, romanChar[i]);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}