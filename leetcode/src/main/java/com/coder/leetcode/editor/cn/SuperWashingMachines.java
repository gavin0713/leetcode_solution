//You have n super washing machines on a line. Initially, each washing machine 
//has some dresses or is empty. 
//
// For each move, you could choose any m (1 <= m <= n) washing machines, and 
//pass one dress of each washing machine to one of its adjacent washing machines at 
//the same time. 
//
// Given an integer array machines representing the number of dresses in each 
//washing machine from left to right on the line, return the minimum number of 
//moves to make all the washing machines have the same number of dresses. If it is not 
//possible to do it, return -1. 
//
// 
// Example 1: 
//
// 
//Input: machines = [1,0,5]
//Output: 3
//Explanation:
//1st move:    1     0 <-- 5    =>    1     1     4
//2nd move:    1 <-- 1 <-- 4    =>    2     1     3
//3rd move:    2     1 <-- 3    =>    2     2     2
// 
//
// Example 2: 
//
// 
//Input: machines = [0,3,0]
//Output: 2
//Explanation:
//1st move:    0 <-- 3     0    =>    1     2     0
//2nd move:    1     2 --> 0    =>    1     1     1
// 
//
// Example 3: 
//
// 
//Input: machines = [0,2,0]
//Output: -1
//Explanation:
//It's impossible to make all three washing machines have the same number of 
//dresses.
// 
//
// 
// Constraints: 
//
// 
// n == machines.length 
// 1 <= n <= 10⁴ 
// 0 <= machines[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 👍 169 👎 0

package com.coder.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SuperWashingMachines {
    public static void main(String[] args) {
        Solution solution = new SuperWashingMachines().new Solution();

        solution.findMinMoves(new int[]{0,3,0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int machine : machines) {
            sum += machine;
        }
        if (sum % machines.length != 0) return -1;
        int v = sum / machines.length;
        int ans = 0; sum = 0;
        for (int machine : machines) {
            machine -= v;
            sum += machine;
            ans = Math.max(ans, machine);
            ans = Math.max(ans, Math.abs(sum));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}