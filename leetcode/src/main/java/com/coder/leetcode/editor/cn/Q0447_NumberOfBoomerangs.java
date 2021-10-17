//You are given n points in the plane that are all distinct, where points[i] = [
//xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance 
//between i and j equals the distance between i and k (the order of the tuple matters).
// 
//
// Return the number of boomerangs. 
//
// 
// Example 1: 
//
// 
//Input: points = [[0,0],[1,0],[2,0]]
//Output: 2
//Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]
//].
// 
//
// Example 2: 
//
// 
//Input: points = [[1,1],[2,2],[3,3]]
//Output: 2
// 
//
// Example 3: 
//
// 
//Input: points = [[1,1]]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// All the points are unique. 
// 
// Related Topics 数组 哈希表 数学 👍 220 👎 0

package com.coder.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q0447_NumberOfBoomerangs {
    public static void main(String[] args) {
        Solution solution = new Q0447_NumberOfBoomerangs().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int n = points.length;
            int[][] dis = new int[n+1][n+1];
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    dis[i][j] = disP(points[i], points[j]);
                    dis[j][i] = dis[i][j];
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                Map<Integer, Integer> map = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    map.merge(dis[i][j], 1, Integer::sum);
                }
                ans += getAns(map);
            }
            return ans;
        }

        private int getAns(Map<Integer, Integer> map) {
            int ans = 0;
            for(int v :map.values()) {
                ans += v * (v-1);
            }
            return ans;
        }

        private int disP(int[] point1, int[] point2) {
            return (point1[0]-point2[0]) * (point1[0]-point2[0]) + (point1[1]-point2[1])*(point1[1]-point2[1]);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}