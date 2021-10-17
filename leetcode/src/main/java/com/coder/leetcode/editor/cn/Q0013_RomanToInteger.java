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
// Given a roman numeral, convert it to an integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "III"
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: s = "IV"
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: s = "IX"
//Output: 9
// 
//
// Example 4: 
//
// 
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 15 
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). 
// It is guaranteed that s is a valid roman numeral in the range [1, 3999]. 
// 
// Related Topics 哈希表 数学 字符串 👍 1503 👎 0

package com.coder.leetcode.editor.cn;

import java.util.*;

public class Q0013_RomanToInteger {
    public static void main(String[] args) {
        Solution solution = new Q0013_RomanToInteger().new Solution();


        /**
         * [-2,-1,0,1,2]
         * [-3,-1,2,4,5]
         * 3
         */

        solution.kthSmallestProduct(new int[] {-2, -1, 0, 1,2}, new int[] {-3, -1, 2, 4, 5}, 3);


        /**
         * [[0,1],[0,2],[1,2]]
         * [0,10,10]
         */

        solution.networkBecomesIdle(new int[][]{{0,1}, {0,2}, {1,2}}, new int[]{0,10,10});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         *         I             1
         *         V             5
         *         X             10
         *         L             50
         *         C             100
         *         D             500
         *         M             1000
         */

        private int getNum(char numa) {
             switch (numa) {
                 case 'I': return 1;
                 case 'V': return 5;
                 case 'X': return 10;
                 case 'L': return 50;
                 case 'C': return 100;
                 case 'D': return 500;
                 case 'M': return 1000;
                 default: return 0;
            }
        }


        private boolean containsChar(String resource, char ch) {
            for (char c : resource.toCharArray()) {
                if (c == ch) {
                    return true;
                }
            }
            return false;
        }

        private int nextStep(char[] nums, int index) {
            if (index < nums.length -1) {
                switch (nums[index]) {
                    case 'I': if (containsChar("VX", nums[index+1])) return 2;
                    case 'X': if (containsChar("LC", nums[index+1])) return 2;
                    case 'C': if (containsChar("DM", nums[index+1])) return 2;
                }
            }
            return 1;
        }

        private int getNum(char[] nums, int index, int step) {
            if (step == 1) {
                return getNum(nums[index]);
            } else {
                return getNum(nums[index+1]) - getNum(nums[index]);
            }
        }

        public int romanToInt(String s) {
            char[] nums = s.toCharArray();
            int index = 0;
            int result = 0;
            while (index < nums.length) {
                int step = nextStep(nums, index);
                result += getNum(nums, index, step);
                index += step;
            }
            return result;
        }

        public boolean winnerOfGame(String colors) {
            int a = 0, b = 0;
            for (int i = 1; i < colors.length() - 1; i++) {
                if (colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i+1) == 'A') {
                    a++;
                }

                if (colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i+1) == 'B') {
                    b++;
                }
            }
            return a > b;
        }


        private boolean[] visited;
        Map<Integer, List<Integer>> map;
        int[] dis;
        public int networkBecomesIdle(int[][] edges, int[] patience) {
            map = new HashMap<>();
            dis = new int[patience.length];
            for (int[] edge : edges) {
                map.merge(edge[0], new ArrayList<>(Arrays.asList(edge[1])), (v1, v2) -> {
                    v1.addAll(v2); return v1;
                });

                map.merge(edge[1], new ArrayList<>(Arrays.asList(edge[0])), (v1, v2) -> {
                    v1.addAll(v2); return v1;
                });
            }
            visited = new boolean[patience.length];
            bfs(0);
            int max = 0;
            for (int i = 1; i < dis.length; i++) {
                max = Math.max(max, getEnd(dis[i], patience[i]));
            }
            return max;
        }

        private int getEnd(int dis, int patience) {
            if (patience >= 2 * dis) {
                return 2 * dis;
            } else {
                return (2 * dis -1) / patience * patience + 2 * dis;
            }
        }

        private void bfs(int s) {
            Queue<Integer> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();
            queue1.offer(s);
            int distance = 0;
            while (!queue1.isEmpty()) {

                while (!queue1.isEmpty()) {
                    int u = queue1.poll();
                    if (!visited[u]) {
                        visited[u] = true;
                        dis[u] = distance;
                        for (int v : map.get(u)) {
                            if (!visited[v]) {
                                queue2.offer(v);
                            }
                        }
                    }
                }
                distance++;
                Queue<Integer> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
            }
        }


        class Node {
            private int[] nums;
            private int i;
            private int mul;

            public Node(int[] nums, int mul) {
                this.nums = nums;
                this.mul = mul;
                if (mul > 0) {
                    i = 0;
                } else {
                    i = nums.length - 1;
                }
            }

            long getValue() {
                return (long)nums[i] * mul;
            }

            void next() {
                i += mul > 0 ? 1 : -1;
            }

            boolean isValid() {
                return i >= 0 && i < nums.length;
            }
        }

        public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
            if (nums1.length > nums2.length) return kthSmallestProduct(nums2, nums1, k);
            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(Node::getValue));
            for (int i = 0; i < nums1.length; i++) {
                pq.offer(new Node(nums2, nums1[i]));
            }
            long ans = 0;
            for (int i = 0; i < k; i++) {
                Node poll = pq.poll();
                ans = poll.getValue();
                poll.next();
                if (poll.isValid()) {
                    pq.offer(poll);
                }
            }
            return ans;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}