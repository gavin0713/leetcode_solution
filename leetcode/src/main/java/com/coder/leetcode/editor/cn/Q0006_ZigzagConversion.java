//The string "PAYPALISHIRING" is written in a zigzag pattern on a given number 
//of rows like this: (you may want to display this pattern in a fixed font for 
//better legibility) 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R
// 
//
// And then read line by line: "PAHNAPLSIIGYIR" 
//
// Write the code that will take a string and make this conversion given a 
//number of rows: 
//
// 
//string convert(string s, int numRows);
// 
//
// 
// Example 1: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 3
//Output: "PAHNAPLSIIGYIR"
// 
//
// Example 2: 
//
// 
//Input: s = "PAYPALISHIRING", numRows = 4
//Output: "PINALSIGYAHRPI"
//Explanation:
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// Example 3: 
//
// 
//Input: s = "A", numRows = 1
//Output: "A"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of English letters (lower-case and upper-case), ',' and '.'. 
// 1 <= numRows <= 1000 
// 
// Related Topics 字符串 👍 1313 👎 0

package com.coder.leetcode.editor.cn;
public class Q0006_ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new Q0006_ZigzagConversion().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1) return s;
        int len = s.length();
        int singleLen = 2 * (numRows -1);
        StringBuffer buffer = new StringBuffer(len);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < len/singleLen + 1; j++) {
                int idx = j*singleLen;

                if (idx+i < len) {
                    buffer.append(s.charAt(idx+i));
                }


                if (i==0 || i == numRows-1) {

                } else {

                    if (idx+singleLen-i < len) {
                        buffer.append(s.charAt(idx+singleLen-i));
                    }


                }

            }
        }

        return buffer.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}